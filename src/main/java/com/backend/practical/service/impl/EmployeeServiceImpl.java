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
        List<Employee> employees = employeeRepository.findAll();

        if (name != null && !name.isEmpty()) {
            // If name is provided, return all matching employees (Ignore Salary Filters)
            List<Employee> matchingEmployees = employees.stream()
                    .filter(emp -> emp.getFirstName().toLowerCase().contains(name.toLowerCase())
                            || emp.getLastName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());

            // If matching employees found, return them (Ignore salary)
            if (!matchingEmployees.isEmpty()) {
                return matchingEmployees;
            }
        }

        // If name is not matched or not provided, apply salary filters
        return employees.stream()
                .filter(emp -> (fromSalary == null || emp.getSalary() >= fromSalary))
                .filter(emp -> (toSalary == null || emp.getSalary() <= toSalary))
                .collect(Collectors.toList());
    }
}
