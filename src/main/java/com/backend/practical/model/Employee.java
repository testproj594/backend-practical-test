package com.backend.practical.model;

import java.sql.Date;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private double salary;
    private Date joinDate;
    private String department;

    public Employee() {}

    public Employee(int id, String firstName, String lastName,Date dateOfBirth, double salary,Date joinDate,String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth=dateOfBirth;
        this.salary = salary;
        this.joinDate=joinDate;
        this.department=department;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
