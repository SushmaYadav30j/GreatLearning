package com.greatlearning.algorithms;
import java.util.Scanner;


public class CountCurrency {
		
	public static void CountCurrencyImplementation(int notes[],int amount)
    {
		if(amount==0)
			return;
		
		int[] noteCounter =new int[notes.length];
		
		for(int i=0; i<notes.length; i++) {
			if(amount==0) {
				System.out.println();
			}
			if(amount>=notes[i]) {
				noteCounter[i] = amount / notes[i];
                amount = amount - noteCounter[i] * notes[i];
			}
		}
		
		if(amount>0) {
			System.out.println("Wrong input");
		}
		else {
			System.out.println("Your payment approach in order to give min no of notes will be");
			 for (int i = 0; i < notes.length; i++) {
		            if (noteCounter[i] != 0) {
		                System.out.println(notes[i] + " : " + noteCounter[i]);
		            }
			 }
		}
		
    }
	public static void main(String argc[]){
		System.out.println("Enter the size of currency denominations");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] notes = new int[num];
		System.out.println("Enter the currency denominations value");
		for(int i=0; i<num; i++) {
			notes[i]=sc.nextInt();
		}
		System.out.println("Enter the amount you want to pay");
		int amount = sc.nextInt();
	     CountCurrencyImplementation(notes,amount);
    }
}
