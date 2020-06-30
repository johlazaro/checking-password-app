/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author John T Lazaro
 */
public class RegisterForm extends JFrame{
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel genderLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel securityQuestionLabel;
    private JLabel seculityAnswerLabel;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField dateOfBirthField;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private ButtonGroup genderGroup;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JComboBox questionCombobox;
    private JTextField comboAnswerField;
    private JPanel mainPanel;
    private JPanel radioPanel;
    private JLabel message;
    private JPanel formPanel;
    private JButton resetbutton;
    private JButton sendbutton;
    private GridBagConstraints gbc;
    
    public RegisterForm(){
        setTitle("register");
        mainPanel=new JPanel();
        mainPanel.setLayout(new FlowLayout());
        formPanel=new JPanel();
        formPanel.setPreferredSize(new Dimension(560,560));
        formPanel.setLayout(new GridBagLayout());
        //formPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //components
        /**
         * labels
         */
        gbc=new GridBagConstraints();
        gbc.anchor=GridBagConstraints.LINE_END;
        gbc.insets=new Insets(3,3,3,3);
        gbc.gridx=0;
        gbc.gridy=0;
        firstnameLabel=new JLabel("Firstname");
        firstnameLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(firstnameLabel,gbc);
        gbc.gridy+=1;
        lastnameLabel=new JLabel("Lastname");
        lastnameLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(lastnameLabel,gbc);
        gbc.gridy+=1;
        dateOfBirthLabel=new JLabel("Date of Birth");
        dateOfBirthLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(dateOfBirthLabel,gbc);
        gbc.gridy+=1;
        genderLabel=new JLabel("Gender");
        genderLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(genderLabel,gbc);
        gbc.gridy+=1;
        passwordLabel=new JLabel("Password");
        passwordLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(passwordLabel,gbc);
        gbc.gridy+=1;
        confirmPasswordLabel=new JLabel("Confirm Password");
        confirmPasswordLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(confirmPasswordLabel,gbc);
        gbc.gridy+=1;
        securityQuestionLabel=new JLabel("Secirity Question");
        securityQuestionLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(securityQuestionLabel,gbc);
        gbc.gridy+=1;
        seculityAnswerLabel=new JLabel("Security Answer");
        seculityAnswerLabel.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(seculityAnswerLabel,gbc);
        /**
         * text field
         */
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.gridx=1;
        gbc.gridy=0;
        firstnameField=new JTextField(19);
        firstnameField.setFont(new Font("tahoma",Font.PLAIN,14));
        firstnameField.setPreferredSize(new Dimension(200,35));
        formPanel.add(firstnameField,gbc);
        gbc.gridy+=1;
        lastnameField=new JTextField(19);
        lastnameField.setFont(new Font("tahoma",Font.PLAIN,14));
        lastnameField.setPreferredSize(new Dimension(200,35));
        formPanel.add(lastnameField,gbc);
        gbc.gridy+=1;
        dateOfBirthField=new JTextField(19);
        dateOfBirthField.setPreferredSize(new Dimension(200,35));
        dateOfBirthField.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(dateOfBirthField,gbc);
        /**
         * radio button
         */
        gbc.gridy+=1;
        maleButton=new JRadioButton("male");
        maleButton.setFont(new Font("tahoma",Font.PLAIN,14));
        femaleButton=new JRadioButton("female");
        femaleButton.setFont(new Font("tahoma",Font.PLAIN,14));
        genderGroup=new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        radioPanel=new JPanel();
        radioPanel.setPreferredSize(new Dimension(228,35));
        radioPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(maleButton);
        radioPanel.add(femaleButton);
        formPanel.add(radioPanel,gbc);
        /**
         * password field
         */
        gbc.gridy+=1;
        passwordField=new JPasswordField(21);
        passwordField.setPreferredSize(new Dimension(200,35));
        formPanel.add(passwordField,gbc);
        gbc.gridy+=1;
        confirmPasswordField=new JPasswordField(21);
        confirmPasswordField.setPreferredSize(new Dimension(200,35));
        formPanel.add(confirmPasswordField,gbc);
        gbc.gridx=2;
        message=new JLabel();
        formPanel.add(message,gbc);
        /**
         * COMBO BOX
         */
        gbc.gridx=1;
        gbc.gridy+=1;
        String[] questions={"----select----",
                            "what's your mother's name",
                            "what's your favourite food",
                            "what's your preferred game"};
        questionCombobox=new JComboBox(questions);
        questionCombobox.setFont(new Font("tahoma",Font.PLAIN,14));
        questionCombobox.setPreferredSize(new Dimension(228,35));
        formPanel.add(questionCombobox,gbc);
        gbc.gridy+=1;
        comboAnswerField=new JTextField(19);
        comboAnswerField.setFont(new Font("tahoma",Font.PLAIN,14));
        comboAnswerField.setPreferredSize(new Dimension(200,35));
        formPanel.add(comboAnswerField,gbc);
        /**
         * button 
         */
        
        gbc.gridy+=1;
        gbc.anchor=GridBagConstraints.LAST_LINE_END;
        sendbutton=new JButton("Send");
        sendbutton.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                Sql sql=new Sql();
                boolean done=true;
                String gender=null;
                String password=null;
                String firstname=firstnameField.getText();
                String lastname=lastnameField.getText();
                String date=dateOfBirthField.getText();
                if(maleButton.isSelected())
                    gender="M";
                else
                    gender="F";
                String pass1=passwordField.getText();
                String pass2=confirmPasswordField.getText();
                if(pass1.compareTo(pass2)==0)
                    password=pass1;
                else{
                    JOptionPane.showMessageDialog(null, "unmatch Password","SQL info",JOptionPane.INFORMATION_MESSAGE);
                    message.setText("*");
                    message.setFont(new Font("tahoma",Font.ITALIC,12));
                    done=false;
                }
                String question=(String)questionCombobox.getSelectedItem();
                String answer=comboAnswerField.getText();
                if(firstname.isEmpty()||lastname.isEmpty()||date.isEmpty()||gender==null||pass1.isEmpty()||pass2.isEmpty()||question.isEmpty()||answer.isEmpty()){
                    JOptionPane.showMessageDialog(null,"some fields are empty");
                    done=false;
                }
                    
                if(done){
                sql.addUser(firstname, lastname, date, gender, password, question, answer);
                JOptionPane.showMessageDialog(null,"upload success");
                /**
                 * reset all field
                */
                 reset();
                }
                sql.close();
                
        }
        });
        sendbutton.setPreferredSize(new Dimension(100,35));
        sendbutton.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(sendbutton,gbc);
        resetbutton=new JButton("Reset");
        resetbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            reset();
            }
        });
        resetbutton.setPreferredSize(new Dimension(100,35));
        gbc.anchor=GridBagConstraints.LAST_LINE_START;
        resetbutton.setFont(new Font("tahoma",Font.PLAIN,14));
        formPanel.add(resetbutton,gbc);
        
        
        //add component to the frame
        mainPanel.add(formPanel);
        getContentPane().add(mainPanel);
        /**
         * LOOK AND FELL
         */
       try{
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
           //system look and feel
       }
       /**
        * register form 
        */
        setVisible(true);
        setSize(560,680);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void reset(){
         firstnameField.setText("");
         lastnameField.setText("");
         dateOfBirthField.setText("");
         maleButton.setSelected(false);
         femaleButton.setSelected(false);
         passwordField.setText("");
         confirmPasswordField.setText("");
         questionCombobox.setSelectedIndex(0);
         comboAnswerField.setText("");
         message.setText("");
    }
    
}
