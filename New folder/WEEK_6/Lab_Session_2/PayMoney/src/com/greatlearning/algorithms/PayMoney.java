package com.greatlearning.algorithms;
import java.util.Scanner;

public class PayMoney {
	
	public int num, targetNo, targetValue;
	public int array[];
	
	Scanner sc=new Scanner(System.in);
	
	public void insertValue() {
		for(int i=0; i<num; i++) {
			array[i]=sc.nextInt();
		}
	}
    public void target() {
    	while(targetNo>0) {
    		boolean IsTargetAchieved=false;
    		System.out.println("Enter the value of target");
    		targetValue=sc.nextInt();
    		
    		int sum=0;
    		int count=0;
    		
    		for(int value:array) {
    			count++;
    			sum=sum+value;
    			if(targetValue<=sum) {
    				IsTargetAchieved=true;
    				System.out.println("Target acheived after "+count+ " transactions");
    				break;
    			}
    		}
    		if(!IsTargetAchieved) {
    			System.out.println("Given target is not achieved");
    		}
    		targetNo--;
    	}
    }
		
	public void implementPayMoney() {
		System.out.println("Enter the size of Transaction array");
		num=sc.nextInt();
		array=new int[num];
		System.out.println("Enter the value of array");
		insertValue();	
		System.out.println("Enter the total no. of target thats need to be achieved");
		targetNo=sc.nextInt();
		target();
	}
	
	public static void main(String[]args) {
		PayMoney obj=new PayMoney();
		obj.implementPayMoney();
	}

}
