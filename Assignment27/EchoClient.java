package Assignment27;
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);

            BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

            System.out.println("Connected to echo server.");

            while (true) {
                System.out.print("Enter message: ");
                String message = keyboard.readLine();

                output.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                String response = input.readLine();
                System.out.println("Echo from server: " + response);
            }

            socket.close();
            System.out.println("Client disconnected.");

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

