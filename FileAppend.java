/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Take file name as input to your program, If file is existing the open and display contents
of the file. After displaying contents of file ask user – do you want to add the data at the
end of file. If a user gives yes as response, then accept data from user and append it to
file. If file in not existing then create a fresh new file and store user data into it. User
should type exit on new line to stop the program.
*/

package academic;


import java.util.Scanner;
import java.io.*;
/**
 *
 * @author kanishk:
 */
public class FileAppend {
    public static void main(String[] args) throws IOException{
            Scanner scanpath = new Scanner(System.in);
            Scanner scanfile = new Scanner(System.in);
            Scanner ch = new Scanner(System.in);  
            System.out.println("Enter the path of Directory - ");
            String DirName = scanpath.nextLine();
            
            System.out.println("Enter the file Name to Open -");
            String FileName = scanfile.next();
            File F = new File(DirName,FileName);
          String line = null;
           if (F.exists()){
           System.out.println(F.getName()+" exists");
           FileReader FR = new FileReader(F);
           BufferedReader BR = new BufferedReader(FR);
           while((line=BR.readLine())!=null){
           System.out.println(line);
           } BR.close();
                      }else{
            F.createNewFile();
            
            System.out.println("File not Found \nNew File Created !");
            
            }
           String Name = F.getName();
           System.out.println("Do you want to Add Data to File ?\n 1) Yes\t 2) No");
           int choice = ch.nextInt();
           switch(choice){
               case 1: Write(Name,DirName);
                   break;
               case 2: System.out.println("Done");
                   break;
               default: System.out.println("Enter a Valid Choice");
                   break;
           }
    }
    static void Write(String s,String p) throws IOException{
        Scanner apnd = new Scanner(System.in);
        String fLoc=p+"\\"+s;
        FileWriter fw = new FileWriter(fLoc);
        BufferedWriter bf = new BufferedWriter(fw);
        System.out.println("Enter the data to append the file");
        try{
            String data= appendData(fLoc);
                   
            bf.close();
            fw.close();
            
              }catch(Exception e){
        System.out.println("Wrong");
        } 
        
    }
    static String appendData(String s) throws IOException{
    FileWriter fw1 = new FileWriter(s);
    BufferedWriter bf = new BufferedWriter(fw1);
            
    Scanner sc = new Scanner(System.in);
    String line ="";
    do{   
    line = sc.nextLine();
    bf.write(line);
    bf.newLine();
    bf.flush();
    
    }while(!line.contains("exit"));
    
    return line;
    }
}
