import java.sql.*;

public class SQLExceptionExample {

// JDBC URL, username, and password of MySQL server
private static final String JDBC_URL =
"jdbc:mysql://localhost:3306/java_record?characterEncoding=UTF-8";
private static final String USERNAME = "root";
private static final String PASSWORD = "";

public static void main(String[] args) {
try {
// Load the MySQL JDBC driver
Class.forName("com.mysql.jdbc.Driver");

// Establish connection to the database
try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME,
PASSWORD)) {

// Create a statement
Statement statement = connection.createStatement();

// Execute a query that produces a warning
String query = "SELECT * FROM NonExistentTable";
ResultSet resultSet = statement.executeQuery(query);

// Retrieve SQLWarning (if any)
SQLWarning warning = statement.getWarnings();
if (warning != null) {
System.out.println("SQL Warning:");
while (warning != null) {
System.out.println("Message: " + warning.getMessage());
System.out.println("SQL State: " + warning.getSQLState());
System.out.println("Vendor Code: " + warning.getErrorCode());
warning = warning.getNextWarning();
}
}

} catch (SQLException e) {
// Handle SQL exception
System.out.println("SQL Exception:");
System.out.println("Message: " + e.getMessage());
System.out.println("SQL State: " + e.getSQLState());
System.out.println("Vendor Code: " + e.getErrorCode());
e.printStackTrace();
}
} catch (ClassNotFoundException e) {
System.out.println("Could not load MySQL JDBC driver.");
e.printStackTrace();
}}}
