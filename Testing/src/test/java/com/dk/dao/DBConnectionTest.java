package com.dk.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class DBConnectionTest {

    @Test
    void testGetConnection() {
        Connection connection = null;
        try{
            connection = DBConnection.getConnection();
            System.out.println(connection);
            assertNotNull(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}