package Assignment24;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {
    JTextField bookIdField;
    JTextField studentNameField;
    JTextField issueDateField;
    JTextField returnDateField;
    JTable table;
    DefaultTableModel model;
    String url = "jdbc:mysql://localhost:3306/jdbc_assignment24";
    String username = "root";
    String password = "root";
    public BookIssueTracking() {
        setTitle("Book Issue Tracking System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Form Panel
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        panel.add(bookIdField);

        panel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField();
        panel.add(studentNameField);

        panel.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueDateField = new JTextField();
        panel.add(issueDateField);

        panel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnDateField = new JTextField();
        panel.add(returnDateField);

        JButton issueButton = new JButton("Issue Book");
        JButton viewButton = new JButton("View Records");

        panel.add(issueButton);
        panel.add(viewButton);
        add(panel, BorderLayout.NORTH);
        // Table
        model = new DefaultTableModel(
            new String[]{
                "Book ID",
                "Student Name",
                "Issue Date",
                "Return Date"
            }, 0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        // Button actions
        issueButton.addActionListener(e -> issueBook());
        viewButton.addActionListener(e -> viewRecords());
        setVisible(true);
    }
    // Insert record
    void issueBook() {
        String query =
            "INSERT INTO book_issue VALUES (?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            PreparedStatement pstmt =
                con.prepareStatement(query);
            pstmt.setInt(
                1,
                Integer.parseInt(bookIdField.getText())
            );
            pstmt.setString(
                2,
                studentNameField.getText()
            );
            pstmt.setDate(
                3,
                Date.valueOf(issueDateField.getText())
            );
            pstmt.setDate(
                4,
                Date.valueOf(returnDateField.getText())
            );
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(
                this,
                "Book issue record added successfully."
            );
            pstmt.close();
            con.close();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
            );
        }
    }

    // Display records
    void viewRecords() {
        model.setRowCount(0);
        String query = "SELECT * FROM book_issue";
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
                    rs.getString("student_name"),
                    rs.getDate("issue_date"),
                    rs.getDate("return_date")
                });
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Error: " + e.getMessage()
            );
        }
    }
    // Clear fields
    void clearFields() {
        bookIdField.setText("");
        studentNameField.setText("");
        issueDateField.setText("");
        returnDateField.setText("");
    }

    public static void main(String[] args) {

        new BookIssueTracking();
    }
}
