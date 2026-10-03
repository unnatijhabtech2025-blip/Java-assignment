package Assignment21;
import java.sql.*;
public class StudentDatabaseConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_database";
        String username = "root";
        String password = "root";
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            // Check connection status
            if (con != null) {
                System.out.println(
                    "Student database is connected successfully."
                );
            }
            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(
                "Student database connection failed."
            );
            System.out.println("Error: " + e.getMessage());
        }
    }
}