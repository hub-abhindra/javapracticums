import java.util.*;
abstract class Vehicleinfo{
    String vehicleNumber; String brand;
    abstract void startEngine();
    public Vehicleinfo(String vehicleNumber, String brand)
    {
        this.vehicleNumber=vehicleNumber;
        this.brand=brand;
    }
    final void showVehicleIdentity(){
        System.out.println("Vehicle Number: "+ vehicleNumber);
        System.out.println("Brand: " + brand);
    }
   
}
 class Car extends Vehicleinfo
    {
        Car(String vehicleNumber,  String brand)
        {
            super(vehicleNumber,brand);
        }   
        void startEngine(){
            System.out.println("Car starts");
        }

    }
    class Bike extends Vehicleinfo
    {
        public Bike(String vehicleNumber,  String brand)
        {
            super(vehicleNumber,brand);
        }   
        void startEngine(){
            System.out.println("Bike starts");
        }

    }
    public class Vehicle
    {
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("1. CAR 2. BIKE");
            int choice=sc.nextInt();
            System.out.println("Enter the Vehicle Number: ");
            String vehicleNumber=sc.next();
            System.out.println("Enter the brand:");
            Vehicleinfo v;
            String brand =sc.next(); 
            switch(choice)
            {
                case 1: v=new Car(vehicleNumber, brand);
                    v.showVehicleIdentity();
                    v.startEngine();
                    break;
                case 2: v=new Bike(vehicleNumber, brand);
                    v.showVehicleIdentity();
                    v.startEngine();
                    break;
                default: return;
            }    
        }
        
    }