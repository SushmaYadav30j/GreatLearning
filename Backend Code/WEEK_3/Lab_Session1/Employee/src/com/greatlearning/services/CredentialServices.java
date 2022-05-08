package com.greatlearning.services;
import java.util.Random;

import com.greatlearning.lab.Employee;

public class CredentialServices {
//	private emailAddress;
	public String generatePassword() {
		String generatePassword="";
		
		String numbers="1234567890";
		String capitallatters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smalllatters="abcdefghijklmnopqrstuvwxyz";
		String specialCharacters="!@#$%^&*()";
		
		Random ran=new Random();
		char[] password=new char[8];
		
		int lengthofNumbers=numbers.length();
		int lengthofCapitallatters=capitallatters.length();
		int lengthofSmalllatters=smalllatters.length();
		int lengthofSpecialCharacters=specialCharacters.length();
		int j = 0 ;
		int randomNextInteger = 0;
		for(int i=0; i<2; i++) {
			
			randomNextInteger=ran.nextInt(lengthofNumbers);
			password[j]= numbers.charAt(randomNextInteger);
			j=j+1;
			randomNextInteger=ran.nextInt(lengthofCapitallatters);
			password[j]= capitallatters.charAt(randomNextInteger);
			j=j+1;
			randomNextInteger=ran.nextInt(lengthofSmalllatters);
			password[j]= smalllatters.charAt(randomNextInteger);
			j=j+1;
			randomNextInteger=ran.nextInt(lengthofSpecialCharacters);
			password[j]= specialCharacters.charAt(randomNextInteger);
			j=j+1;
		}
		generatePassword=password.toString();
		return generatePassword;
		}
	
	
	
	public String generateEmailAddress(String firstname, String lastname, String departmentName) {
		String generatedemailAddress = firstname+lastname+"@"+departmentName+".greatlearning.com";
		return generatedemailAddress;
	}
	
	
	public void showCredential(Employee employeeObject, String email, String generatedPassword) {
		System.out.println("Dear "+employeeObject.getFirstname()+" your generated credentials are as follow");
		System.out.println("Your generated Email Address is :"+email);
		System.out.println("Your generated Password is :"+generatedPassword);
		
	}
}
