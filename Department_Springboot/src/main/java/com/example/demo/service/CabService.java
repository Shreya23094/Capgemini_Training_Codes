package com.example.demo.service;

import com.example.demo.entity.Cab;
import com.example.demo.repository.CabRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabService {

    private final CabRepository repository;

    public CabService(CabRepository repository) {
        this.repository = repository;
    }

    public Cab addCab(Cab cab) {
        return repository.save(cab);
    }

    public List<Cab> getAllCabs() {
        return repository.findAll();
    }

    public Cab getCab(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cab not found"));
    }

    public void deleteCab(Long id) {
        repository.deleteById(id);
    }
}