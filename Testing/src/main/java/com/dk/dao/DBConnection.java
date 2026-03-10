package com.dk.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {

    private static MysqlDataSource dataSource;

    static {
        dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/company_db");
        dataSource.setUser("root");
        dataSource.setPassword("sa@02@272820");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}