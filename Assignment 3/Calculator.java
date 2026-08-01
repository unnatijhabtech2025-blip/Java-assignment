package jav;

public class Calculator {

    static int count = 0;

    // Method for integer addition
    void add(int a, int b) {
        System.out.println("Sum = " + (a + b));
        count++;
    }

    // Overloaded method for decimal addition
    void add(double a, double b) {
        System.out.println("Sum = " + (a + b));
        count++;
    }

    public static void main(String args[]) {

        Calculator obj = new Calculator();

        obj.add(10, 20);
        obj.add(12.5, 8.5);

        System.out.println("Total Calculations = " + count);
    }
}

