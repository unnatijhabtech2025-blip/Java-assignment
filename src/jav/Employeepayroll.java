package jav;
import java.util.Scanner;

public class Employeepayroll {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String salary = sc.nextLine();

        System.out.print("Enter Bonus Amount: ");
        String bonus = sc.nextLine();

        Integer empId = Integer.valueOf(id);
        Double basicSalary = Double.valueOf(salary);
        Double bonusAmount = Double.valueOf(bonus);

        if (basicSalary > 0 && bonusAmount >= 0) {

            Double netSalary = basicSalary + bonusAmount;

            System.out.println("\nEmployee ID : " + empId);
            System.out.println("Basic Salary : " + basicSalary);
            System.out.println("Bonus Amount : " + bonusAmount);
            System.out.println("Net Salary : " + netSalary);

        } else {

            System.out.println("Invalid Salary or Bonus Amount.");

        }

        sc.close();
    }
}

