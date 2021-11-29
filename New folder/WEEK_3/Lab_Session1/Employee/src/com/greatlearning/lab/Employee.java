package com.greatlearning.lab;

public class Employee {
	private String firstname;
	private String lastname;
	
	public Employee(){}
	
	public Employee(String firstname, String lastname){
		this.setFirstname(firstname);
		this.setLastname(lastname);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}