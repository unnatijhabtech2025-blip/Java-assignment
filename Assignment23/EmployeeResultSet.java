package Assignment23;
import java.sql.*;
public class EmployeeResultSet {
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
            String query = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(query);
            // Display employee records sequentially
            System.out.println("Employee Records:");
            System.out.println("----------------------------------------");
            while (rs.next()) {
                System.out.println(
                    "Employee ID: " + rs.getInt("employee_id") +
                    ", Name: " + rs.getString("name") +
                    ", Department: " + rs.getString("department") +
                    ", Salary: " + rs.getDouble("salary")
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
