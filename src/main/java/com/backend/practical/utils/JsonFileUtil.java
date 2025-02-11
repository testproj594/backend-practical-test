package com.backend.practical.utils;

import com.backend.practical.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonFileUtil {
    private static final String FILE_PATH = "src/main/resources/employees.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<Employee> readEmployees() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void writeEmployees(List<Employee> employees) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), employees);
        } catch (Exception ignored) {
        }
    }
}
