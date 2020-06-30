/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

/**
 *
 * @author John T Lazaro
 */
public class ShowPassword extends JPanel {
    	private JPanel panelMain,loginForm;
	private JFrame frame;
        private JLabel securityLabel;
        private JLabel answerLabel;
        private JLabel showLabel;
	private GridBagConstraints c,cb;
	private JTextField questionField;
	private JTextField answerField;
        private JTextField password;
        private Sql sql;
	private JButton showButton;
        private Border title;
	

    public ShowPassword(String question,String username){
    {
	JFrame frame=new JFrame();
	//add the main panel to the frame
	panelMain=new JPanel();
	//create loginform
	loginForm=new JPanel();
        title=BorderFactory.createTitledBorder("Forget password");
	loginForm.setBorder(title);
	loginForm.setLayout(new GridBagLayout());
	c=new GridBagConstraints();
	c.anchor=GridBagConstraints.LINE_END;
	c.insets=new Insets(3,3,3,3);
	c.gridx=0; //setting grid at 0,0 position/cell
	c.gridy=0;
        securityLabel=new JLabel("security question");
        securityLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        loginForm.add(securityLabel,c);
	c.gridy++;
        securityLabel=new JLabel("answer:");	
        securityLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        loginForm.add(securityLabel,c);
	c.gridy++;
        showLabel=new JLabel("Password");
        showLabel.setFont(new Font("tahoma",Font.PLAIN,14));
	loginForm.add(showLabel,c);
	//create textField and add to the loginForm
	c.gridx=1;
	c.gridy=0;
	c.anchor=GridBagConstraints.LINE_START;
	questionField=new JTextField(25);
        questionField.setText(question);
        questionField.setEditable(false);
        questionField.setFont(new Font("tahoma",Font.PLAIN,14));
        questionField.setPreferredSize(new Dimension(200,32));
	loginForm.add(questionField,c);
	c.gridy++;
	answerField=new JTextField(25);  
        answerField.setFont(new Font("tahoma",Font.PLAIN,14));
        answerField.setPreferredSize(new Dimension(200,32));
	loginForm.add(answerField,c);
	c.gridy++;
        password=new JTextField(25);
        password.setFont(new Font("tahoma",Font.PLAIN,14));
        password.setEditable(false);
        password.setPreferredSize(new Dimension(200,32));
        showButton=new JButton("show password");
        showButton.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent ex)
            {   sql=new Sql();
                String answer=answerField.getText();
                String dbAnswer=sql.getSecurityAnswer(username);
                if(answer.compareTo(dbAnswer)==0)
                    password.setText(sql.getUser(username));
            sql.close();
            }
        });
        loginForm.add(password,c);
	//add loginForm to panelmain
	panelMain.add(loginForm);
	frame.getContentPane().add(panelMain);
	cb=new GridBagConstraints();
        cb.anchor=GridBagConstraints.LAST_LINE_END;
	cb.insets=new Insets(2,2,2,2);
	cb.gridx=1;
	cb.gridy=5;
	loginForm.add(showButton,cb);
         //set feel and look
      try{
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
           //system look and feel
       }
        /**
         * frame 
         */
        frame.getContentPane().add(panelMain);
        frame.setSize(560,440);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
    }
    }
}