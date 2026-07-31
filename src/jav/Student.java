package jav;

public class Student {

    String name;
    int rollNo;

    // Default Constructor
    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    // Parameterized Constructor
    Student(String n, int r) {
        name = n;
        rollNo = r;
    }

    // Display Method
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
    }

    public static void main(String args[]) {

        Student obj1 = new Student();

        Student obj2 = new Student("Unnati", 101);

        System.out.println("Default Constructor");
        obj1.display();

        System.out.println();

        System.out.println("Parameterized Constructor");
        obj2.display();
    }
}
