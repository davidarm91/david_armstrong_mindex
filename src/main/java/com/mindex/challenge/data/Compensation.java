package com.mindex.challenge.data;

import java.time.LocalDate;

/**
 * Represents the compensation details of an employee.
 * This class links to an employee via their employeeId and
 * includes salary and effective date information.
 */
public class Compensation {
    private String employeeId;
    private double salary;
    private LocalDate effectiveDate;

    public Compensation(String employeeId, double salary, LocalDate effectiveDate) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public Compensation() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}

