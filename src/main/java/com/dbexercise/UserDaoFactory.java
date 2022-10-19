package com.dbexercise;

public class UserDaoFactory {
    public UserDao awsUserDao() {
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
        UserDao userDao = new UserDao(awsConnectionMaker);
        return userDao;
    }

    public UserDao localUserDao() {
        LocalConnection localConnection = new LocalConnection();
        UserDao userDao = new UserDao(localConnection);
        return userDao;
    }
}
