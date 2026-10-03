import java.sql.*;
public class StudentRecords {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_assignment19";
        String username = "root";
        String password = "root";
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish database connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            // Create statement
            Statement stmt = con.createStatement();
            // Execute SELECT query
            String query = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(query);
            // Display student records
            System.out.println("Student Records");
            System.out.println("-----------------------------");
            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Age: " + rs.getInt("age") +
                    ", Course: " + rs.getString("course")
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

