package jav;

public class exp2_mobile {

    String brand;
    String model;
    int price;

    // Default Constructor
    exp2_mobile() {
        brand = "Samsung";
        model = "Galaxy A15";
        price = 15000;
    }

    // Parameterized Constructor
    exp2_mobile(String b, String m, int p) {
        brand = b;
        model = m;
        price = p;
    }

    // Copy Constructor
    exp2_mobile(exp2_mobile obj) {
        brand = obj.brand;
        model = obj.model;
        price = obj.price;
    }

    // Display Method
    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }

    public static void main(String args[]) {

        exp2_mobile obj1 = new exp2_mobile();

        exp2_mobile obj2 = new exp2_mobile("Apple", "iPhone 16 Pro", 129900);

        exp2_mobile obj3 = new exp2_mobile(obj2);

        System.out.println("Default Constructor");
        obj1.display();

        System.out.println();

        System.out.println("Parameterized Constructor");
        obj2.display();

        System.out.println();

        System.out.println("Copy Constructor");
        obj3.display();
    }
}
