package jav;

interface Product {

    void displayProduct();

}


// Parent Class
class ProductDetails {

    String name;
    double price;

    ProductDetails(String n, double p) {
        name = n;
        price = p;
    }
}


// Electronic Product
class Electronic extends ProductDetails implements Product {

    Electronic(String n, double p) {
        super(n, p);
    }

    public void displayProduct() {
        System.out.println("Electronic Product");
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
    }
}


// Clothing Product
class Clothing extends ProductDetails implements Product {

    Clothing(String n, double p) {
        super(n, p);
    }

    public void displayProduct() {
        System.out.println("Clothing Product");
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
    }
}


// Grocery Product
class Grocery extends ProductDetails implements Product {

    Grocery(String n, double p) {
        super(n, p);
    }

    public void displayProduct() {
        System.out.println("Grocery Product");
        System.out.println("Name : " + name);
        System.out.println("Price : " + price);
    }
}


public class ProductSystem {

    public static void main(String args[]) {

        Electronic e = new Electronic("Laptop", 60000);
        Clothing c = new Clothing("T-Shirt", 800);
        Grocery g = new Grocery("Rice", 500);

        e.displayProduct();

        System.out.println();

        c.displayProduct();

        System.out.println();

        g.displayProduct();
    }
}