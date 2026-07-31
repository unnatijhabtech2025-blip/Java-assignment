package jav;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> course = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        int ch;

        do {

            System.out.println("\n1.Add Course");
            System.out.println("2.Remove Course");
            System.out.println("3.View Courses");
            System.out.println("4.Exit");
            System.out.print("Enter Choice : ");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter Course : ");
                    course.add(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter Course to Remove : ");
                    course.remove(sc.nextLine());
                    break;

                case 3:
                    sb.setLength(0);
                    sb.append("Registered Courses\n");

                    for(String c : course)
                    {
                        sb.append(c).append("\n");
                    }

                    System.out.println(sb);
                    break;

                case 4:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while(ch!=4);

        sc.close();
    }
}