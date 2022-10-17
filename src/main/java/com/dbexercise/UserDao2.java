package com.dbexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UserDao2 {
    public void add() throws SQLException {
        Map<String,String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO likelionDB.users(id,name,password) VALUES (?,?,?)"
        );

        ps.setString(1, "12");
        ps.setString(2,"eunbin2");
        ps.setString(3,"123");

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        UserDao2 userDao2 = new UserDao2();
        userDao2.add();
    }
}
