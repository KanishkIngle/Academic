/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author kanishk
 */
public class IOFile  {
    public static void main(String[] args) throws IOException{
        Scanner ch= new Scanner(System.in);
        System.out.println("Choose -\n1) Create Contact\t2) View Contact ");
        int choice= ch.nextInt();
        switch(choice){
            case 1: CreateContact();
                break;
            case 2:FindContact();
                break;
            default:System.out.println("Enter a valid Choice");
                break;
        }    
    }
    static void CreateContact()throws IOException{
    String DirName = "C:\\Users\\kanishk\\Contacts";
            Scanner sc = new Scanner(System.in);
            Scanner scanfile = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            JOptionPane.showInputDialog("Name the Contact File");
            String FileName = scanfile.next();
            File F = new File(DirName,FileName);
            String path =DirName+"\\"+FileName+".vcf";
            
            FileWriter fw = new FileWriter(path);
            BufferedWriter bf = new BufferedWriter(fw);
            try{
            JOptionPane.showInputDialog("Enter Name");    
            bf.write(sc.next());
            bf.newLine();
            JOptionPane.showInputDialog("Enter Phone Number");
            bf.write(sc1.nextLine());
            bf.flush();
            bf.close();
            fw.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            JOptionPane.showMessageDialog(null,"Contact Saved Successfully");
             }
    static void FindContact() throws IOException{
            Scanner scanpath = new Scanner(System.in);
            Scanner scanfile = new Scanner(System.in);
            Scanner ch = new Scanner(System.in);  
            String DirName ="C:\\Users\\kanishk\\Contacts";
            
            System.out.println("Enter the file Name to Open -");
            
            String FileName = JOptionPane.showInputDialog("Enter the file Name to Open -");
            File F = new File(DirName,FileName);
            String line = null;
           if (F.exists()){
           JOptionPane.showMessageDialog(null,F.getName()+" exists","Contact exists",JOptionPane.PLAIN_MESSAGE);
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+DirName+"\\"+FileName);
                      }else{
           JOptionPane.showMessageDialog(null,"File does'nt exists"," Not Found",JOptionPane.PLAIN_MESSAGE);
           }
}
}
