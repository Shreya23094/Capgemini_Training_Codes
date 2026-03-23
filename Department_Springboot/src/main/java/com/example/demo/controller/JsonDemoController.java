package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class JsonDemoController {
    @GetMapping("/department")
    public String getDepartmentJson() throws JsonProcessingException{
        Department obj = new Department();
//        obj.setId(65);
        obj.setName("Tech");
        obj.setCode("IT065");
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(obj);

        ResponseEntity.ok().body(string);
        ResponseEntity.status(HttpStatus.CREATED).body(string);
        ResponseEntity.status(HttpStatus.NO_CONTENT);
        return string;
    }
}
