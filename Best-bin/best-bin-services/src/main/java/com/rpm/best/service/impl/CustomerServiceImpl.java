package com.rpm.best.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm.best.model.Customer;
import com.rpm.best.model.DynamicQuery;
import com.rpm.best.repo.CustomQuery;
import com.rpm.best.repo.CustomerRepository;
import com.rpm.best.service.CustomerService;

/**
 * @author MohanRamu
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	// The dao repository will use the Mongodb-Repository to perform the database
	// operations.
	// @Autowired
	CustomerRepository dao;

	@Autowired
	public CustomerServiceImpl(CustomerRepository dao, CustomQuery<Customer> customQuery) {
		super();
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Customerservice#createCustomer(java.
	 * util.List)
	 */
	public void createCustomer(Customer customer) {
		dao.save(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Customerservice#createCustomer(java.
	 * util.List)
	 */
	public void createCustomers(List<Customer> customer) {
		dao.saveAll(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Customerservice#getAllCustomers()
	 */
	public Collection<Customer> getAllCustomers() {
		return dao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Customerservice#findCustomerById(int)
	 */
	public Optional<Customer> findCustomerById(int id) {
		return dao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Customerservice#deleteCustomerById(
	 * int)
	 */
	public void deleteCustomerById(int id) {
		dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Customerservice#updateCustomer(int)
	 */
	public void updateCustomer(Customer customer) {
		dao.save(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Customerservice#deleteAllCustomers()
	 */
	public void deleteAllCustomers() {
		dao.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rpm.services.service.CustomerService#getAllCustomers(com.rpm.services.
	 * model.DynamicQuery)
	 */
	@Override
	public Collection<Customer> getAllCustomers(DynamicQuery dynamicQuery) {
		dynamicQuery.setEntity("com.rpm.services.model.Customer");
		return dao.getByDynamicQuery(dynamicQuery);
	}

}