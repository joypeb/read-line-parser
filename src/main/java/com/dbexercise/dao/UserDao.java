package com.dbexercise.dao;

import com.dbexercise.domain.User;

import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

public class UserDao {
    private ConnectinMaker connectinMaker = new AWSConnectionMaker();

    public UserDao(ConnectinMaker connectinMaker) {
        this.connectinMaker = connectinMaker;
    }


    public void add(User user) throws SQLException {
        Connection c = connectinMaker.makeConnection();

        Properties properties = new Properties();
        try {
            Reader reader = new FileReader("./.properties");
            properties.load(reader);
            PreparedStatement ps = c.prepareStatement(
                    "insert into likelionDB.users(id,name,password) values(?,?,?)"
            );

            ps.setString(1,user.getId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getPassword());

            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findById(String id) throws SQLException {
        Connection c = connectinMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("" +
                "SELECT * FROM likelionDB.users WHERE id = ?"
        );

        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString(1), rs.getString(2), rs.getString(3));

        ps.close();
        c.close();
        rs.close();

        return user;
    }
    /*public static void main(String[] args) {
        UserDao dao = new UserDao();
        dao.add();
    }*/
}
