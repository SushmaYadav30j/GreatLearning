package com.great.learning.service;

import java.util.List;

import com.great.learning.entity.Customer;

public interface CustomerService {
	
	void saveCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer getCustomer(int theId);

	void deleteCustomer(int theId);

	

	

}
