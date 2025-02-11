package com.backend.practical.repository;

import com.backend.practical.model.Employee;
import com.backend.practical.utils.JsonFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    @Autowired
    private JsonFileUtil jsonFileUtil;

    public List<Employee> findAll() {
        return jsonFileUtil.readEmployees();
    }

    public Optional<Employee> findById(int id) {
        return jsonFileUtil.readEmployees().stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
    }

    public Employee save(Employee employee) {
        List<Employee> employees = jsonFileUtil.readEmployees();

        // Generate next ID
        int nextId = employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(0) + 1;

        employee.setId(nextId);
        employees.add(employee);
        jsonFileUtil.writeEmployees(employees);
        return employee;
    }
}
