import java.sql.*;

public class TransactionManagementS {

public static void main(String[] args) {
Connection conn = null;
try {
Class.forName(&quot;com.mysql.jdbc.Driver&quot;);
conn =
DriverManager.getConnection(&quot;jdbc:mysql://localhost:3306/emp_db?characterEncoding=ut
f8&quot;,
&quot;root&quot;,
&quot;&quot;);
conn.setAutoCommit(false);
Statement stmt = conn.createStatement();
String insertQuery = &quot;INSERT INTO Department (dno, dname, dloc) VALUES (102, &#39;HR&#39;,
&#39;Kottayam&#39;)&quot;;
stmt.executeUpdate(insertQuery);

String updateQuery = &quot;UPDATE Department SET dname = &#39;Human Resources&#39; WHERE
dno = 102&quot;;
stmt.executeUpdate(updateQuery);

String deleteQuery = &quot;DELETE FROM Department WHERE dno = 102&quot;;
stmt.executeUpdate(deleteQuery);

conn.commit();

System.out.println(&quot;Transaction committed successfully.&quot;);
} catch (Exception e) {

try {
if (conn != null) {
conn.rollback();
System.out.println(&quot;Transaction rolled back successfully.&quot;);
}
} catch (SQLException ex) {
ex.printStackTrace();
}
e.printStackTrace();
} finally {

try {
if (conn != null)
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}
}
