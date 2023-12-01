package com.mindex.challenge.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class CompensationServiceTest {

    public static final String EMPLYEE_ID = "1234567890abcdef";
    public static final double SALARY = 85000.00;
    public static final LocalDate DATE = LocalDate.of(2023, 1, 1);
    private CompensationService compensationService;

    @Mock
    private CompensationRepository compensationRepository;

    @BeforeEach
    void setUp() {
        compensationService = new CompensationServiceImpl(compensationRepository);
    }

    @Test
    void createCompensation_ValidData_ReturnsCompensation() {
        Compensation compensation = new Compensation(EMPLYEE_ID, SALARY, DATE);
        when(compensationRepository.insert(any(Compensation.class))).thenReturn(compensation);
        Compensation created = compensationService.create(compensation);
        assertNotNull(created);
    }

    @Test
    void createCompensation_ValidData_ReturnsCompensationWithCorrectSalary() {
        Compensation compensation = new Compensation(EMPLYEE_ID, SALARY, DATE);
        when(compensationRepository.insert(any(Compensation.class))).thenReturn(compensation);
        Compensation created = compensationService.create(compensation);
        assertEquals(compensation.getSalary(), created.getSalary());
    }

    @Test
    void createCompensation_ValidData_ReturnsCompensationWithCorrectDate() {
        Compensation compensation = new Compensation(EMPLYEE_ID, SALARY, DATE);
        when(compensationRepository.insert(any(Compensation.class))).thenReturn(compensation);
        Compensation created = compensationService.create(compensation);
        assertEquals(compensation.getEffectiveDate(), created.getEffectiveDate());
    }
}
