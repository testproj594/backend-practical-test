package com.backend.practical.controller;

import com.backend.practical.model.Employee;
import com.backend.practical.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addEmployee(@RequestBody Employee employee) {
        logger.info("Received request to add employee: {}", employee);
        boolean isAdded = service.addEmployee(employee);

        Map<String, String> response = new HashMap<>();
        if (!isAdded) {
            response.put("message", "Employee with ID " + employee.getId() + " already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        logger.info("Employee added successfully: {}", employee);
        response.put("message", "Employee added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = service.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Employee> getEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double fromSalary,
            @RequestParam(required = false) Double toSalary) {
        return service.getEmployees(name, fromSalary, toSalary);
    }
}
