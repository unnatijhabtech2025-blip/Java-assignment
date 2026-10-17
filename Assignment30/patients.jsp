
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
            String sql = "INSERT INTO patients (patient_id, name, age, disease, treatment_status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
                ps.setString(2, request.getParameter("name"));
                ps.setInt(3, Integer.parseInt(request.getParameter("age")));
                ps.setString(4, request.getParameter("disease"));
                ps.setString(5, request.getParameter("treatment_status"));
                ps.executeUpdate();
                message = "Patient added successfully!";
            }
        } else if ("update".equals(action)) {
            String sql = "UPDATE patients SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, request.getParameter("name"));
                ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                ps.setString(3, request.getParameter("disease"));
                ps.setString(4, request.getParameter("treatment_status"));
                ps.setInt(5, Integer.parseInt(request.getParameter("patient_id")));

                int count = ps.executeUpdate();
                message = count > 0 ? "Patient updated successfully!" : "Patient ID not found.";
            }
        } else if ("delete".equals(action)) {
            String sql = "DELETE FROM patients WHERE patient_id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
                int count = ps.executeUpdate();
                message = count > 0 ? "Patient deleted successfully!" : "Patient ID not found.";
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
    <title>Patient Record Management</title>
</head>
<body>
    <h2>Patient Record Management System</h2>

    <p><b><%= message %></b></p>

    <h3>Add / Update Patient</h3>
    <form method="post" action="patients.jsp">
        Patient ID:
        <input type="number" name="patient_id" required><br><br>

        Name:
        <input type="text" name="name" required><br><br>

        Age:
        <input type="number" name="age" min="0" required><br><br>

        Disease:
        <input type="text" name="disease" required><br><br>

        Treatment Status:
        <select name="treatment_status" required>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>

        <button type="submit" name="action" value="add">Add Patient</button>
        <button type="submit" name="action" value="update">Update Patient</button>
    </form>

    <h3>Delete Patient</h3>
    <form method="post" action="patients.jsp">
        Patient ID:
        <input type="number" name="patient_id" required>
        <button type="submit" name="action" value="delete">Delete Patient</button>
    </form>

    <h3>Patient Records</h3>
    <table border="1" cellpadding="8">
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jsp_crud", "root", "root");
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM patients")) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
        </tr>
        <%
                }
            }
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="5">Error loading records: <%= e.getMessage() %></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
