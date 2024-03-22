import java.sql.*;

public class DisplayEmployeeData {
public static void main(String[] args) {

try {
Class.forName(&quot;com.mysql.jdbc.Driver&quot;);

Connection conn =
DriverManager.getConnection(&quot;jdbc:mysql://localhost:3306/emp_db?characterEncoding=ut
f8&quot;,
&quot;root&quot;,
&quot;&quot;);

CallableStatement cstmt = conn.prepareCall(&quot;{CALL GetAllEmployees()}&quot;);

ResultSet rs = cstmt.executeQuery();

System.out.println(&quot;Employee Data:&quot;);
System.out.println(&quot;Ename\tSalary&quot;);
while (rs.next()) {
String ename = rs.getString(&quot;Ename&quot;);
double salary = rs.getDouble(&quot;esal&quot;);
System.out.println(ename + &quot;\t&quot; + salary);
}

// Close resources
rs.close();
cstmt.close();
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
