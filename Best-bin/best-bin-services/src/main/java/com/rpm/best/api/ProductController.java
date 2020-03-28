package com.rpm.best.api;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpm.best.model.Product;
import com.rpm.best.model.DynamicQuery;
import com.rpm.best.service.ProductService;

/**
 * @author MohanRamu
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save products in the db.
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping(value = "/create")
	public String create(@RequestBody Product product) {
		logger.debug("Saving products.");
		service.createProduct(product);
		return "Product records created.";
	}

	/**
	 * Method to save products in the db.
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping(value = "/createAll")
	public String createAll(@RequestBody List<Product> product) {
		logger.debug("Saving products.");
		service.createProducts(product);
		return "Product records created.";
	}

	/**
	 * Method to fetch all products from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall")
	public Collection<Product> getAll() {
		logger.debug("Getting all products.");
		return service.getAllProducts();
	}

	/**
	 * Method to fetch all products from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall/{key}/{value}/{operator}")
	public Collection<Product> getAllByDynamicQuery(@PathVariable(value = "key") String key,
			@PathVariable(value = "value") String value, @PathVariable(value = "operator") String operator) {
		logger.debug("Getting all products.");
		DynamicQuery dynamicQuery = new DynamicQuery();
		dynamicQuery.setKey(key);
		dynamicQuery.setValue(value);
		dynamicQuery.setOperator(operator);
		return service.getAllProducts(dynamicQuery);
	}

	/**
	 * Method to fetch product by id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getbyid/{product-id}")
	public Optional<Product> getById(@PathVariable(value = "product-id") int id) {
		logger.debug("Getting product with product-id= {}.", id);
		return service.findProductById(id);
	}

	/**
	 * Method to update product by id.
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value = "/update/{product-id}")
	public String update(@PathVariable(value = "product-id") int id, @RequestBody Product e) {
		logger.debug("Updating product with product-id= {}.", id);
		e.setProductId(id);
		service.updateProduct(e);
		return "Product record for product-id= " + id + " updated.";
	}

	/**
	 * Method to delete product by id.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{product-id}")
	public String delete(@PathVariable(value = "product-id") int id) {
		logger.debug("Deleting product with product-id= {}.", id);
		service.deleteProductById(id);
		return "Product record for product-id= " + id + " deleted.";
	}

	/**
	 * Method to delete all products from the db.
	 * 
	 * @return
	 */
	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all products.");
		service.deleteAllProducts();
		return "All product records deleted.";
	}
}