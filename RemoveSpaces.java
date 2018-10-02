/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Write a program to remove whitespaces from a text file. Name of the file is given using
command line.
*/

package academic;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author kanishk
 */
public class RemoveSpaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File input = new File("D:\\Test.txt");
        Scanner sc = new Scanner(input);
        String str,str1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the input stream - ");
        str = scan.nextLine();
        str1 =str.replaceAll("\\s","");
        System.out.println("White Spaces Removed");
        System.out.println(str1);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the file name to be saved (with extension)");
        String Name=sc1.next();
        FileWriter fw = new FileWriter(Name);
        BufferedWriter bf = new BufferedWriter(fw);
        fw.write(str1);
        fw.close();        
        System.out.println("File Saved in Package Directory");
    }
    
}
