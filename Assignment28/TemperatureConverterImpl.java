package Assignment28;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureConverterImpl extends UnicastRemoteObject
        implements TemperatureConverter {

    public TemperatureConverterImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}