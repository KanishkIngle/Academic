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
public class OctaltoDeci {
    public static int O2D(){
    Scanner sc= new Scanner(System.in);    
    System.out.println("Enter an Octal value");
    String Octal=sc.next();
    int Decimal = Integer.parseInt(Octal, 8);
    System.out.println("Decimal value of "+Octal+" is "+Decimal);
    return Decimal;
    }
}
