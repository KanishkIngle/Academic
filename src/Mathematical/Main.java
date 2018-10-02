/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*Problem Statement-
Develop a mathematical package for Statistical operations like Mean, Median, Average,
Standard deviation. Create a sub package in the math package -convert. In “convert”
package provide classes to convert decimal to octal, binary, hex and vice-versa. Develop
application program to use this package, and build executable jar file of it.
*/

package Academic.Mathematical.Statistics;
import Academic.Mathematical.*;
import Academic.Mathematical.Statistics.Convert.*;
import java.util.Scanner;
/**
 *
 * @author kanishk
 */
public class Main extends Median {
    
    public static void main(String args[]){
    //Creating instances of all Classes
    Average AV =new Average();
    Median M= new Median();
    StandardDeviation SD= new StandardDeviation();
    DecitoBinary DB = new DecitoBinary();
    DecitoHexa DH   = new DecitoHexa();
    DecitoOctal DO   = new DecitoOctal();
    BinarytoDeci BD = new BinarytoDeci();
    HexatoDeci HD   = new HexatoDeci();
    OctaltoDeci OD   = new OctaltoDeci();
    //Scanners
    Scanner sc= new Scanner(System.in);
    Scanner sc1=new Scanner(System.in);
    Scanner ch= new Scanner(System.in);
    System.out.println("Perform -\n1) Statistical Operation 2) Conversion ");
    int select =ch.nextInt();
    switch(select){
        case 1:    System.out.println("Select the Operation to Perform -\n1) Mean 2) Median 3) Standard Deviation");
                        int choice = sc.nextInt();
                        switch(choice){
                                    case 1: AV.FindAverage();
                                            break;
                                    case 2: M.getMedian();
                                            break;
                                    case 3: SD.getSD();
                                            break;
                                    default: System.out.println("Invalid Choice");
                                            break;
                         }
                   break;     
        case 2:     System.out.println("Select the Operation to Perform -\n1) Decimal to Binary\n2) Decimal to HexaDecimal\n3) Decimal to Octal\n4) Binary to Decimal\n5) HexaDecimal to Decimal\n26) Octal to Decimal ");
                         int choice2 = sc1.nextInt();
                         switch(choice2){
                                    case 1: DB.D2B();
                                            break;
                                    case 2: DH.D2H();
                                            break;
                                    case 3: DO.D2O();
                                            break;
                                    case 4: BD.B2D();
                                            break;
                                    case 5: HD.H2D();
                                            break;
                                    case 6: OD.O2D();
                                            break;        
                                    default: System.out.println("Invalid Choice");
                                            break;
                         }
                   break;   
    }
    }
}
