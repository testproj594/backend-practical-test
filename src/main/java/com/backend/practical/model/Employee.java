package com.backend.practical.model;

import jakarta.validation.constraints.*;
import java.time.LocalDate;


public class Employee {

    private int id; // Will be generated automatically

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should contain only alphabets")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should contain only alphabets")
    private String lastName;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be a past date")
    private LocalDate dateOfBirth;

    @NotNull(message = "Salary is required")
    @Min(value = 1, message = "Salary should not be zero or less")
    private Double salary;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
