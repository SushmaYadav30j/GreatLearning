package com.greatlearning.driver;
import java.util.Scanner;
import com.greatlearning.lab.*;
import com.greatlearning.services.*;

public class Driver {
	public static void main(String[]args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to GreatLearning");
		System.out.println("Please Enter your First Name");
		String firstname=sc.nextLine().replaceAll(" ", "");
		System.out.println("Please Enter your Last Name");
		String lastname=sc.nextLine().replaceFirst(" ", ""); 
		
		
		System.out.println("Please Select the department from the following");
		System.out.println("1 for Technical Department");
		System.out.println("2 for Admin Department");
		System.out.println("3 for Human Resource Department");
		System.out.println("4 for Legal Department");
		
		int option=sc.nextInt();
		sc.close();
		
		String departmentName="";
		switch(option) {
		case 1:
		{	departmentName=Department.TECH.toString().toLowerCase();
		break;
		}case 2:
		{	departmentName=Department.ADMIN.toString().toLowerCase();
			break;
		}case 3:
		{	departmentName=Department.HR.toString().toLowerCase();
			break;
		}case 4:
		{	departmentName=Department.LEGAL.toString().toLowerCase();
			break;
		}default:
		{	System.out.println("Please select correct option");
			System.exit(0);
		}
		}	
		Employee employeeObject=new Employee(firstname, lastname);
		CredentialServices credentialservices=new CredentialServices();
		
		String generatedEmail = credentialservices.generateEmailAddress(firstname,lastname,departmentName);
		String generatedPassword=credentialservices.generatePassword();
		credentialservices.showCredential(employeeObject, generatedEmail, generatedPassword);
		
	}
	}
