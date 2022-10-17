package com.dbexercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class UserDao {
    public void add() {
        Properties properties = new Properties();
        try {
            Reader reader = new FileReader("./.properties");
            properties.load(reader);

            Connection c = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );

            PreparedStatement ps = c.prepareStatement(
                    "insert into likelionDB.users(id,name,password) values(?,?,?)"
            );

            ps.setString(1,"01");
            ps.setString(2,"Eunbin");
            ps.setString(3,"password");

            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        dao.add();
    }
}
