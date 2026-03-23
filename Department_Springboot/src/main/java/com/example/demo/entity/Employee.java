package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @ManyToOne
    @JoinColumn(name = "cab_id")
    private Cab cab;

    public Cab getCab() { return cab; }
    public void setCab(Cab cab) { this.cab = cab; }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Basic Info
    private String name;
    private String email;
    private String phone;

    // 🔹 Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // 🔹 Address Info
    private String address;
    private String city;
    private String pincode;

    // 🔹 Transport Details
    private String pickupLocation;
    private String dropLocation;
    private String transportType; // Cab / Bus
    private String shiftTime;

    // 🔹 Optional (extra real-world fields)
    private String employeeCode;
    private String designation;

    // ===== Getters & Setters =====
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public Department getDepartment() { return department; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getPincode() { return pincode; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public String getTransportType() { return transportType; }
    public String getShiftTime() { return shiftTime; }
    public String getEmployeeCode() { return employeeCode; }
    public String getDesignation() { return designation; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDepartment(Department department) { this.department = department; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setPincode(String pincode) { this.pincode = pincode; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }
    public void setTransportType(String transportType) { this.transportType = transportType; }
    public void setShiftTime(String shiftTime) { this.shiftTime = shiftTime; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }
    public void setDesignation(String designation) { this.designation = designation; }
}