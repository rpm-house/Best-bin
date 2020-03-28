package com.rpm.best.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm.best.model.Product;
import com.rpm.best.model.DynamicQuery;
import com.rpm.best.repo.CustomQuery;
import com.rpm.best.repo.ProductRepository;
import com.rpm.best.service.ProductService;

/**
 * @author MohanRamu
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	// The dao repository will use the Mongodb-Repository to perform the database
	// operations.
	// @Autowired
	ProductRepository dao;

	@Autowired
	public ProductServiceImpl(ProductRepository dao, CustomQuery<Product> customQuery) {
		super();
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Productservice#createProduct(java.
	 * util.List)
	 */
	public void createProduct(Product product) {
		dao.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Productservice#createProduct(java.
	 * util.List)
	 */
	public void createProducts(List<Product> product) {
		dao.saveAll(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Productservice#getAllProducts()
	 */
	public Collection<Product> getAllProducts() {
		return dao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Productservice#findProductById(int)
	 */
	public Optional<Product> findProductById(int id) {
		return dao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Productservice#deleteProductById(
	 * int)
	 */
	public void deleteProductById(int id) {
		dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Productservice#updateProduct(int)
	 */
	public void updateProduct(Product product) {
		dao.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Productservice#deleteAllProducts()
	 */
	public void deleteAllProducts() {
		dao.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rpm.services.service.ProductService#getAllProducts(com.rpm.services.
	 * model.DynamicQuery)
	 */
	@Override
	public Collection<Product> getAllProducts(DynamicQuery dynamicQuery) {
		dynamicQuery.setEntity("com.rpm.services.model.Product");
		return dao.getByDynamicQuery(dynamicQuery);
	}

}