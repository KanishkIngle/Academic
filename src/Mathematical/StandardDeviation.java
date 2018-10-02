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
public class StandardDeviation {
  public static double getSD(){
                //code for average
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the numbers - ");
                //scans the whole line 
                String str= sc.nextLine();
                //converts to array
                String[] numberStr = str.split(" ");
                int[] numbers = new int[numberStr.length];

              // still strings..need to convert into integers
                int Total = 0;

                for(int i=0;i<numberStr.length;i++){
                       numbers[i]=Integer.parseInt(numberStr[i]);
                       Total+=numbers[i];
                     }
                      int avg = Total/numbers.length;
                      int n = numberStr.length;
                      double sum=0;
                       for(int i=0;i<numberStr.length;i++){
                       sum+=(numbers[i]-avg)*(numbers[i]-avg)/n;
                  }
                  double standardDeviation =Math.sqrt(sum);
                  System.out.println("Standard Deviation  is "+standardDeviation);
return standardDeviation;
  }
}

