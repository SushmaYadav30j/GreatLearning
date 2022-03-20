package com.great.learning.service.impl;

import com.great.learning.service.CustomerService;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.great.learning.entity.Customer;


@Repository
public class CustomerServiceImpl implements CustomerService {

	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public void CustomeServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(thecustomer);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		List<Customer> customer = session.createQuery("from Customer").list();
		System.out.println("customer" + customer.size());
		return customer;
	}

	public Customer getCustomer(int id) {
		Customer myCustomer = session.get(Customer.class, id);
		return myCustomer;
	}

	@Transactional
	public void deleteCustomer(int id) {
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, id); 
		session.delete(customer);
		transaction.commit();
		
	}

}
