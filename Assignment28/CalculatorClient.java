package Assignment28;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry =
                LocateRegistry.getRegistry("localhost", 1099);

            Calculator calculator =
                (Calculator) registry.lookup("CalculatorService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Addition: " + calculator.add(a, b));
            System.out.println("Subtraction: " + calculator.subtract(a, b));
            System.out.println("Multiplication: " + calculator.multiply(a, b));
            System.out.println("Division: " + calculator.divide(a, b));

            sc.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}