/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Academic.Mathematical.Statistics;

import java.util.Scanner;
/**
 *
 * @author kanishk
 */
public class Average {
    
    public static double FindAverage(){
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the number of values");
            int choice= sc.nextInt();
            double Total = 0;
            System.out.println("Input "+choice+" values");
               for(int i=0;i<choice;i++){
               double val = sc.nextDouble();
               Total = Total+val;
                }
            System.out.println("Average is "+Total/choice);
            return Total/choice; 
    }
    
}

