package com.hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class ConnectionMaker {
    public Connection makeConnection() {
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
}
