package com.dk.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {

    public void printAllEmployees() throws SQLException {

        String sql = "SELECT * FROM employee";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                System.out.println(
                        "Employee ID: " + resultSet.getInt("employee_id") +
                                ", Name: " + resultSet.getString("first_name") + " " +
                                resultSet.getString("last_name") +
                                ", Email: " + resultSet.getString("email") +
                                ", Phone: " + resultSet.getString("phone_number") +
                                ", Hire Date: " + resultSet.getDate("hire_date") +
                                ", Job Title: " + resultSet.getString("job_title") +
                                ", Salary: " + resultSet.getDouble("salary") +
                                ", Manager ID: " + resultSet.getObject("manager_id") +
                                ", Department ID: " + resultSet.getObject("department_id")
                );
            }
        }

        System.out.println("done");
    }
    public List<Employee> getAllEmployees(int empid) throws SQLException {

        String sql = "SELECT * FROM employee where employee_id = "+empid;
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Employee emp = new Employee(
                        rs.getDate("hire_date"),
                        rs.getDouble("salary"),
                        rs.getInt("employee_id"),
                        rs.getObject("manager_id") != null ?
                                rs.getInt("manager_id") : null,
                        rs.getObject("department_id") != null ?
                                rs.getInt("department_id") : null,
                        rs.getString("phone_number"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("job_title")
                );
                employees.add(emp);
            }
        }

        return employees;
    }

    public Employee insertEmployee(Employee emp) throws SQLException {

        String sql = "INSERT INTO employee " +
                "(employee_id, first_name, last_name, email, phone_number, hire_date, job_title, salary, manager_id, department_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, emp.getEmployee_id());
            ps.setString(2, emp.getFirst_name());
            ps.setString(3, emp.getLast_name());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getPhone_number());
            ps.setDate(6, emp.getHire_date());
            ps.setString(7, emp.getJob_title());
            ps.setDouble(8, emp.getSalary());
            ps.setObject(9, emp.getManager_id());
            ps.setObject(10, emp.getDepartment_id());

            ps.executeUpdate();
        }

        return emp;
    }

    public boolean deleteEmployee(int empid) throws SQLException {

        try (Connection connection = DBConnection.getConnection()){
            String sql = "DELETE FROM employee WHERE employee_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, empid);
            int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated!=1){
                throw new RuntimeException("some sql error occurred");
            }else{
                return true;
            }
        }
        finally {

        }
    }
}