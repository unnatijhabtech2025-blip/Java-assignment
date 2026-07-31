package jav;

public class exp2 {

    String name;
    int rollNo;

    // Default Constructor
    exp2() {
        name = "Unknown";
        rollNo = 0;
    }

    // Parameterized Constructor
    exp2(String n, int r) {
        name = n;
        rollNo = r;
    }

    // Display Method
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
    }

    public static void main(String args[]) {

        exp2 obj1 = new exp2();
        exp2 obj2 = new exp2("Unnati", 101);

        System.out.println("Default Constructor");
        obj1.display();

        System.out.println();

        System.out.println("Parameterized Constructor");
        obj2.display();
    }
}


