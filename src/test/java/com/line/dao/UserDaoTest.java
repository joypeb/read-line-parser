package com.line.dao;

import com.dbexercise.AWSConnectionMaker;
import com.dbexercise.ConnectinMaker;
import com.dbexercise.User;
import com.dbexercise.UserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserDaoTest {

    @Test
    void addAndSelect() throws SQLException {
        UserDao userDao = new UserDao(new AWSConnectionMaker());
        String id = "21";
        userDao.add(new User(id,"t","123"));


    }
    /*@Test
    public void addAndSelect() throws SQLException {
        UserDao2 userDao2 = new UserDao2();
        User user = new User("8","testname","12344");

        userDao2.add(user);
        Assertions.assertEquals("testname",);
    }*/
}
