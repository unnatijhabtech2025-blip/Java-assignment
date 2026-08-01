package jav;

public class Restaurant {

    static int totalOrders = 0;

    // Dine-in
    void bill(int amount) {
        System.out.println("Dine-in Bill : " + amount);
        totalOrders++;
    }

    // Takeaway
    void bill(int amount, int packingCharge) {
        System.out.println("Takeaway Bill : " + (amount + packingCharge));
        totalOrders++;
    }

    // Delivery
    void bill(int amount, int packingCharge, int deliveryCharge) {
        System.out.println("Delivery Bill : " + (amount + packingCharge + deliveryCharge));
        totalOrders++;
    }

    public static void main(String args[]) {

        Restaurant obj = new Restaurant();

        obj.bill(500);
        obj.bill(500, 20);
        obj.bill(500, 20, 50);

        System.out.println("Total Orders = " + totalOrders);
    }
}