package com.dbexercise;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectinMaker {
    Connection makeConnection() throws SQLException;
}
