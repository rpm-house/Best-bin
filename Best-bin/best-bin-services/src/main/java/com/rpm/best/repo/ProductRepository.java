package com.rpm.best.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.best.model.Product;

/**
 * @author MohanRamu
 *
 */
public interface ProductRepository extends MongoRepository<Product, Integer>, CustomQuery<Product> {

}
