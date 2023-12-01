package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.dto.CompleteCompensationDto;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compensation")
public class CompensationController {
    private final CompensationService compensationService;
    private final EmployeeService employeeService;

    public CompensationController(CompensationService compensationService, EmployeeService employeeService) {
        this.compensationService = compensationService;
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public CompleteCompensationDto getByEmployeeId(@PathVariable String employeeId) {
        Compensation compensation = compensationService.findByEmployeeId(employeeId);
        Employee employee = employeeService.read(employeeId);
        return new CompleteCompensationDto(compensation, employee);
    }

    @PostMapping
    public ResponseEntity<Compensation> createCompensation(@RequestBody Compensation compensation) {
        Employee employee = employeeService.read(compensation.getEmployeeId());
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Compensation createdCompensation = compensationService.create(compensation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompensation);
    }
}
