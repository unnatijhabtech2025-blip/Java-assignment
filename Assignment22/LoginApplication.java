package Assignment22;
import java.sql.*;
public class LoginApplication {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_assignment22";
        String username = "root";
        String password = "root";
        String inputUsername = "admin";
        String inputPassword = "1234";
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            // PreparedStatement for secure login
            String query =
                "SELECT * FROM login WHERE username = ? AND password = ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, inputUsername);
            pstmt.setString(2, inputPassword);
            // Execute query
            ResultSet rs = pstmt.executeQuery();
            // Check login result
            if (rs.next()) {
                System.out.println("Login successful.");
                System.out.println("Welcome, " + rs.getString("username"));
            } else {
                System.out.println("Invalid username or password.");
            }
            // Close resources
            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}


