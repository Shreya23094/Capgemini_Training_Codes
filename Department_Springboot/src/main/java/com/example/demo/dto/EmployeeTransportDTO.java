package com.example.demo.dto;

public class EmployeeTransportDTO {

    private Long id;
    private String name;

    private String pickupLocation;
    private String dropLocation;
    private String transportType;
    private String shiftTime;

    private String departmentName;

    // ===== Getters & Setters =====
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public String getTransportType() { return transportType; }
    public String getShiftTime() { return shiftTime; }
    public String getDepartmentName() { return departmentName; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }
    public void setTransportType(String transportType) { this.transportType = transportType; }
    public void setShiftTime(String shiftTime) { this.shiftTime = shiftTime; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
}