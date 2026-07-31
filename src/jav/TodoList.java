package jav;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> task = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        int ch;

        do {

            System.out.println("\n1.Add Task");
            System.out.println("2.Remove Task");
            System.out.println("3.View Tasks");
            System.out.println("4.Exit");
            System.out.print("Enter Choice : ");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter Task : ");
                    task.add(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter Task to Remove : ");
                    task.remove(sc.nextLine());
                    break;

                case 3:
                    sb.setLength(0);
                    sb.append("To-Do List\n");

                    for(String t : task)
                    {
                        sb.append(t).append("\n");
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
