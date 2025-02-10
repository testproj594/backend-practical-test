package com.backend.practical.repository;


import com.backend.practical.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    private static final Logger logger = LogManager.getLogger(EmployeeRepository.class);

    private static final String FILE_PATH = "src/main/resources/employees.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Employee> getAllEmployees() {
        logger.debug("Fetching all employees from the database.");
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Optional<Employee> findById(int id) {
        return getAllEmployees().stream().filter(emp -> emp.getId() == id).findFirst();
    }

    public void saveEmployee(Employee employee) {
        logger.info("Saving employee to the database: {}", employee);

        List<Employee> employees = getAllEmployees();
        employees.add(employee);
        saveAllEmployees(employees);
    }

    private void saveAllEmployees(List<Employee> employees) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}