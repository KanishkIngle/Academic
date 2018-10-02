/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* Problem Statement-
Demonstrate use of static method,static variable,final keyword,and this keyword
*/

package academic;

import java.util.Scanner;
/**
 *
 * @author kanishk
 */
public class keywords {
    // static method
    public static String staticKey(){
    Scanner sc= new Scanner(System.in);
    //demonstrate
    System.out.println("Enter your Name-");
    String s= sc.nextLine();
    return s;
    }
    //static  and final Variable
     static final int Age=21;
     static String Name=null;
     //use of this Keyword; 
     public  String thisKey(){
    Scanner sc= new Scanner(System.in);
    //demonstrate
    System.out.println("Enter your Surname-");
     Name= sc.nextLine();
     String Surname=this.Name; 
     
     return Surname;
     }
     public static void main(String[] args){
     System.out.println("Your Name is "+staticKey()+" and you are "+Age+" years old");
     
     }
}
