package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cabNumber;
    private String driverName;
    private String driverPhone;
    private String vehicleType; // Sedan, SUV

    // 🔥 One cab → many employees
    @OneToMany(mappedBy = "cab")
    private List<Employee> employees;

    // ===== Getters & Setters =====
    public Long getId() { return id; }
    public String getCabNumber() { return cabNumber; }
    public String getDriverName() { return driverName; }
    public String getDriverPhone() { return driverPhone; }
    public String getVehicleType() { return vehicleType; }
    public List<Employee> getEmployees() { return employees; }

    public void setId(Long id) { this.id = id; }
    public void setCabNumber(String cabNumber) { this.cabNumber = cabNumber; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public void setDriverPhone(String driverPhone) { this.driverPhone = driverPhone; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}