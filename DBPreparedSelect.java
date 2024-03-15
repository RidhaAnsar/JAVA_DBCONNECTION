import java.io.*;
import java.sql.*;

class DBPreparedSelect {
    public static void main(String args[]) {
        Connection con;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?characterEncoding=utf-8", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM emp WHERE id = ?");
            pst.setString(1, "e1"); // Employee ID to identify the record
            rs = pst.executeQuery();
            while(rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
