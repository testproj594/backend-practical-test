package com.backend.practical.service.impl;

import com.backend.practical.model.Employee;
import com.backend.practical.repository.EmployeeRepository;
import com.backend.practical.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployees(String name, Double fromSalary, Double toSalary) {
        return employeeRepository.findAll().stream()
                .filter(emp -> (name == null || emp.getFirstName().contains(name) || emp.getLastName().contains(name)))
                .filter(emp -> (fromSalary == null || emp.getSalary() >= fromSalary))
                .filter(emp -> (toSalary == null || emp.getSalary() <= toSalary))
                .collect(Collectors.toList());
    }
}
