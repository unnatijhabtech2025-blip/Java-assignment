package Assignment28;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            TemperatureConverter converter = new TemperatureConverterImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("TemperatureService", converter);

            System.out.println("Temperature Conversion Server is ready.");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
