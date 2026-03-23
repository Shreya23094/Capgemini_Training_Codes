package com.example.demo.repository;

import com.example.demo.entity.Cab;
import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CabRepository extends JpaRepository<Cab, Long> {

    // 🔥 Custom query
    Optional<Department> findByName(String name);
}