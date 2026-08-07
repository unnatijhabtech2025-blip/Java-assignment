package jav;

public class BankAccount {

    final int accountNumber;
    String holderName;
    double balance;

    // Constructor
    BankAccount(int acc, String name, double bal) {

        accountNumber = acc;
        holderName = name;
        balance = bal;
    }

    void display() {

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + holderName);
        System.out.println("Balance : " + balance);
    }

    public static void main(String args[]) {

        BankAccount obj = new BankAccount(10101, "Unnati", 50000);

        obj.display();
    }
}
