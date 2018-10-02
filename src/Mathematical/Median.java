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
public class Median {
       
public static double getMedian(){
                    double Median=0;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the numbers - ");
                    //scans the whole line 
                    String str= sc.nextLine();
                    //converts to array
                    String[] numberStr = str.split(" ");
                    int[] numbers = new int[numberStr.length];
                    // still strings..need to convert into integers
                    for(int i=0;i<numberStr.length;i++){
                        numbers[i]=Integer.parseInt(numberStr[i]);
                    //System.out.print(numbers[i]+",");

                    }
                    if ((numberStr.length)%2!=0){
                           System.out.println("Median is "+numbers[(numberStr.length)/2]);

                    }else{
                    int range=numberStr.length;
                    System.out.println("Median is "+(numbers[range/2-1]+numbers[range/2])/2);
                    Median =(numbers[range/2-1]+numbers[range/2])/2;
                    }
                    return Median;
}

 }
   
