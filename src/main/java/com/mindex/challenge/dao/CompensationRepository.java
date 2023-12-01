package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data repository for accessing Compensation data from the database.
 * Provides CRUD operations and custom queries for Compensation entities.
 */
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    Compensation findByEmployeeId(String employeeId);
}