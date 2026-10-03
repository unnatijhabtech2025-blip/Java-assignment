package Assignment23;
import java.sql.*;
public class ResultSetRecords {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_assignment23";
        String username = "root";
        String password = "root";
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            // Create statement
            Statement stmt = con.createStatement();
            // Execute SELECT query
            String query = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(query);
            // Display records one by one
            System.out.println("Student Records:");
            System.out.println("-----------------------------");
            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Course: " + rs.getString("course") +
                    ", Marks: " + rs.getDouble("marks")
                );
            }
            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}


