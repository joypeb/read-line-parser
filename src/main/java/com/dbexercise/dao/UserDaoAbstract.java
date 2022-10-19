package com.dbexercise.dao;

import com.dbexercise.domain.User;

import java.sql.*;

public abstract class UserDaoAbstract {

    public abstract Connection makeConnection() throws Exception;

    AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();

    public void add(User user) throws Exception {
        AWSUserDaoImpl awsUserDao = new AWSUserDaoImpl();
        Connection c = awsConnectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO likelionDB.users(id,name,password) VALUES (?,?,?)"
        );

        ps.setString(1, user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public void select() throws Exception {
        AWSUserDaoImpl awsUserDao = new AWSUserDaoImpl();
        Connection c = awsUserDao.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "SELECT * from likelionDB.users where id = ?"
        );

        ps.setString(1, "12");
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.printf("id : %s, user : %s, password : %s",rs.getString(1),rs.getString(2),rs.getString(3));

        ps.close();
        c.close();
    }

   /* public static void main(String[] args) throws SQLException {
        UserDao2 userDao2 = new UserDao2();
        //userDao2.add();

        //userDao2.add(new User("122","aa","1234"));
        userDao2.select();
    }
*/
}
