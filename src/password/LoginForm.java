package password;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John T Lazaro
 */
public class LoginForm extends JFrame
{
    private javax.swing.JLabel usernameLabel; 
    private javax.swing.JPanel framePanel;
    private int max=1;
    private  Sql sql,s;
    private boolean done=false;
    private JLabel forgetLabel;
    private JLabel spaceLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.border.Border loginTitle;
    private javax.swing.JTextField usernameField;
    private javax.swing.JPasswordField passwordField;
    private JCheckBox forgetBox;
    private javax.swing.JButton loginButton;
    private ShowPassword show;
    private java.awt.GridBagConstraints  g=new java.awt.GridBagConstraints();;
    private java.awt.Dimension dm,d;
    private String input,username1;
    private String username;
    
    public LoginForm(){
        framePanel=new javax.swing.JPanel();
        usernameField=new javax.swing.JTextField(20);
        passwordField=new javax.swing.JPasswordField(20);
        loginButton=new javax.swing.JButton("Login");
        passwordLabel=new javax.swing.JLabel("Password: ");
        passwordLabel.setFont(new java.awt.Font("tahoma",java.awt.Font.PLAIN,16));
        usernameLabel=new javax.swing.JLabel();
        usernameLabel.setText("Username: ");
        usernameLabel.setFont(new java.awt.Font("tahoma",java.awt.Font.PLAIN,16));
        dm=new java.awt.Dimension(60, 35);
        d=new java.awt.Dimension(100,32);
        usernameField.setPreferredSize(dm);
        usernameField.setFont(new java.awt.Font("tahoma",java.awt.Font.PLAIN,16));
        passwordField.setPreferredSize(dm);
        passwordField.setFont(new java.awt.Font("tahoma",java.awt.Font.PLAIN,16));
        loginButton.setPreferredSize(d);
        //panels
        framePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginPanel=new javax.swing.JPanel();
        loginPanel.setPreferredSize(new java.awt.Dimension(460,400));
        loginTitle=BorderFactory.createTitledBorder("login Form");
        loginPanel.setBorder(loginTitle);
        //loginPanel.setBackground(new java.awt.Color(248,252,238));
        loginPanel.setLayout(new java.awt.GridBagLayout());
        /**
         * layout components to the login panel
         */
        g=new java.awt.GridBagConstraints();
        //labels
        g.insets=new java.awt.Insets(2,2,2,2);
        g.anchor=GridBagConstraints.LINE_END;
        g.gridx=0;
        g.gridy=0;
        loginPanel.add(usernameLabel,g);
        g.gridx=0;
        g.gridy=1;
        loginPanel.add(passwordLabel,g);
        g.anchor=GridBagConstraints.LINE_START;
        g.gridx=1;
        g.gridy=0;
        loginPanel.add(usernameField,g);
        g.gridx=1;
        g.gridy=1;
        loginPanel.add(passwordField,g);
        g.gridx=1;
        g.gridy=2;
        g.anchor=GridBagConstraints.LINE_END;
        loginPanel.add(loginButton,g);
        //forget label
        g.gridy=3;
        g.gridx=1;
        g.anchor=GridBagConstraints.LINE_START;
        g.insets=new Insets(50,50,50,50);
        forgetLabel=new JLabel("Forget your Password :");
        forgetLabel.setVisible(false);
        forgetLabel.setFont(new java.awt.Font("tahoma",java.awt.Font.PLAIN,16));
        forgetBox=new JCheckBox();
        forgetBox.setVisible(false);
        loginPanel.add(forgetLabel,g);
        g.anchor=GridBagConstraints.LINE_END;
        g.insets=new Insets(0,5,0,5);
        loginPanel.add(forgetBox,g);
        //actionListener
        loginButton.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ev){
                Sql s=new Sql();
                String username=usernameField.getText();
                String password=passwordField.getText();
                if(username.isEmpty()||password.isEmpty())
                    JOptionPane.showMessageDialog(null,"fields are empty");
                else { 
                    String pass=s.getUser(username); 
                try{ 
                    if(pass.compareTo(password)==0){
                       Home1 home=new Home1();
                       dispose();
                       home.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"incorect Password");
                        passwordField.setText("");
                        max++;
                        if(max==4){
                            passwordField.setEditable(false);
                            forgetBox.setVisible(true);
                            forgetLabel.setVisible(true);
                            //JOptionPane.showMessageDialog(null,"Forget ");
                        }
                        }
                    s.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"user is not exist");
                    usernameField.setText("");
                    passwordField.setText("");
                }
                }
            }
            });
        
        loginButton.addMouseListener(new java.awt.event.MouseListener(){
            @Override 
            public void mousePressed(java.awt.event.MouseEvent ev){
                
            }
            @Override 
            public void mouseClicked(java.awt.event.MouseEvent ev){
                
            }
            @Override 
            public void mouseReleased(java.awt.event.MouseEvent ev){
                
            }
            @Override 
            public void mouseExited(java.awt.event.MouseEvent ev){
                loginButton.setBackground(new Color(240,240,240));
            }
            @Override 
            public void mouseEntered(java.awt.event.MouseEvent ev){
                loginButton.setBackground(Color.blue);
            }
              
        });
        //forget box lister
        forgetBox.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent e){
            if(forgetBox.isSelected()){
                //JOptionPane.showMessageDialog(null,"am selected");
                s=new Sql();
            input=JOptionPane.showInputDialog(null,"Enter Username:");
            if(input.isEmpty())
                JOptionPane.showMessageDialog(null,"Enter Username:");
            else{
             try{
                ArrayList<String> arrls=s.checkUser();
                if(arrls.contains(input)){
                String question=s.getSecurityQuestion(input);
                show=new ShowPassword(question,input);
                show.setVisible(true);
                dispose();
                }else
                 JOptionPane.showMessageDialog(null,"User Not Found");
             }catch(Exception ev){
                JOptionPane.showMessageDialog(null,ev);
             }
            }
            }
        }
        });
        //feel and look
      try{
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
           //system look and feel
       }
        //frame
        framePanel.add(loginPanel);
        getContentPane().add(framePanel);
        setVisible(true);
        setResizable(false);
        setSize(600,690);
        setLocationRelativeTo(null);
}
}
