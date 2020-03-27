package com.rpm.best.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.best.model.Vehicle;

/**
 * @author MohanRamu
 *
 */
public interface VehicleRepository extends MongoRepository<Vehicle, Integer>, CustomQuery<Vehicle> {

}
