package Assignment20;

import java.sql.*;

public class StudentCRUD {

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

            // CREATE - Insert student
            String insertQuery =
                "INSERT INTO student VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt =
                con.prepareStatement(insertQuery);

            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "Unnati");
            insertStmt.setString(3, "CSE");
            insertStmt.setDouble(4, 85);

            insertStmt.executeUpdate();

            System.out.println("Student record inserted successfully.");

            // READ - Display students
            String selectQuery = "SELECT * FROM student";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\nStudent Records:");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                System.out.println(
                    "Roll No: " + rs.getInt("roll_no") +
                    ", Name: " + rs.getString("name") +
                    ", Course: " + rs.getString("course") +
                    ", Marks: " + rs.getDouble("marks")
                );
            }

            // UPDATE - Update marks
            String updateQuery =
                "UPDATE student SET marks = ? WHERE roll_no = ?";

            PreparedStatement updateStmt =
                con.prepareStatement(updateQuery);

            updateStmt.setDouble(1, 90);
            updateStmt.setInt(2, 1);

            updateStmt.executeUpdate();

            System.out.println("\nStudent record updated successfully.");

            // DELETE - Delete student
            String deleteQuery =
                "DELETE FROM student WHERE roll_no = ?";

            PreparedStatement deleteStmt =
                con.prepareStatement(deleteQuery);

            deleteStmt.setInt(1, 1);

            deleteStmt.executeUpdate();

            System.out.println("Student record deleted successfully.");

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