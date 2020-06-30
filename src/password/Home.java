/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author John T Lazaro
 */
public class Home extends JFrame {
    private JButton homeButton;
    private JButton registerButton;
    private JPanel topPanel;
    public Home() throws ClassNotFoundException, InstantiationException{
        setTitle("home page");
         try{
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
           //system look and feel
       }
        topPanel=new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setPreferredSize(new Dimension(320,50));
        homeButton=new JButton();
        registerButton=new JButton(); 
        registerButton.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                new RegisterForm();
                dispose();
            }
        });
        homeButton.setPreferredSize(new Dimension(150,40));
        homeButton.setText("LOGIN");
        homeButton.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                new LoginForm();
                dispose();
            }
        });
        homeButton.setFont(new Font("tahoma",Font.PLAIN,14));
        registerButton.setPreferredSize(new Dimension(150,40));
        registerButton.setText("CREATE ACCOUNT");
        registerButton.setFont(new Font("tahoma",Font.PLAIN,14));
        topPanel.add(homeButton);
        topPanel.add(registerButton);
        getContentPane().add(topPanel);
        //set feel and look
       /* *try{
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        *catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex){
            //ignore
        }*/
      
       
        //set visible 
        setVisible(true);
        setSize(560,640);
        setLocationRelativeTo(null);
              
        
    }
            
    
}
