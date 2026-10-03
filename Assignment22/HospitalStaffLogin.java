package Assignment22;

import java.sql.*;

public class HospitalStaffLogin {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_assignment22";
        String username = "root";
        String password = "root";

        String inputLoginId = "DOC101";
        String inputPassword = "doc123";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            // PreparedStatement for authentication
            String query =
                "SELECT * FROM hospital_staff WHERE login_id = ? AND password = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, inputLoginId);
            pstmt.setString(2, inputPassword);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            // Check authentication
            if (rs.next()) {

                String name = rs.getString("name");
                String role = rs.getString("role");

                System.out.println("Login successful.");
                System.out.println("Welcome, " + role + " " + name);
                System.out.println("Access granted.");

            } else {

                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access denied.");

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