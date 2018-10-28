
/*
Write a GUI Based Program to create a student registration and login.store Registration data in DataBase and take Login info. from DataBase
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Student  {
    // Design
JFrame StudentLogin;
JLabel Login,userName,Password,just;
JTextField UserField;
JPasswordField PassField;
JButton Signin,Register;
 // DataBase Connection
    static Connection conn=null;
    ResultSet rs =null;
    PreparedStatement pst=null;

Student(){

    // creating Objects
StudentLogin = new JFrame("Student Login");
UserField = new JTextField();
PassField = new JPasswordField();
Login = new JLabel("Login");
userName = new JLabel("username");
Password = new JLabel("password");
UserField = new JTextField();
PassField = new JPasswordField();
Signin = new JButton("Login");
Register =new JButton("Register");
just= new JLabel();
    // setting alignment
    Login.setBounds(158,48,99,23);
    userName.setBounds(48,115,70,16);
    Password.setBounds(48,154,70,16);
    UserField.setBounds(117,110,150,20);
    PassField.setBounds(117,151,150,20);
    Signin.setBounds(142,195,70,23);
    Register.setBounds(142,239,90,23);
    StudentLogin.add(userName);
    StudentLogin.add(Password);
    StudentLogin.add(Login);
    StudentLogin.add(UserField);
    StudentLogin.add(PassField);
    StudentLogin.add(Signin);
    StudentLogin.add(Register);

    StudentLogin.add(just);
    StudentLogin.setVisible(true);
    StudentLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    StudentLogin.setSize(350,400);
    StudentLogin.setResizable(false);
    StudentLogin.setLayout(null);

    Signin.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                            String sql ="select * from academic.student where UserName =? and Password=?";
                            try{
                                conn= getConnection();
                                pst=conn.prepareStatement(sql);
                                pst.setString(1,UserField.getText());
                                pst.setString(2,PassField.getText());
                                rs= pst.executeQuery();
                                if(rs.next()){
                                        JOptionPane.showMessageDialog(null,"Login Successful !");
                                        rs.close();
                                        pst.close();
                                }else{
                                    JOptionPane.showMessageDialog(null,"Login Failed !");
                                }
                            }catch (Exception excp){
                                JOptionPane.showMessageDialog(null,excp);
                            }
                            UserField.setText("");
                            PassField.setText("");
                }
            }
    );

    Register.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StudentReg SR= new StudentReg();

                }
            }
    );
}

public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Database Connection",JOptionPane.PLAIN_MESSAGE);
        }
        return  conn;
}

public static void main(String args[]){
Student S = new Student();

}

}
