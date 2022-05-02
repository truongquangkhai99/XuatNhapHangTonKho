/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DBConnection {

    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost;databaseName=Assigment;user=sa;password=1";
        return  DriverManager.getConnection(url);
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
//        DBConnection coonn = new DBConnection();
//        Connection con =coonn.getConnection();
//          Statement st = con.createStatement();
//            String user = "select*from clothes";
//            ResultSet rs = st.executeQuery(user);
//
//            while (rs.next()) {
//                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
//            }
//    }
}
