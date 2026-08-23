package bin.jav;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter withdrawal amount: ");
            int amount = sc.nextInt();

            if (amount <= 0) {
                throw new Exception("Invalid withdrawal amount.");
            }

            System.out.println("Withdrawal successful.");
            System.out.println("Amount Withdrawn: " + amount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

