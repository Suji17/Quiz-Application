
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton rules,back;//globally decalred
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/login.jpeg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);
        
        JLabel heading=new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        add(heading);
        
        JLabel name=new JLabel("Enter your name");
        name.setBounds(810, 150, 300,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        name.setForeground(new Color(30,144,254));//color using rgb
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(740,200,300,25);
        tfname.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(tfname);
        
        rules=new JButton("Rules");
        rules.setBounds(740, 260, 100, 20);
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.white);
        rules.addActionListener(this);
        add(rules);
        
        back=new JButton("Back");
        back.setBounds(900, 260, 100, 20);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setSize(1200,500);
        setLocation(170,120);
        setVisible(true);
        
    }
    
    //button action event
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==rules)
        {
            String name=tfname.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
        }
    }
    
    public static void main(String ar[])
    {
       new Login();
    }
}
