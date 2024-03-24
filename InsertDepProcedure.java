import java.sql.*;
import java.util.Scanner;

public class InsertDepProcedure {
// JDBC URL, username, and password of MySQL server
private static final String JDBC_URL =
"jdbc:mysql://localhost:3306/java_record?characterEncoding=UTF-8";
private static final String USERNAME = "root";
private static final String PASSWORD = "";
private static final String INSERT_DEPARTMENT_PROCEDURE = "{call insert_department(?, ?,
?)}";
public static void main(String[] args) {
try {
// Load the MySQL JDBC driver
Class.forName("com.mysql.jdbc.Driver");

// Establish connection to the database
try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME,
PASSWORD);
CallableStatement callableStatement =
connection.prepareCall(INSERT_DEPARTMENT_PROCEDURE)) {

// Create a Scanner object for user input
Scanner scanner = new Scanner(System.in);

// Prompt the user to input the department number
System.out.print("Enter Department Number: ");
int departmentNumber = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter Department Name: ");
String departmentName = scanner.nextLine();
System.out.print("Enter Department Location: ");
String departmentLocation = scanner.nextLine();
callableStatement.setInt(1, departmentNumber);
callableStatement.setString(2, departmentName);
callableStatement.setString(3, departmentLocation);
callableStatement.executeUpdate();
System.out.println("Department inserted successfully.");
} catch (SQLException e) {
e.printStackTrace();
}
} catch (ClassNotFoundException e) {
System.out.println("Could not load MySQL JDBC driver.");
e.printStackTrace();
}}}