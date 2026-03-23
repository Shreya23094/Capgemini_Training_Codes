package com.example.demo.mapper;

import com.example.demo.dto.EmployeeTransportDTO;
import com.example.demo.entity.Employee;

public class EmployeeMapper {

    public static EmployeeTransportDTO toTransportDTO(Employee emp) {

        EmployeeTransportDTO dto = new EmployeeTransportDTO();

        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setPickupLocation(emp.getPickupLocation());
        dto.setDropLocation(emp.getDropLocation());
        dto.setTransportType(emp.getTransportType());
        dto.setShiftTime(emp.getShiftTime());

        if (emp.getDepartment() != null) {
            dto.setDepartmentName(emp.getDepartment().getName());
        }

        return dto;
    }
}