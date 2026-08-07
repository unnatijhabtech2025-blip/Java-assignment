package jav;

public class Vehicle {

    String brand = "Toyota";
    String model = "Fortuner";

    // Inner Class
    class VehicleDetails {

        void displayDetails() {
            System.out.println("Brand : " + brand);
            System.out.println("Model : " + model);
        }
    }

    public static void main(String args[]) {

        Vehicle v = new Vehicle();

        Vehicle.VehicleDetails obj = v.new VehicleDetails();

        System.out.println("Vehicle Details:");
        obj.displayDetails();

        Runnable action = new Runnable() {

            public void run() {
                System.out.println("Vehicle is starting...");
            }

        };

        action.run();
    }
}
