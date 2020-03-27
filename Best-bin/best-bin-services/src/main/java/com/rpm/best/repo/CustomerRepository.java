package com.rpm.best.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.best.model.Customer;

/**
 * @author MohanRamu
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, Integer>, CustomQuery<Customer> {

}
