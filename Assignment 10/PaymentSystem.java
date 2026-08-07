package jav;
abstract class Payment {
    abstract void pay();

    void display() {
        System.out.println("Payment Processing");
    }
}
class CreditCard extends Payment {

    void pay() {
        System.out.println("Payment done using Credit Card");
    }
}
class UPI extends Payment {

    void pay() {
        System.out.println("Payment done using UPI");
    }
}
public class PaymentSystem {

    public static void main(String args[]) {

        CreditCard c = new CreditCard();
        UPI u = new UPI();

        c.display();
        c.pay();

        System.out.println();

        u.display();
        u.pay();
    }
}
