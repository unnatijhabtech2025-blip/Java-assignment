
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String message = "";
String action = request.getParameter("action");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    try (Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/jsp_crud", "root", "root")) {

        if ("add".equals(action)) {
            String sql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                ps.setString(2, request.getParameter("name"));
                ps.setString(3, request.getParameter("department"));
                ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));
                ps.executeUpdate();
                message = "Employee added successfully!";
            }
        } else if ("update".equals(action)) {
            String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("department"));
                ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
                ps.setInt(4, Integer.parseInt(request.getParameter("id")));
                int count = ps.executeUpdate();
                message = count > 0 ? "Employee updated successfully!" : "Employee ID not found.";
            }
        } else if ("delete".equals(action)) {
            String sql = "DELETE FROM employees WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                int count = ps.executeUpdate();
                message = count > 0 ? "Employee deleted successfully!" : "Employee ID not found.";
            }
        }
    }
} catch (Exception e) {
    message = "Error: " + e.getMessage();
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee CRUD Application</title>
</head>
<body>
    <h2>Employee Management System</h2>

    <p><b><%= message %></b></p>

    <h3>Add / Update Employee</h3>
    <form method="post" action="index.jsp">
        <label>Employee ID:</label>
        <input type="number" name="id" required><br><br>

        <label>Name:</label>
        <input type="text" name="name" required><br><br>

        <label>Department:</label>
        <input type="text" name="department" required><br><br>

        <label>Salary:</label>
        <input type="number" name="salary" step="0.01" min="0" required><br><br>

        <button type="submit" name="action" value="add">Add Employee</button>
        <button type="submit" name="action" value="update">Update Employee</button>
    </form>

    <h3>Delete Employee</h3>
    <form method="post" action="index.jsp">
        <label>Employee ID:</label>
        <input type="number" name="id" required>
        <button type="submit" name="action" value="delete">Delete Employee</button>
    </form>

    <h3>Employee Records</h3>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jsp_crud", "root", "root");
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM employees")) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getDouble("salary") %></td>
        </tr>
        <%
                }
            }
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="4">Error loading records: <%= e.getMessage() %></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
