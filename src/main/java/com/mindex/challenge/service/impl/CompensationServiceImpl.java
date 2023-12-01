package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    private final CompensationRepository compensationRepository;

    //Constructor injection is preferred over field injection because it improves testability level of class.
    public CompensationServiceImpl(CompensationRepository compensationRepository) {
        this.compensationRepository = compensationRepository;
    }

    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);
        compensation.setEmployeeId(compensation.getEmployeeId());
        return compensationRepository.insert(compensation);
    }

    @Override
    public Compensation findByEmployeeId(String employeeId) {
        LOG.debug("Fetching compensation with employee id [{}]", employeeId);
        return compensationRepository.findByEmployeeId(employeeId);
    }
}
