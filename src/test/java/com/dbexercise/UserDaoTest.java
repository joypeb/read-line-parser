package com.dbexercise;

import com.dbexercise.dao.UserDao;
import com.dbexercise.dao.UserDaoFactory;
import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

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