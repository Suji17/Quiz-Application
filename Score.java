package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    JButton submit;
    Score(String name,int score){
        
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/score.png"));
        Image i2=i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,150,300,250);
        add(image);
        
        JLabel heading=new JLabel("THANK YOU "+name+" for attend this Quiz!!");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);
        
        JLabel lblscore=new JLabel("Your score is "+score);
        lblscore.setBounds(450, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblscore);
        
        JButton submit =new JButton("Do Again");
        submit.setBounds(460,270,120,30);
        //submit.setFont(new Font("Tahoma",Font.PLAIN,25));
        submit.setBackground(Color.pink);
        submit.setForeground(Color.white);
        //submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();       
    }
    
    public static void main(String ar[]){
        new Score("User",0);
    }    
}
