/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Problem Statement - Create Separate Engine, Tyre, and Door Class. Create a CarComponents class using these classes.
And show functionality of each component in the car.*/

package Academic;

/**
 *
 * @author kanishk
 */

public class CarComponents extends Door{
   
    public static void main(String[] args){
         System.out.println("Your Jaguar Car is Built & Ready !!");
         CarComponents C = new CarComponents();
         
     }
}
class Engine{
    String MotorType = "Diesel";
    int PistonNumber=8,Capacity=1280;
    int Cylinders =8;
    Engine(){
        System.out.println("Engines installed..\nEngine Specifications");
        System.out.println("Engine Type - "+MotorType+" \nNumbers of Pistons - "+PistonNumber+" \nCapacity of Engine - "+Capacity+" cc"+" \nNumber of Cylinders - "+Cylinders);
    }
}
class Tyre extends Engine{
    double Grip =.23;
    String Material = "PolyCarbon";
    String Company = "CEAT";
    Tyre(){
        
        System.out.println("Tyres Installed..\nTyres Specifications");
        System.out.println("Grip of Tyres - "+Grip+"\nBuild Material - "+Material+"\nCompany - "+Company);
    }
}
class Door extends Tyre{
    int NumberOfDoor =4;
    String typeMetal ="Alloy-Steel",Glasstype ="Bullet Proof";
        Door(){
         System.out.println("Doors Installed..\nDoors Specifications");
         System.out.println("Number of Doors - "+NumberOfDoor+"\nMetal Used for Build -"+typeMetal+"\nGlasses Used- "+Glasstype);
        }
}

//transmission,ExteriorBody,Seats,Brakes,clutch,gear,brakes,headlights,silencer,viper,