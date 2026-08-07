package jav;
interface Printable {

    void print();

}
class Student implements Printable {

    String name = "Unnati";
    int rollNo = 101;

    public void print() {
        System.out.println("Student Details");
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
    }
}
class Employee implements Printable {

    String name = "Rahul";
    int id = 201;

    public void print() {

        System.out.println("Employee Details");
        System.out.println("Name : " + name);
        System.out.println("Employee ID : " + id);
    }
}
public class PrintableDemo {

    public static void main(String args[]) {

        Student s = new Student();
        Employee e = new Employee();
        s.print();
        System.out.println();
        e.print();
    }
}



