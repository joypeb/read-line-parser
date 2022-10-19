package com.dbexercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class LocalUserDaoImpl extends UserDaoAbstract{

    @Override
    public Connection makeConnection() throws Exception {
        Map<String, String> env = System.getenv();

        Connection c = DriverManager.getConnection("localhost","user","123123");

        return c;
    }
}
