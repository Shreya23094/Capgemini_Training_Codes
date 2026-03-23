package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class MyGlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);

    @ExceptionHandler(exception = DepartmentNotFoundException.class)
    public ResponseEntity<Map<String,String>> returnDepartmentNotFoundException(DepartmentNotFoundException e){

    }
}