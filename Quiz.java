
package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener
{
    String questions[][]=new String[10][5];
    String answers[][]=new String[10][2];
    String user_answers[][]=new String[10][1];
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,submit;
    ButtonGroup grpoptions;
    
    public static int timer=15;
    public static int ans_given=0;
    public static int count=0;
    public static int score=0;
    
    public String name;
    
    Quiz(String name){
        this.name=name;
        setBounds(0,0,1440,850);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/quiz.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1400,390);
        add(image);
        
        qno=new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(qno);
        
        question=new JLabel();
        question.setBounds(150, 450, 1000, 30);
        question.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(question);
        
        questions[0][0]="Which of the following is not a valid keyword in Java?";
        questions[0][1]="static";
        questions[0][2]="public";
        questions[0][3]="void";  
        questions[0][4]="main";
        
        questions[1][0]="What is the default value of a boolean variable in Java?";
        questions[1][1]="true";
        questions[1][2]="false";
        questions[1][3]="null";
        questions[1][4]="0";        
        
        questions[2][0]="Which of the following is not an access modifier in Java?";
        questions[2][1]="public";
        questions[2][2]="protected";
        questions[2][3]="private";
        questions[2][4]="friend";
        
        questions[3][0]="Which class is the superclass of all classes in Java?";
        questions[3][1]="Object";
        questions[3][2]="String";
        questions[3][3]="Class";
        questions[3][4]="Serializable";
        
        questions[4][0]="Which of the following collections can contain duplicate elements?";
        questions[4][1]="HashSet";
        questions[4][2]="TreeSet";
        questions[4][3]="ArrayList";
        questions[4][4]="HashMap";
        
        questions[5][0]="Which exception is thrown when a program attempts to divide by zero?";
        questions[5][1]="ArithmeticException";
        questions[5][2]="NullPointerException";
        questions[5][3]="ArrayIndexOutOfBoundsException";
        questions[5][4]="ClassCastException";
        
        questions[6][0]="Which of the following methods can be overridden in a subclass?";
        questions[6][1]="private";
        questions[6][2]="static";
        questions[6][3]="final";
        questions[6][4]="public";
        
        questions[7][0]="What is the purpose of the final keyword in Java?";
        questions[7][1]="It defines a constant";
        questions[7][2]="It indicates that a method cannot be overridden";
        questions[7][3]="It indicates that a class cannot be inherited";
        questions[7][4]="All of the above";
        
        questions[8][0]="Which of the following statements is true about the StringBuilder class?";
        questions[8][1]="It is immutable";
        questions[8][2]="It is synchronized";
        questions[8][3]="It can be used to create mutable strings";
        questions[8][4]="It is part of the java.util package";
        
        questions[9][0]="output?-System.out.println(10 + 20 + '30')";
        questions[9][1]="30";
        questions[9][2]="2030";
        questions[9][3]="20";
        questions[9][4]="30";
        
        answers[0][1]="main";
        answers[1][1]="false";
        answers[2][1]="friend";
        answers[3][1]="Object";
        answers[4][1]="ArrayList";
        answers[5][1]="ArithmeticException";
        answers[6][1]="public";
        answers[7][1]="All of the above";
        answers[8][1]="It can be used to create mutable strings";
        answers[9][1]="1030";
        
        opt1=new JRadioButton();
        opt1.setBounds(170,520,700,30);
        add(opt1);
        
        opt2=new JRadioButton();
        opt2.setBounds(170,560,700,30);
        add(opt2);
        
        opt3=new JRadioButton();
        opt3.setBounds(170,600,700,30);
        add(opt3);
        
        opt4=new JRadioButton();
        opt4.setBounds(170,640,700,30);
        add(opt4);
        
        grpoptions=new ButtonGroup();
        grpoptions.add(opt1);
        grpoptions.add(opt2);
        grpoptions.add(opt3);
        grpoptions.add(opt4);
        
        next =new JButton("Next");
        next.setBounds(1100,550,100,30);
        next.setBackground(new Color(30,144,254));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        
        submit =new JButton("submit");
        submit.setBounds(1100,630,100,30);
        submit.setBackground(new Color(30,144,254));
        submit.setForeground(Color.white);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        start(count);        
         
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next)
        {
            repaint();
            
            ans_given=1;
            if(grpoptions.getSelection()==null){
                user_answers[count][0]="";
            }else{
                user_answers[count][0]=grpoptions.getSelection().getActionCommand();                
            }
            
            if(count==8)//9th qn
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
            
        }else if(ae.getSource()==submit){
            ans_given=1;
            if(grpoptions.getSelection()==null){
                user_answers[count][0]="";
                }else{
                    user_answers[count][0]=grpoptions.getSelection().getActionCommand();                
                }
                
                for(int i=0;i<user_answers.length;i++){
                    if(user_answers[i][0].equals(answers[i][1])){
                        score+=10;
                    }else{
                        score+=0;
                    }                   
                }
                setVisible(false);
                new Score(name,score);
            
        }
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        String time="Time Left "+timer+" seconds";//initially 15
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma",Font.BOLD,20));
        
        if(timer>0){
            g.drawString(time, 1100, 500);            
        }else{
            g.drawString("Times up!!", 1100, 500); 
        }
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given==1){
            ans_given=0;
            timer=15;
        }else if(timer<0)
        {
            timer=15;
            
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9)//submit button 
            {
                if(grpoptions.getSelection()==null){
                user_answers[count][0]="";
                }else{
                    user_answers[count][0]=grpoptions.getSelection().getActionCommand();                
                }
                
                for(int i=0;i<user_answers.length;i++){
                    if(user_answers[i][0].equals(answers[i][1])){
                        score+=10;
                    }else{
                        score+=0;
                    }                   
                }
                setVisible(false);
                new Score(name,score);
                
                
            }else
            {//next button
                if(grpoptions.getSelection()==null){
                user_answers[count][0]="";
                }else{
                    user_answers[count][0]=grpoptions.getSelection().getActionCommand();                
                }
                count++;//0,1,2,..
                start(count);
                
            }            
        }
        
    }
        
    public void start(int count){
        qno.setText("" + (count + 1) +". ");
        question.setText(questions[count][0]);
        
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        grpoptions.clearSelection();
        
    }
        
    public static void main(String ar[]){
        new Quiz("User");
        
    }    
}
