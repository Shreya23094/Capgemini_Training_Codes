package com.example.demo.controller;

import com.example.demo.entity.Cab;
import com.example.demo.service.CabService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabs")
public class CabController {

    private final CabService service;

    public CabController(CabService service) {
        this.service = service;
    }

    @PostMapping
    public Cab addCab(@RequestBody Cab cab) {
        return service.addCab(cab);
    }

    @GetMapping
    public List<Cab> getAllCabs() {
        return service.getAllCabs();
    }

    @GetMapping("/{id}")
    public Cab getCab(@PathVariable Long id) {
        return service.getCab(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCab(@PathVariable Long id) {
        service.deleteCab(id);
        return "Cab deleted";
    }
}