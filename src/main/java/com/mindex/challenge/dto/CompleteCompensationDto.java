package com.mindex.challenge.dto;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

/**
 * Data Transfer Object for Compensation data.
 * This class is designed to encapsulate the Compensation data along with the associated Employee details,
 * allowing for easy transfer and access of combined data within the application.
 */
public class CompleteCompensationDto {
    private Compensation compensation;
    private Employee employee;

    public CompleteCompensationDto(Compensation compensation, Employee employee) {
        this.compensation = compensation;
        this.employee = employee;
    }

    public Compensation getCompensation() {
        return compensation;
    }

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
