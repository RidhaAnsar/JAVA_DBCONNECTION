import java.sql.*;

public class DisplayEmployeeData {

// JDBC URL, username, and password of MySQL server
private static final String JDBC_URL =
"jdbc:mysql://localhost:3306/java_record?characterEncoding=UTF-8";
private static final String USERNAME = "root";
private static final String PASSWORD = "";

// Stored procedure name
private static final String GET_EMPLOYEE_DATA_PROCEDURE = "{call
get_employee_data()}";

public static void main(String[] args) {
try {
// Load the MySQL JDBC driver
Class.forName("com.mysql.jdbc.Driver");

// Establish connection to the database
try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME,
PASSWORD);
CallableStatement callableStatement =
connection.prepareCall(GET_EMPLOYEE_DATA_PROCEDURE);
ResultSet resultSet = callableStatement.executeQuery()) {

// Print column headers
System.out.println("Employee Data:");
System.out.println("Ename \t Salary");
// Iterate through the result set and print Ename and Salary
while (resultSet.next()) {
String ename = resultSet.getString("ename");
double salary = resultSet.getDouble("esal");
System.out.println(ename + "\t" + salary);
}

} catch (SQLException e) {
e.printStackTrace();
}
} catch (ClassNotFoundException e) {
System.out.println("Could not load MySQL JDBC driver.");
e.printStackTrace();
}
}
}