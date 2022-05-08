package java.greatlearning.tech;

import java.util.Scanner;
public class Stockers {
	
	public static void main(String args[]) {
	
	int noOfCompany;
	double[] sharePrice = null;
	boolean[] track = null;
	
	FinancialOperation fo = new FinancialOperation();			
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the no of companies");
	noOfCompany=sc.nextInt();
	
	if(noOfCompany>0) {
			sharePrice=new double[noOfCompany];
			track = new boolean[noOfCompany];
		for(int i=0; i<noOfCompany; i++) {
			int j = i + 1;
			System.out.println("Enter current stock price of the company " + j);
			sharePrice[i]=sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			track[i]=sc.nextBoolean();
		}
		}else
	{
		System.out.println("Number of company cannot be Zero. Please restart the program");	
	}
	
	for(;;)
	{
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");	
		System.out.println("--------------------------------------------");
		int m = sc.nextInt();
		switch(m)
		{
		case 1:
		{
			System.out.println("1. Display the companies stock prices in ascending order");
			fo.AscendingSort(sharePrice);
			break;
		}
		case 2:
		{
			System.out.println("2. Display the companies stock prices in descending order");
			fo.DecendingSort(sharePrice);
			break;
		}
		case 3:
		{
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			fo.StockRise(track);
			break;
		}
		case 4:
		{
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			fo.StockDecline(track);
			break;
		}
		case 5:
		{
			System.out.println("Enter stock price to search");
			double valueSearch = sc.nextDouble();
			System.out.println("5. Search a specific stock price");
			fo.StockPriceSearch(sharePrice, valueSearch);
			break;
		}
		case 0:
		{
			sc.close();
			System.exit(m);
		}
		default :
		{
		System.out.println("Please choose correct option");
		break;
		}
		}
	
	}
	}
}
