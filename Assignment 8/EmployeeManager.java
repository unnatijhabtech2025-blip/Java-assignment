package jav;
class Employee {
    String name;
    int id;

    Employee(String n, int i) {
        name = n;
        id = i;
    }

    void display() {
        System.out.println("Employee Name : " + name);
        System.out.println("Employee ID : " + id);
    }
}
class Manager extends Employee {

    String department;

    Manager(String n, int i, String d) {

        super(n, i);   // Calling parent constructor
        department = d;
    }

    void display() {

        super.display();   // Calling parent method

        System.out.println("Department : " + department);
    }
}
public class EmployeeManager {
    public static void main(String args[]) {

        Manager m = new Manager("Unnati", 101, "IT");

        m.display();
    }
}

