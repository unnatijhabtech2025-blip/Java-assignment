package jav;

public class exp1 {

    int rollNo;
    String name;
    double marks;

    // Constructor
    exp1(int r, String n, double m) {
        rollNo = r;
        name = n;
        marks = m;
    }

    // Method
    void displayDetails() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
    }

    public static void main(String[] args) {

        exp1 student = new exp1(101, "Unnati", 91.5);

        student.displayDetails();
    }
}
