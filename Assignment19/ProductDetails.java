import java.sql.*;

public class ProductDetails {

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
            String query = "SELECT * FROM product";
            ResultSet rs = stmt.executeQuery(query);

            // Display product details
            System.out.println("Product Details");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                System.out.println(
                    "Product ID: " + rs.getInt("product_id") +
                    ", Product Name: " + rs.getString("product_name") +
                    ", Quantity: " + rs.getInt("quantity") +
                    ", Price: " + rs.getDouble("price")
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