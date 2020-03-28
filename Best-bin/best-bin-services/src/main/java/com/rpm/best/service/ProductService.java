package com.rpm.best.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.rpm.best.model.Product;
import com.rpm.best.model.DynamicQuery;

/**
 * @author MohanRamu
 *
 */
public interface ProductService {

	/**
	 * Method to create new products in the db using mongo-db repository.
	 * 
	 * @param product
	 */
	public void createProduct(Product product);

	/**
	 * Method to create new products in the db using mongo-db repository.
	 * 
	 * @param product
	 */
	public void createProducts(List<Product> product);

	/**
	 * Method to fetch all products from the db using mongo-db repository.
	 * 
	 * @return
	 */
	public Collection<Product> getAllProducts();

	/**
	 * Method to fetch product by id using mongo-db repository.
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Product> findProductById(int id);

	/**
	 * Method to delete product by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void deleteProductById(int id);

	/**
	 * Method to update product by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void updateProduct(Product product);

	/**
	 * Method to delete all products using mongo-db repository.
	 */
	public void deleteAllProducts();

	public Collection<Product> getAllProducts(DynamicQuery dynamicQuery);
}