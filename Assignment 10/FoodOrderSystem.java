package jav;
abstract class FoodOrder {

    abstract void calculateBill();

}
class DineInOrder extends FoodOrder {

    int foodPrice = 500;
    int serviceCharge = 50;

    void calculateBill() {

        System.out.println("Dine In Order Bill : " + (foodPrice + serviceCharge));
    }
}
class TakeAwayOrder extends FoodOrder {

    int foodPrice = 500;
    int packingCharge = 30;

    void calculateBill() {

        System.out.println("Take Away Order Bill : " + (foodPrice + packingCharge));
    }
}
public class FoodOrderSystem {

    public static void main(String args[]) {

        DineInOrder d = new DineInOrder();
        TakeAwayOrder t = new TakeAwayOrder();

        d.calculateBill();

        t.calculateBill();
    }
}
