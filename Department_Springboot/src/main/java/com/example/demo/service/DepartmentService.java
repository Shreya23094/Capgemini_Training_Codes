package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department addDepartment(Department dept) {
        return repository.save(dept);
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartment(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department updateDepartment(Long id, Department dept) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        dept.setId(id);
        return repository.save(dept);
    }

    public Department partialUpdate(Long id, Department dept) {
        Department existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        if (dept.getName() == null) {
            dept.setName(existing.getName());
        }
        if (dept.getCode() == null) {
            dept.setCode(existing.getCode());
        }
        dept.setId(id);
        return repository.save(dept);
    }

    public void deleteDepartment(Long id) {
        Department existing = getDepartment(id);
        repository.delete(existing);
    }
}