/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author John T Lazaro
 */
public class Sql {
    //constant declaration
    private static final String DATABASE_URL="jdbc:mysql://41.86.177.187:3306/password";
    private static final String USERNAME="root";
    private static final String PASS="john1997";
    //constant
    private Connection conn=null;
    private PreparedStatement insertStm=null; 
    private ResultSet result1,result2,result3,result4=null;
    private PreparedStatement getUser=null;
    private PreparedStatement getQuestion=null;
    private PreparedStatement getAnswer=null;
    private PreparedStatement userExist=null;
    //Sql Constructor
    public Sql( ) {
     try{
        Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(DATABASE_URL,USERNAME,PASS);
        // insert new user
	String query1="insert into user(firstname,lastname,date,gender,password,security_question,security_answer)" 
                + " values (?,?,?,?,?,?,?)";
	insertStm=conn.prepareStatement(query1);
        //get user
        String query2="select password from user where firstname=?";
        getUser=conn.prepareStatement(query2);
        //get question
        String query3="select security_question from user where firstname=?";
        getQuestion=conn.prepareStatement(query3);
        //get answer
        String query4="select security_answer from user where firstname=?";
        getAnswer=conn.prepareStatement(query4);
        //search for user
        String query5="select firstname from user";
        userExist=conn.prepareStatement(query5);
	//JOptionPane.showMessageDialog(null,"connection successful","Sql Info",JOptionPane.INFORMATION_MESSAGE);
	}
      catch(Exception e){
          JOptionPane.showMessageDialog(null,e,"Sql Info",JOptionPane.INFORMATION_MESSAGE);
      }
      
    }
    public void addUser(String firstname,String lastname,String date ,String gender,String pass,String question,String answer){
        try
        {
        insertStm.setString(1,firstname);
        insertStm.setString(2,lastname);
        insertStm.setString(3,date);
        insertStm.setString(4,gender);
        insertStm.setString(5,pass);
        insertStm.setString(6,question);
        insertStm.setString(7,answer);
        insertStm.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"user exist");
        }
        
    }
    public String getUser(String username){
        String password=null;
        try{
            getUser.setString(1, username);
            result1=getUser.executeQuery();
            while(result1.next()){
            password=result1.getString("password");
        }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e);
        }
       return password;
    }
    //get security question
      public String getSecurityQuestion(String username){
        String question=null;
        try{
            getQuestion.setString(1, username);
            result2=getQuestion.executeQuery();
            while(result2.next()){
            question=result2.getString("security_question");
            if(question.isEmpty())
                JOptionPane.showMessageDialog(null,"is empty");
        }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"hi");
        }
       return question;
      }
      
       public String getSecurityAnswer(String username){
        String answer=null;
        try{
            getAnswer.setString(1, username);
            result3=getAnswer.executeQuery();
            while(result3.next()){
            answer=result3.getString("security_answer");
        }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e);
        }
       return answer;
    }
       //checking if user exist
       public ArrayList<String> checkUser(){
           ArrayList<String> arrlist=new ArrayList<>();
           try{
           result4=userExist.executeQuery();
           while(result4.next()){
               arrlist.add(result4.getString("firstname"));
           }
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e);
           }
           return arrlist;
       }
    public void close(){
       try{
           conn.close();
           insertStm.close();
        }catch(SQLException ex){
           
       }
   
    }
}
