package Assignment24;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LibraryManagement extends JFrame {

    JTextField bookIdField, bookNameField, authorField, quantityField;
    JTable table;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/jdbc_assignment24";
    String username = "root";
    String password = "root";

    public LibraryManagement() {

        setTitle("Library Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Form Panel
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        panel.add(bookIdField);

        panel.add(new JLabel("Book Name:"));
        bookNameField = new JTextField();
        panel.add(bookNameField);

        panel.add(new JLabel("Author:"));
        authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");

        panel.add(addButton);
        panel.add(viewButton);

        add(panel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(
            new String[]{"Book ID", "Book Name", "Author", "Quantity"}, 0
        );

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button Actions
        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());

        setVisible(true);
    }

    // Add Book
    void addBook() {

        String query =
            "INSERT INTO library VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, Integer.parseInt(bookIdField.getText()));
            pstmt.setString(2, bookNameField.getText());
            pstmt.setString(3, authorField.getText());
            pstmt.setInt(4, Integer.parseInt(quantityField.getText()));

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(
                this, "Book added successfully."
            );

            pstmt.close();
            con.close();

            clearFields();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }

    // View Books
    void viewBooks() {

        model.setRowCount(0);

        String query = "SELECT * FROM library";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("book_name"),
                    rs.getString("author"),
                    rs.getInt("quantity")
                });
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                this, "Error: " + e.getMessage()
            );
        }
    }
    // Clear input fields
    void clearFields() {

        bookIdField.setText("");
        bookNameField.setText("");
        authorField.setText("");
        quantityField.setText("");
    }

    public static void main(String[] args) {
        new LibraryManagement();
    }
}