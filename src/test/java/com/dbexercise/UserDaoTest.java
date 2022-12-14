package com.dbexercise;

import com.dbexercise.dao.UserDao;
import com.dbexercise.dao.UserDaoFactory;
import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {
    @Autowired
    ApplicationContext context;
    @Test
    void addAndSelect() throws SQLException {
        //UserDao userDao = new UserDao(new AWSConnectionMaker());
        //factory
        UserDao userDao = context.getBean("awsUserDao",UserDao.class);
        String id = "21";
        userDao.add(new User(id,"t","123"));

        User user = userDao.findById(id);

        Assertions.assertEquals("t", user.getName());
    }

}