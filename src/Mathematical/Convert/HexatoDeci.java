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
public class HexatoDeci {
public static int H2D(){
Scanner sc= new Scanner(System.in);    
    System.out.println("Enter an HexaDecimal  value");
    String HexaDecimal=sc.next();
    int Decimal = Integer.parseInt(HexaDecimal, 16);
    System.out.println("Decimal value of "+HexaDecimal+" is "+Decimal);
    return Decimal;
}   
}
