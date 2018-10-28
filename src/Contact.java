/*
Problem Statement-
        Develop a GUI based application to create Telephone Contacts directory. Store the data
        in standard “vcard” format. Also read any standard “vcard” file and display contacts in it.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Contact {
    Connection conn=null;
    ResultSet res= null;
    PreparedStatement ps=null;

    Contact(){
    //Design
    JFrame Contact;
    JLabel Name,Mob;
    JTextField NameField,MobField;
    JButton Save,Show,Cancel,AddContact;
    JTable Table;
    Object[][] data={
                {null,null},
                {null,null},
                {null,null},
                {null,null},
                {null,null}
        };
    String[] colHeads={"Name","Mobile"};

        //Creating Objects
    Contact= new JFrame("PhoneBook");
    Name= new JLabel("Name'");
    Mob= new JLabel("Mobile No.");
    Save= new JButton("Save");
    Show=new JButton("Show");
    Cancel=new JButton("Cancel");
    AddContact=new JButton("Create");
    NameField= new JTextField();
    MobField=new JTextField();
    Table=new JTable(data,colHeads);
    //setting bounds
    Name.setBounds(35,99,40,18);
    Mob.setBounds(29,141,70,18);
    Save.setBounds(124,186,70,20);
    Show.setBounds(124,220,70,20);
    NameField.setBounds(94,99,150,20);
    MobField.setBounds(94,141,150,20);
    Table.setBounds(292,27,300,400);
    Cancel.setBounds(124,254,80,20);
    AddContact.setBounds(124,285,100,20);
    //adding elements
    Contact.add(Name);
    Contact.add(Mob);
    Contact.add(Save);
    Contact.add(Show);
    Contact.add(Cancel);
    Contact.add(AddContact);
    Contact.add(NameField);
    Contact.add(MobField);
    Contact.add(Table);
    //actions
    Save.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String strName,strNumber;
                    Connection conn=null;
                    PreparedStatement ps=null;
                    strName=NameField.getText();
                    strNumber=MobField.getText();
                    try
                    {
                        conn=getConnection();
                        ps=conn.prepareStatement("insert into phonebook(Name,MobileNo) values(?,?)");
                        ps.setString(1,strName);
                        ps.setString(2,strNumber);
                        int res=ps.executeUpdate();
                        if(res==1)
                        {
                            JOptionPane.showMessageDialog(null, "Data Saved");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                        conn.close();
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                }
            }
    );
    Show.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        conn=getConnection();
                        ps=conn.prepareStatement("select * from phonebook");
                        ResultSet res=ps.executeQuery();
                        Table.setModel(DbUtils.resultSetToTableModel(res));
                        conn.close();
                    }
                    catch(Exception x)
                    {
                        JOptionPane.showMessageDialog(null, x);
                    }

                }
            }
    );
    Cancel.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    NameField.setText("");
                    MobField.setText("");
                }
            }
    );
    AddContact.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vCard VC=new vCard();
                }
            }
    );

    Contact.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Contact.setSize(700,500);
    Contact.setResizable(false);
    Contact.setLayout(null);
    Contact.setVisible(true);
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
public  static void main(String args[]){
    Contact C=new Contact();

}
}
