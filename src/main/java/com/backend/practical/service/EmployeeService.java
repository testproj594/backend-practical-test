package com.backend.practical.service;

import com.backend.practical.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployeeById(int id);
    List<Employee> getEmployees(String name, Double fromSalary, Double toSalary);
}

