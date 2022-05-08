package com.great.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.great.learning.entity.Customer;
import com.great.learning.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		System.out.println("Request Recieved");
		
		 List<Customer> theCustomers = customerService.getAllCustomer();
		 System.out.println(theCustomers.size());
		 theModel.addAttribute("listcustomer", theCustomers);
			
		return "list-Customer";
	}

	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("Customer", theCustomer);
		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("Customer", theCustomer);
		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("customerId") int Id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {

		Customer theCustomer;
		if (Id != 0) {
			//Update 
			theCustomer = customerService.getCustomer(Id);
			theCustomer.setFirstname(firstname);
			theCustomer.setLastname(lastname);
			theCustomer.setEmail(email);
		} else {
			//Create
			theCustomer = new Customer(firstname, lastname, email);
		}
		customerService.saveCustomer(theCustomer);
		return "redirect:/customers/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customers/list";
	}

}
