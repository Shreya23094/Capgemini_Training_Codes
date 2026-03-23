package com.example.demo.controller;

import com.example.demo.dto.EmployeeTransportDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeTransportController {

    private final EmployeeService service;

    public EmployeeTransportController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/transport")
    public List<EmployeeTransportDTO> getTransportEmployees() {

        List<Employee> employees = service.getAllEmployees();

        return employees.stream()
                .map(EmployeeMapper::toTransportDTO)
                .toList();
    }
}