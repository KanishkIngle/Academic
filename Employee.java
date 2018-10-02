/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Academic;

/* Problem Statement- */
/* Create a class called Employee that includes three pieces of information as instance
variables- first name, a last name and a monthly salary. Your class should have a
constructor that initializes the three instance variables. Provide a set and a get method for
each instance variable. If the monthly salary is not positive, set it to 0.0. Write a testapplication named EmployeeTest that demonstrates class Employee's capabilities. Create
two Employee objects and display each object's yearly salary. Then give each Employee
a 10% raise and display each Employee's yearly salary again.*/

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author kanishk
 */

public class Employee extends JFrame{
String firstName,lastName;
int montlySalary,yearlySalary;
private JList list; // list object created
private JButton OK;

private static String[] JobTitles ={"Administration","Business Strategy","Data Centre & Network","Developers Relation ","Finance","Hardware Engg.","Software Engg.","Sales Operation"}; 

 public Employee(){
     //Design Structure
     super("Google Inc.");
     setLayout(new FlowLayout());
     list = new JList(JobTitles);
     list.setVisibleRowCount(5);
     list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
     OK = new JButton("Done");
     OK.addActionListener(
                        new ActionListener(){
                           public void actionPerformed(ActionEvent event){
                                                    
                               Object selectedValue = list.getSelectedValue();
                               EmployeeTest(selectedValue);
                           }
                        }
     );
     
    // variables Initalized
     firstName = " N.A. ";
     lastName = " N.A. ";
     montlySalary = 0;
    
    add(new JScrollPane(list));
    add(OK);
 }
 public void setName(String first,String second){
     firstName = first;
     lastName = second;
 JOptionPane.showMessageDialog(null, "Welcome to Google Inc."+firstName+" "+lastName, "Google Employee", JOptionPane.PLAIN_MESSAGE);
 }
public void getEmployeeName(){
    String first = JOptionPane.showInputDialog("Enter Your First Name ");
     String second = JOptionPane.showInputDialog("Enter Your Last Name ");
      setName(first,second);
} 
 public void setEmployeeSalary(int Sal){     
 montlySalary = Sal;
 yearlySalary = montlySalary*12;
getEmployeeSalary(yearlySalary);
JOptionPane.showMessageDialog(null,"Salary Raised by 10 %","Congrats",JOptionPane.PLAIN_MESSAGE);
getEmployeeSalary(yearlySalary*(1.1)); // Salary After 10% raise

 }
 public void getEmployeeSalary(double Sal){
 JOptionPane.showMessageDialog(null, firstName+" your Yearly Salary is "+Sal+" $","Salary",JOptionPane.PLAIN_MESSAGE );
 
 }
 public void EmployeeTest(Object e){
     if(e == "Administration"){
         setEmployeeSalary(18000);
     }else if(e == "Business Strategy"){
         setEmployeeSalary(20000);
     }else if(e == "Data Centre & Network"){
         setEmployeeSalary(30000);
     }else if(e == "Developers Relation"){
         setEmployeeSalary(16000);
     }else if(e =="Finance"){
          setEmployeeSalary(18000);
     }else if(e=="Hardware Engg."){
          setEmployeeSalary(17000);
     }else if(e=="Software Engg."){
          setEmployeeSalary(35000);
     }else if(e=="Sales Operation"){
        setEmployeeSalary(22000);
      } else{
         setEmployeeSalary(0);
     }
     
 }
 
 public static void main(String args[]){
     
     Employee first =new Employee();
     first.getEmployeeName();
     
     first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     first.setSize(300,250);
     first.setVisible(true);
     
  
 }
}

