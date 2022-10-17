package com.dbexercise;

import java.sql.*;
import java.util.Map;

public class UserDao2 {
    public Connection connection() {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void add() throws SQLException {
        UserDao2 userDao2 = new UserDao2();
        Connection conn = userDao2.connection();
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

    public void select() throws SQLException {
        UserDao2 userDao2 = new UserDao2();
        Connection conn = userDao2.connection();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * from likelionDB.users where id = ?"
        );

        ps.setString(1, "12");
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.printf("id : %s, user : %s, password : %s",rs.getString(1),rs.getString(2),rs.getString(3));

        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        UserDao2 userDao2 = new UserDao2();
        //userDao2.add();
        userDao2.select();
    }
}
