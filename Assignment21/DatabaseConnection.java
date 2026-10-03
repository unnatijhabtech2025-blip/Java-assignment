package Assignment21;
import java.sql.*;
public class DatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_assignment21";
        String username = "root";
        String password = "root";
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            // Display connection status
            if (con != null) {
                System.out.println("Database connected successfully.");
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
