package com.greatlearning.lab;
import java.util.Scanner;
import java.util.Random;

class Password_1 {
	
	String PasswordGenrator() {
	
	 int leftLimit = 33;
	    int rightLimit = 126;
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();

	    return generatedString;
	}
	
	

}

class Employee_1 extends Password {
	
	String first_name, last_name, Random_Password;
	
	Employee_1() {
		}
	
	Employee_1(String firstname, String lastname) {
		
		first_name = firstname;
		last_name = lastname;
			}
	
	void Department(int option){
		Password_1 obj1=new Password_1();
		Random_Password = obj1.PasswordGenrator();
	switch(option) {
	case 1:
	{	System.out.println("Dear "+first_name+" your generated credentials are as follows");
		System.out.println("Email        --->  "+first_name+last_name+"@tech.iit.com");
		System.out.println("Password ---> "+Random_Password);
	break;
	}case 2:
	{	System.out.println("Dear "+first_name+" your generated credentials are as follows");
		System.out.println("Email        --->  "+first_name+last_name+"@admin.iit.com");
		System.out.println("Password ---> "+Random_Password);
		break;
	}case 3:
	{	System.out.println("Dear "+first_name+" your generated credentials are as follows");
		System.out.println("Email        --->  "+first_name+last_name+"@hr.iit.com");
		System.out.println("Password ---> "+Random_Password);
		break;
	}case 4:
	{	System.out.println("Dear "+first_name+" your generated credentials are as follows");
		System.out.println("Email        --->  "+first_name+last_name+"@legal.iit.com");
		System.out.println("Password ---> "+Random_Password);
		break;
	}default:
	{	System.out.println("Wrong option choose");	
	}
	}
	}
	}

public class Employee extends Employee_1
{
	
	public static void main(String[]args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your First Name");
		String firstname=sc.nextLine();
		System.out.println("Enter your Last Name");
		String lastname=sc.nextLine(); 
		Employee_1 obj=new Employee_1(firstname, lastname);
		System.out.println("Select a num from out of below");
		System.out.println("1 for Technical Department");
		System.out.println("2 for Admin Department");
		System.out.println("3 for Human Resource Department");
		System.out.println("4 for Legal Department");
		int option=sc.nextInt();
		obj.Department(option);

		}	
		
		
	}
