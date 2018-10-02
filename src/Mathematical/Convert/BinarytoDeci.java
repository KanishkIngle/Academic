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
public class BinarytoDeci {
   public static int B2D(){
    Scanner sc= new Scanner(System.in);    
    System.out.println("Enter an Binary value");
    String Binary =sc.next();
    int Decimal = Integer.parseInt(Binary, 2);
    System.out.println("Decimal value of "+Binary+" is "+Decimal);
    return Decimal;  
   }
}
