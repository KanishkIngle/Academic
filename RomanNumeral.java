/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Problem Statement-
Write a class to represent Roman numerals. The class should have two constructors. One
constructs a Roman numeral from a string such as "XVII" or "MCMXCV". It should
throw a NumberFormatException if the string is not a legal Roman numeral. The other constructor constructs a Roman numeral from an int. It should throw a
NumberFormatException if the int is outside the range 1 to 3999.In addition, the class
should have two instance methods. The method toString() returns the string that
represents the Roman numeral. The method toInt() returns the value of the Roman
numeral as an int.
*/
package academic;

import java.util.Scanner;
/**
 *
 * @author kanishk
 */
public class RomanNumeral {
    
    private final int num ;
    private static int[] numbers ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static String[] letters ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
     
    public RomanNumeral(int arabic ){
if(arabic <1)
    throw new NumberFormatException("Value of Roman Numeral must be Positive.");
if(arabic >3999)
    throw new NumberFormatException("Value of Roman Numeral must be less than 3999.");
num = arabic;
}
    public RomanNumeral(String roman){
        if (roman.length() == 0)
            throw new NumberFormatException("An empty string does not define a Roman Numeral.'");
            roman = roman.toUpperCase();
            int i= 0;
            int arabic =0;
            while(i <roman.length()){
            char letter = roman.charAt(i);
            int number = letterToNumber(letter);
            i++;
            if(i == roman.length()){
            arabic+= number;
            }else{
            int nextNumber = letterToNumber(roman.charAt(i));
            if(nextNumber > number){
            arabic +=(nextNumber - number);
            i++;
            }else{
            arabic+=number;
            }
            }
            }
            if (arabic >3999)
             throw new NumberFormatException("Roman Number must have value less than 3999");
             num = arabic;
          }

   
    private int letterToNumber(char letter){
    switch(letter){
        case 'I' : return 1;
        case 'V' : return 5;
        case 'X' : return 10;
        case 'L' : return 50;
        case 'C' : return 100;
        case 'D' : return 500;
        case 'M' : return 1000;
        default: throw new NumberFormatException("Illegal character "+letter+" in the Roman numeral");
    }
    }
    public String toString(){
    String roman = "";
    int N = num;
    for(int i =0;i<numbers.length;i++){
    while(N>=numbers[i]){
    roman+=letters[i];
    N-=numbers[i];
    }
    }return roman;
    }
    public int toInt(){
        return num;
    }
   public static void main(String args[]){
       Scanner scan = new Scanner(System.in); 
       System.out.println("Choose Operation to be performed -\n1) Roman Numeral to Integer\n2) Integer to Roman Numeral ");
       int choice =scan.nextInt();
       switch(choice){
           case 1 :  System.out.println("Enter the value of Roman Numeral -");
                          int value =scan.nextInt();
                          RomanNumeral RN = new RomanNumeral(value);
                          String str =RN.toString();
                          System.out.println("Roman Numeral -"+str);
                          break;
           case 2 :  System.out.println("Enter the Roman String -");
                          String str1 =scan.next();
                          RomanNumeral RNR= new RomanNumeral(str1);
                          int Val =RNR.toInt();
                          System.out.println("Integer Value is - "+Val);
                          break;
           default: System.out.println("Enter a Valid choice");
                           break;
       }
   }
         }
