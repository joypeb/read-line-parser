package com.dbexercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void addAndSelect() throws SQLException {
        //UserDao userDao = new UserDao(new AWSConnectionMaker());
        //factory
        UserDao userDao = new UserDaoFactory().awsUserDao();
        String id = "21";
        userDao.add(new User(id,"t","123"));

        User user = userDao.findById(id);

        Assertions.assertEquals("t", user.getName());
    }

}