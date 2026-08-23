package bin.jav;

import java.util.Scanner;

public class VotingSystem {

    static class InvalidAgeException extends Exception {
        InvalidAgeException(String message) {
            super(message);
        }
    }

    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote.");
        }

        System.out.println("You are eligible to vote.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkAge(age);

        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

        sc.close();
    }
}

