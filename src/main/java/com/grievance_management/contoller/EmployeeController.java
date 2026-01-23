package com.grievance_management.controller;

import com.grievance_management.dto.EmployeeRegisterRequest;
import com.grievance_management.entity.Employee;
import com.grievance_management.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> register(
            @RequestBody EmployeeRegisterRequest request) {

        System.out.println("CONTROLLER: /register hit");
        return ResponseEntity.ok(service.registerEmployee(request));
    }
}
