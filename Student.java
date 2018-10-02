/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Take Student information such as name, age, weight, height, city, phone from user and
store it in the file using DataOutputStream and FileOutputStream and Retrive data using
DataInputStream and FileInputStream and display the result.
*/
package academic;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author kanishk
 */
public class Student {
   public static void main(String args[]) throws IOException{
   FileOutputStream fout = new FileOutputStream("Test.txt");
   DataOutputStream out = new DataOutputStream(fout);
   Scanner scan = new Scanner(System.in);
   System.out.println("Enter Student's Info -");
   String Data =Ask();
   out.writeBytes(Data);
   out.close();
   FileInputStream fin =new FileInputStream("Test.txt");
   DataInputStream in = new DataInputStream(fin);
   in.close();
   System.out.println("Contents of the file are as Follows -");
   File file = new File("C:\\Users\\kanishk\\Documents\\NetBeansProjects\\Academic\\Test.txt");
   Scanner sc = new Scanner(file);
   while(sc.hasNextLine())
       System.out.println(sc.nextLine());
   
   }
  static String Ask(){
   Scanner sc = new Scanner(System.in);   
   //Scanner city =new Scanner(System.in);
   System.out.println("Enter Name - ");
   String Name = sc.nextLine();
   System.out.println("Enter Age - ");
   int Age =sc.nextInt();
   System.out.println("Enter Weight - ");
   double Weight = sc.nextDouble();
   System.out.println("Enter Height - ");
   double Height = sc.nextDouble();
   System.out.println("Enter City - ");
   String City = sc.next();
   System.out.println("Enter Phone Number -");
   BigInteger PhoneNumber = sc.nextBigInteger();
   String Data = "Name - "+Name+"\n"+"Age - "+Age+"\n"+"Weight - "+Weight+" Kgs"+"\n"+"Height - "+Height+" cms"+"\n"+"City - "+City+"\n"+"Phone Number - "+PhoneNumber+"\n";
   return Data;
   }
}
