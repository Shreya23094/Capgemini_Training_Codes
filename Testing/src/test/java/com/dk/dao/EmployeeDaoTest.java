package com.dk.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoTest {

    @Test
    void testInsertAndFetchEmployee() throws SQLException {

        EmployeeDao dao = new EmployeeDao();

        try (Connection connection = DBConnection.getConnection();
             Statement st = connection.createStatement()) {

            st.executeUpdate(
                    "INSERT IGNORE INTO department (department_id, department_name) VALUES (5, 'IT')"
            );
        }

        Integer testId = 999;
        Employee emp = new Employee(
                Date.valueOf("2000-05-12"),
                58200.0,
                testId,
                100,
                5,
                "3456789",
                "Aditya",
                "Sharma",
                "adi@gmail.com",
                "Manager"
        );

        //dao.insertEmployee(emp);

        List<Employee> employees = dao.getAllEmployees(999);

        assertNotNull(employees);
        assertTrue(employees.stream()
                .anyMatch(e -> e.getEmployee_id().equals(testId)));

        System.out.println(employees);

        System.out.println(dao.deleteEmployee(999));
    }
}