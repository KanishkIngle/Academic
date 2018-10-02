/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Academic;
/* Problem Statement- */

/* Create Vehicle Interface with name, maxPassanger, and maxSpeed variables. Create
LandVehicle and SeaVehicle Inteface from Vehicle interface. LandVehicle has
numWheels variable and drive method. SeaVehicle has displacement variable and launch
method. Create Car class from LandVehicle, HoverCraft from LandVehicle and
SeaVehicle interface. Also create Ship from SeaVehicle. Provide additional methods in
HoverCraft as enterLand and enterSea. Similarly provide other methods for class Car and
Ship. Demonstrate all classes in a application.*/

import java.util.Scanner;
/**
 *
 * @author kanishk
 */
interface vehicle{
String name = "Bentley";
int maxPassenger = 4;
int maxSpeed = 350; //kmph
}

interface landVehicle extends vehicle{
int numWheels = 4;
void drive();
}

interface seaVehicle extends vehicle{
int displacement = 60; // miles
void launch();
}

class car implements landVehicle{
//other methods
public void drive(){
 System.out.println("You are driving "+name+" land vehicle ");
 }
public void details(){
    System.out.println("your maximum speed limit is "+maxSpeed+" Kmph");
    System.out.print("Maximum Passengers --> "+maxPassenger+" Seatings");
    System.out.println("\ntotal number of wheels --> "+numWheels);
}
}	

class hoverCraft implements seaVehicle,landVehicle{
//other methods
    
public void drive(){
 System.out.println("You are driving land vehicle ");
 }
 public void launch(){
	 System.out.println("You are launching sea vehicle");
 }

 public void enterLand(){
	 System.out.println("You are entering land by your hoverCraft");
 }
 public void enterSea(){
 System.out.println("You are entering land by your hoverCraft");
 }


}
	
class ship implements seaVehicle{
//other methods
public void launch(){
	 System.out.println("You are launching sea vehicle");
         
 }
public void diveIn(){
    System.out.println("You Have reached UnderWater");
}

}	


 public class Vehicle{

 public static void main(String args[]){
 car C = new car();
 hoverCraft HC = new hoverCraft();
 ship S = new ship();
 Scanner sc =new Scanner(System.in);
 System.out.println("Its ready");



 System.out.println("What you want to drive ->\t 1) Car\t 2) Hover Craft\t 3) Ship");
 int choice = sc.nextInt();
 switch(choice){
     case 1 :         C.details();
                            C.drive();
          break;
     case 2 : System.out.println("Where to Launch 1) Land 2) Water");
                    int ch = sc.nextInt();
                    if(ch==1){
                        HC.launch();
                        HC.enterLand();
                    }
                    else{
                        HC.launch();
                        HC.enterSea();
                    }
         break;
     case 3 : S.launch();
                    S.diveIn();
         break;
     default : System.out.println("Enter a valid Choice");
         break;
 }
 }
 }

 