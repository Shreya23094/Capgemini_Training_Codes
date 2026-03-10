package com.dk.dao;

import java.sql.Date;

public class Employee {

    private Date hire_date;
    private Double salary;
    private Integer employee_id;
    private Integer manager_id;
    private Integer department_id;
    private String phone_number;
    private String first_name;
    private String last_name;
    private String email;
    private String job_title;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(Date hire_date, Double salary, Integer employee_id,
                    Integer manager_id, Integer department_id,
                    String phone_number, String first_name,
                    String last_name, String email, String job_title) {
        this.hire_date = hire_date;
        this.salary = salary;
        this.employee_id = employee_id;
        this.manager_id = manager_id;
        this.department_id = department_id;
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.job_title = job_title;
    }

    // Getters

    public Date getHire_date() {
        return hire_date;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getJob_title() {
        return job_title;
    }

    // Setters

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    // toString() Override

    @Override
    public String toString() {
        return "Employee {" +
                "ID=" + employee_id +
                ", Name='" + first_name + " " + last_name + '\'' +
                ", Email='" + email + '\'' +
                ", Phone='" + phone_number + '\'' +
                ", Hire Date=" + hire_date +
                ", Job Title='" + job_title + '\'' +
                ", Salary=" + salary +
                ", Manager ID=" + manager_id +
                ", Department ID=" + department_id +
                '}';
    }
}