/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Academic.Mathematical.Statistics.Convert;

import java.util.Scanner;

/**
 *
 * @author kanishk
 */
public class DecitoOctal {
    public static String D2O(){
    Scanner sc= new Scanner(System.in);    
    System.out.println("Enter an Decimal  value");
    int Decimal = sc.nextInt();
    String Octal = Integer.toOctalString(Decimal);
    System.out.println("Octal value of "+Decimal+" is "+Octal);
    return Octal;
    
    }
}
