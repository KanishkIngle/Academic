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
public class DecitoHexa {
    public static String D2H(){
    Scanner sc= new Scanner(System.in);    
    System.out.println("Enter an Decimal  value");
    int Decimal = sc.nextInt();
    String HexaDecimal = Integer.toHexString(Decimal);
    System.out.println("HexaDecimal value of "+Decimal+" is "+HexaDecimal);
    return HexaDecimal; 
    
    }
}
