package com.rpm.best.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.best.model.Employee;

/**
 * @author MohanRamu
 *
 */
public interface EmployeeRepository extends MongoRepository<Employee, Integer>, CustomQuery<Employee> {

}
