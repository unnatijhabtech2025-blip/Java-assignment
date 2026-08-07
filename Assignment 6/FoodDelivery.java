package jav;
public class FoodDelivery {
    String foodName = "Pizza";
    int price = 450;

    // Inner Class
    class OrderDetails {

        void displayOrder() {
            System.out.println("Food Name : " + foodName);
            System.out.println("Price : " + price);
        }
    }
    public static void main(String args[]) {

        FoodDelivery f = new FoodDelivery();

        // Creating Inner Class Object
        FoodDelivery.OrderDetails obj = f.new OrderDetails();

        System.out.println("Order Details:");
        obj.displayOrder();


        // Anonymous Class
        DeliveryStatus status = new DeliveryStatus() {

            public void updateStatus() {
                System.out.println("Order Delivered Successfully.");
            }

        };
        status.updateStatus();
    }
}
// Interface for Anonymous Class
interface DeliveryStatus {

    void updateStatus();
}
