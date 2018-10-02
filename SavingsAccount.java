/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Problem Statement-
Create class SavingsAccount. Use a static variable annualInterestRate to store the annual
interest rate for all account holders. Each object of the class contains a private instance
variable savingsBalance indicating the amount the saver currently has on deposit. Provide
method calculateMonthlyInterest to calculate the monthly interest by multiplying the
savingsBalance by annualInterestRate divided by 12this interest should be added to
savingsBalance. Provide a static method modifyInterestRate that sets the
annualInterestRate to a new value.
Write a program to test class SavingsAccount. Instantiate two savingsAccount
objects, saver1 and saver2, with balances of Rs 2000.00 and Rs 3000.00, respectively. Set
annualInterestRate to 4%, then calculate the monthly interest and print the new balances
for both savers. Then set the annualInterestRate to 5%, calculate the next month's
interest and print the new balances for both savers.
*/

package Academic;

import java.util.Scanner;
/**
 *
 * @author kanishk
 */
public class SavingsAccount {
     static double InitBalance=1000,Interest=0.1;
        static double CurrentBalance = 0;  
        
    SavingsAccount(){
        InitBalance = 0;
        Interest = .1;
    }    
    public static void main(String[] args){
        int choice,loop;
        loop=0;
        Scanner sc = new Scanner(System.in);
        
        do{
       System.out.println("Choose Operation to Perform - \n 1) Deposit\t 2) Withdraw\t 3) Interest Gained\t 4) Know Current Balance    ");
       choice = sc.nextInt();
       switch(choice){
           case 1 : System.out.println("Enter the Amount to Deposit -'");
                        double D = sc.nextDouble();
                        Deposit(D);
                         loop = 1;
               break;
           case 2 : System.out.println("Enter the Amount You want to withdraw -'");
                        double WD = sc.nextDouble();
                        Withdraw(WD);
                         loop = 1;
               break;
           case 3 :
                        Interest();
                         loop = 1;
               break;
            case 4 : System.out.println("Current Balance is - "+CurrentBalance+" RS");
              break;
           default : System.out.println("Invalid Choice");
                           loop = 1;
               break;
       }
        } while(loop == 1);
//InitBalance = sc.nextDouble();
    }
    static void Deposit(double D){
       CurrentBalance = InitBalance + D;
    System.out.println("Your Current Balance is - "+CurrentBalance+" RS");
    }
    static void Withdraw(double WD){
       CurrentBalance = InitBalance - WD; 
       System.out.println("Your Current Balance is - "+CurrentBalance+" RS");
    }
   static void  Interest(){
        int choice;
        double MI,YI;
        System.out.println("Choose -\t 1) Montly Interest\t 2) Yearly Interest");
        Scanner sc1 =new Scanner(System.in);
                choice = sc1.nextInt();
                switch(choice){
                    case 1:     MI = CurrentBalance*(1+Interest);
                        System.out.println("Montly Interest Gained- " +MI+" RS");
                        break;
                    case 2:     YI = CurrentBalance*(1+Interest)*12;
                        System.out.println("Yearly Interest Gained- " +YI+" RS");
                      break;
                    default:    System.out.println("Invalid Choice");
                      break;
                        
                }
    }
    
}
