import java.io.*;
import java.sql.*;

class DBPreparedUPdate {
    public static void main(String args[]) {
        Connection con;
        ResultSet rs;
        DataInputStream din = new DataInputStream(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?characterEncoding=utf-8", "root", "");
            PreparedStatement pst = con.prepareStatement("UPDATE emp SET name = ? WHERE id = ?");
            pst.setString(1, "NewName"); // New name to be updated
            pst.setString(2, "e1"); // Employee ID to identify the record
            int i = pst.executeUpdate();
            System.out.println(i + " records updated");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
