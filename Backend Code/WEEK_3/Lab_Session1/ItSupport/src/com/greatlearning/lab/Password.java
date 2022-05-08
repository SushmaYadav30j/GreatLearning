package com.greatlearning.lab;

import java.util.Random;

public class Password {
	
	public static void main(String[]args) {
	
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

	    System.out.println(generatedString);
	

    System.out.println(generatedString);
	}
	
	

}
