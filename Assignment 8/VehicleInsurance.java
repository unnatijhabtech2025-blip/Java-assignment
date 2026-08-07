package jav;
class Vehicle {
    String vehicleName;
    String number;

    Vehicle(String v, String n) {

        vehicleName = v;
        number = n;
    }

    void display() {

        System.out.println("Vehicle Name : " + vehicleName);
        System.out.println("Vehicle Number : " + number);
    }
}
class Insurance extends Vehicle {
    double premium;
    Insurance(String v, String n, double p) {

        super(v, n);   // Accessing parent constructor
        premium = p;
    }
    void display() {

        super.display();   // Accessing parent method

        System.out.println("Insurance Premium : " + premium);
    }
}
public class VehicleInsurance {
    public static void main(String args[]) {
        Insurance obj = new Insurance("Toyota Fortuner", "MH12AB1234", 25000);
        obj.display();
    }
}

