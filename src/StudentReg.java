


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class StudentReg {
    //Design
    JFrame Registration;
    JLabel Name,PhNumber,EMail,Age,ChooseUser,ConfirmPass,Addr,adjust;
    JTextField NameField,PhField,EMailField,AgeField,ChooseUserField,AddrField;
    JPasswordField ConfirmPassField;
    JButton Register,Cancel;
    // DataBase Connection
    Connection conn=null;
   // ResultSet rs= null;
    PreparedStatement pst=null;

    StudentReg(){
        //Creating Objects
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
    adjust=new JLabel();
        // Setting Bounds
        Name.setBounds(138,66,40,14);
        PhNumber.setBounds(120,94,70,14);
        EMail.setBounds(136,119,40,14);
        Age.setBounds(145,151,28,14);
        ChooseUser.setBounds(70,177,110,14);
        ConfirmPass.setBounds(70,208,110,14);
        Addr.setBounds(123,245,50,14);
        NameField.setBounds(186,67,150,20);
        PhField.setBounds(186,93,150,20);
        EMailField.setBounds(186,117,150,20);
        AgeField.setBounds(186,148,150,20);
        ChooseUserField.setBounds(186,173,150,20);
        ConfirmPassField.setBounds(186,205,150,20);
        AddrField.setBounds(186,245,150,20);
        Register.setBounds(135,320,85,23);
        Cancel.setBounds(245,320,75,23);
        // adding to frame
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
        Registration.add(adjust);
        //setting Frame
        Registration.setVisible(true);
        Registration.setSize(500,500);
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


}
