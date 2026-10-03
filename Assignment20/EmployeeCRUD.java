package Assignment20;
import java.sql.*;

public class EmployeeCRUD {

    static String url = "jdbc:mysql://localhost:3306/jdbc_assignment20";
    static String username = "root";
    static String password = "root";

    public static void main(String[] args) {

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            // CREATE - Insert employee
            String insertQuery =
                "INSERT INTO employee VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt =
                con.prepareStatement(insertQuery);

            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "Rahul");
            insertStmt.setString(3, "IT");
            insertStmt.setDouble(4, 50000);

            insertStmt.executeUpdate();

            System.out.println("Employee record inserted successfully.");

            // READ - Display employees
            String selectQuery = "SELECT * FROM employee";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\nEmployee Records:");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("employee_id") +
                    ", Name: " + rs.getString("employee_name") +
                    ", Department: " + rs.getString("department") +
                    ", Salary: " + rs.getDouble("salary")
                );
            }

            // UPDATE - Update employee salary
            String updateQuery =
                "UPDATE employee SET salary = ? WHERE employee_id = ?";

            PreparedStatement updateStmt =
                con.prepareStatement(updateQuery);

            updateStmt.setDouble(1, 55000);
            updateStmt.setInt(2, 101);
            updateStmt.executeUpdate();

            System.out.println("\nEmployee record updated successfully.");

            // DELETE - Delete employee
            String deleteQuery =
                "DELETE FROM employee WHERE employee_id = ?";

            PreparedStatement deleteStmt =
                con.prepareStatement(deleteQuery);

            deleteStmt.setInt(1, 101);

            deleteStmt.executeUpdate();

            System.out.println("Employee record deleted successfully.");

            // Close resources
            rs.close();
            stmt.close();
            insertStmt.close();
            updateStmt.close();
            deleteStmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}