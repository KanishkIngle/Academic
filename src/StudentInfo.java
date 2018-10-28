/*Write a GUI based program to store and retrive ,delete and update Student's infromation in DataBase*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentInfo {
    //Design
    JFrame Registration;
    JLabel Header,TableName,Name,PhNumber,EMail,Age,ChooseUser,ConfirmPass,Addr,adjust;
    JTextField NameField,PhField,EMailField,AgeField,ChooseUserField,AddrField;
    JPasswordField ConfirmPassField;
    JButton Register,Cancel,Delete,Update;
    JTable Details;
    // DataBase Connection
    Connection conn=null;
    ResultSet rs= null;
    PreparedStatement pst=null;

    StudentInfo(){
        Header =new JLabel("Store Student Info");
        TableName=new JLabel("Sr.no            Name          Phone           E-Mail        Address        Age        Login         Password");
        Registration = new JFrame("Student Registration");
        Name = new JLabel("Name");
        PhNumber = new JLabel("Phone No.");
        EMail = new JLabel("E-Mail");
        Age = new JLabel("Age");
        ChooseUser = new JLabel("Choose username");
        ConfirmPass= new JLabel("Confirm password");
        Addr = new JLabel("Address");
        NameField = new JTextField();
        PhField = new JTextField();
        EMailField = new JTextField();
        AgeField = new JTextField();
        ChooseUserField = new JTextField();
        AddrField = new JTextField();
        ConfirmPassField=new JPasswordField();
        Register=new JButton("Register");
        Cancel =new JButton("Cancel");
        Delete=new JButton("Delete");
        Update=new JButton("Update");
        adjust=new JLabel();
        Details =new JTable();
        // Setting Bounds
        Header.setBounds(147,71,147,22);
        TableName.setBounds(300,95,500,22);
        Name.setBounds(86,126,40,14);
        PhNumber.setBounds(62,152,70,14);
        EMail.setBounds(85,178,40,14);
        Age.setBounds(94,209,28,14);
        ChooseUser.setBounds(18,235,110,14);
        ConfirmPass.setBounds(28,266,110,14);
        Addr.setBounds(74,305,50,14);
        NameField.setBounds(134,124,150,20);
        PhField.setBounds(134,150,150,20);
        EMailField.setBounds(134,176,150,20);
        AgeField.setBounds(134,207,150,20);
        ChooseUserField.setBounds(134,234,150,20);
        ConfirmPassField.setBounds(134,266,150,20);
        AddrField.setBounds(134,301,150,20);
        Register.setBounds(75,361,85,23);
        Details.setBounds(300,130,500,180);
        Cancel.setBounds(176,361,75,23);
        Delete.setBounds(391,359,85,23);
        Update.setBounds(534,359,85,23);
        //Table
        Details.setModel(
                new DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null,null,null,null},
                                {null, null, null, null, null,null,null,null},
                                {null, null, null, null, null,null,null,null},
                                {null, null, null, null, null,null,null,null},
                                {null, null, null, null, null,null,null,null},
                                {null, null, null, null, null,null,null,null},
                                {null, null, null, null, null,null,null,null}
                        },
                        new String []{
                                "Address", "Age", "Contact", "E-Mail", "Name","Login","Password","Sr.no"
                        }

                )
        );
        // adding to frame
        Registration.add(Header);
        Registration.add(TableName);
        Registration.add(Name);
        Registration.add(PhNumber);
        Registration.add(EMail);
        Registration.add(Age);
        Registration.add(ChooseUser);
        Registration.add(ConfirmPass);
        Registration.add(Addr);
        Registration.add(NameField);
        Registration.add(PhField);
        Registration.add(EMailField);
        Registration.add(AgeField);
        Registration.add(ChooseUserField);
        Registration.add(ConfirmPassField);
        Registration.add(AddrField);
        Registration.add(Register);
        Registration.add(Cancel);
        Registration.add(Details);
        Registration.add(Update);
        Registration.add(Delete);
        Registration.add(adjust);
        //setting Frame
        Registration.setVisible(true);
        Registration.setSize(900,500);
        Registration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Registration.setResizable(false);
        Registration.setLayout(null);
        // Actions
        Register.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String Phone=PhField.getText();
                        String Name=NameField.getText();
                        String Mail = EMailField.getText();
                        String Age = AgeField.getText();
                        String Address =AddrField.getText();
                        String UserName=ChooseUserField.getText();
                        String password=ConfirmPassField.getText();

                        String sql="insert into academic.student(Name,Phone,Mail,Address,Age,UserName,Password) values(?,?,?,?,?,?,?)";

                        try{
                            conn=getConnection();
                            pst=conn.prepareStatement(sql);

                            pst.setString(1,Name);
                            pst.setString(2,Phone);
                            pst.setString(3,Mail);
                            pst.setString(4,Address);
                            pst.setString(5,Age);
                            pst.setString(6,UserName);
                            pst.setString(7,password);

                            int res=pst.executeUpdate();
                            if (res==1){
                                JOptionPane.showMessageDialog(null,"Registration Successful !");
                                // rs.close();
                                pst.close();
                            }else{
                                JOptionPane.showMessageDialog(null,"Registration Failed !");
                            }
                            conn.close();
                        }catch(Exception excp){
                            JOptionPane.showMessageDialog(null,excp);
                        }
                    }
                }
        );

        Cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        NameField.setText("");
                        PhField.setText("");
                        EMailField.setText("");
                        AgeField.setText("");
                        ChooseUserField.setText("");
                        ConfirmPassField.setText("");
                        AddrField.setText("");
                    }
                }
        );
        Delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            conn=getConnection();
                            int row= Details.getSelectedRow();
                            Object rowdelete= Details.getModel().getValueAt(Details.getSelectedRow(),0);
                            String s=rowdelete.toString();
                            String del="delete from academic.student where ID="+s;

                            pst=conn.prepareStatement(del);
                            pst.executeUpdate();
                            pst=conn.prepareStatement("select * from academic.student");
                            ResultSet rs=pst.executeQuery();
                            Details.setModel(DbUtils.resultSetToTableModel(rs));


                            JOptionPane.showMessageDialog(null," Deleted Successfully!");
                        }catch(Exception excp){
                            JOptionPane.showMessageDialog(null, excp);
                        }
                    }
                }
        );
        Update.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            conn=getConnection();
                            pst=conn.prepareStatement("select * from academic.student");
                            ResultSet rs=pst.executeQuery();
                            Details.setModel(DbUtils.resultSetToTableModel(rs));

                        }
                        catch(Exception exp)
                        {
                            JOptionPane.showMessageDialog(null, exp);
                        }
                    }
                }
        );
}

    public  Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error","Database Connection",JOptionPane.PLAIN_MESSAGE);
        }
        return  conn;
    }

    public  static  void main(String args[]){
        StudentInfo SI=new  StudentInfo();

    }
}
