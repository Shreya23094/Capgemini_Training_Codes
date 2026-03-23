package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getDept(@PathVariable int id) {
        if (id <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Error("The response is giving error because the id is less than 0."));
        }
        return ResponseEntity.ok(
                new DepartmentMapper(1, "IT", "Delhi")
        );
    }
}

class DepartmentMapper {
    public int id;
    public String name;
    public String code;

    public DepartmentMapper(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
class Error{
    public String message;
    public Error(String message){
        this.message = message;
    }
}