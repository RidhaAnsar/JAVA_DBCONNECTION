import java.io.*;
import java.sql.*;

class DBPrepared {
    public static void main(String args[]) {
        Connection con;
        ResultSet rs;
        DataInputStream din = new DataInputStream(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?characterEncoding=utf-8", "root", "");
            PreparedStatement pst = con.prepareStatement("Insert into emp values(?, ?, ?)");
            pst.setString(1, "e1"); // Use double quotes for string literals
            pst.setString(2, "Milu");
            pst.setInt(3, 23); // Use setInt for an integer value
            int i = pst.executeUpdate();
            System.out.println(i + " records inserted");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

  
