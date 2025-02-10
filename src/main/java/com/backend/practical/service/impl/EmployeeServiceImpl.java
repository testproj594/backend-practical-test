package com.backend.practical.service.impl;


import com.backend.practical.model.Employee;
import com.backend.practical.repository.EmployeeRepository;
import com.backend.practical.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        List<Employee> employees = repository.getAllEmployees();

        // Check if ID already exists
        boolean exists = employees.stream().anyMatch(emp -> emp.getId() == employee.getId());

        if (exists) {
            return false; // Employee already exists, don't add
        }

        // Save the employee if the ID is unique
        logger.info("Adding new employee: {}", employee);
        repository.saveEmployee(employee);
        return true;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> getEmployees(String name, Double fromSalary, Double toSalary) {
        return repository.getAllEmployees().stream()
                .filter(emp -> name == null || emp.getFirstName().toLowerCase().contains(name.toLowerCase()) || emp.getLastName().toLowerCase().contains(name.toLowerCase()))
                .filter(emp -> fromSalary == null || emp.getSalary() >= fromSalary)
                .filter(emp -> toSalary == null || emp.getSalary() <= toSalary)
                .collect(Collectors.toList());
    }
}
