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
public class DecitoBinary {
    public static String D2B(){
    Scanner sc= new Scanner(System.in);    
    System.out.println("Enter an Decimal  value");
    int Decimal = sc.nextInt();
    String Binary = Integer.toBinaryString(Decimal);
    System.out.println("Binary value of "+Decimal+" is "+Binary);
    return Binary;
    }
}
