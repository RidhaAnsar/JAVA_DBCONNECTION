import java.io.*;
import java.sql.*;

public class LoginExample {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Establishing database connection
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?characterEncoding=utf-8", "username", "password");

            // Prompting user for credentials
            System.out.print("Enter username: ");
            String username = br.readLine();
            System.out.print("Enter password: ");
            String password = br.readLine();

            // Preparing SQL statement
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            // Executing the query
            rs = pst.executeQuery();

            // Checking if user exists
            if (rs.next()) {
                System.out.println("Login successful. Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
                if (br != null) br.close();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
