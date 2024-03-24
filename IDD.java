import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class IDD {
// JDBC URL, username, and password of MySQL server
private static final String URL =
"jdbc:mysql://localhost:3306/java_record?characterEncoding=UTF-8";
private static final String USER = "root";
private static final String PASSWORD = "";
public static void main(String[] args) {
try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
System.out.println("Could not load MySQL JDBC driver.");
e.printStackTrace();
return;
}
insertDepartmentData();
insertEmpData();
displayInformation();
}
private static void insertDepartmentData() {
try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
Statement statement = conn.createStatement()) {
String insertDept1 = "INSERT INTO Department (dno, dname, dloc) VALUES (1, 'Civil',
'Kochi')";
String insertDept2 = "INSERT INTO Department (dno, dname, dloc) VALUES (2, 'Accounts',
'Delhi')";
statement.executeUpdate(insertDept1);
statement.executeUpdate(insertDept2);
System.out.println("Department data inserted successfully.");
} catch (SQLException e) {
e.printStackTrace();
}
}
private static void insertEmpData() {
try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
Statement statement = conn.createStatement()) {
String insertEmp1 = "INSERT INTO Emp (eno, ename, esal, dno) VALUES (101, 'Chetan',
10000, 1)";
String insertEmp2 = "INSERT INTO Emp (eno, ename, esal, dno) VALUES (102, 'Amish',
20000, 2)";
statement.executeUpdate(insertEmp1);
statement.executeUpdate(insertEmp2);
System.out.println("Emp data inserted successfully.");
} catch (SQLException e) {
e.printStackTrace();
}
}
private static void displayInformation() {
try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
Statement statement = conn.createStatement()) {
String sql = "SELECT e.eno, e.ename, e.esal, d.dname, d.dloc " +
"FROM Emp e JOIN Department d ON e.dno = d.dno";
ResultSet resultSet = statement.executeQuery(sql);
System.out.println("eno\tename\tesal\tdname\tdloc");
System.out.println("-------------------------------------");
while (resultSet.next()) {
int eno = resultSet.getInt("eno");
String ename = resultSet.getString("ename");
double esal = resultSet.getDouble("esal");
String dname = resultSet.getString("dname");
String dloc = resultSet.getString("dloc");
System.out.printf("%d\t%s\t%.2f\t%s\t%s\n", eno, ename, esal, dname, dloc);
}

} catch (SQLException e) {
e.printStackTrace();
}
}
}