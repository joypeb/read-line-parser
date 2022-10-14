package com.hospital;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectDB {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try{
            Reader reader = new FileReader("./.properties");
            properties.load(reader);

            Connection conn = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM likelionDB.seoul_hospital"
            );

            while(rs.next()) {
                System.out.print("id:" + rs.getString(1));
                System.out.print(", address: " + rs.getString(2));
                System.out.print(", district: " + rs.getString(3));
                System.out.print(", category: " + rs.getString(4));
                System.out.print(", emergency_room: " + rs.getString(5));
                System.out.print(", name: " + rs.getString(6));
                System.out.print(", subdivision: " + rs.getString(7)+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
