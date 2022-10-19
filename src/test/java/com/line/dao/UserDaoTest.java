package com.line.dao;

import com.dbexercise.dao.AWSConnectionMaker;
import com.dbexercise.domain.User;
import com.dbexercise.dao.UserDao;
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
