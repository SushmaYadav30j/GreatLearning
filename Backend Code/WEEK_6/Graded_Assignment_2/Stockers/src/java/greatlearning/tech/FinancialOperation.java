package java.greatlearning.tech;

public class FinancialOperation extends merge 
{
	
	public void AscendingSort(double[] sharePrice)
	{
		printAccendingArray(sharePrice, sharePrice.length);
	}
	
	public void DecendingSort(double[] sharePrice)
	{
		printDecendingArray(sharePrice, sharePrice.length);
	}
	
	public void StockRise(boolean[] track)
	{
		int m = 0;
		for(int i =0; i<track.length; i++)
		{
			if(track[i]==true)
			{
			m =m +1;	
			}
		}
		System.out.print("Total no of companies whose stock price rose today : "+m ); 
	}
	
	public void StockDecline(boolean[] track)
	{
		int m = 0;
		for(int i =0; i<track.length; i++)
		{
			if(track[i]==false)
			{
			m =m +1;	
			}
		}
		System.out.print("Total no of companies whose stock price declined today : "+m ); 
	}

	public void StockPriceSearch(double[] sharePrice, double valueSearch)
	{
		int j = 0;
		double m = valueSearch;
		for(int i =0; i<sharePrice.length; i++)
		{
			if(sharePrice[i]== m)
			{
				System.out.print(""+sharePrice[i] );
				j = 1;
			}
		}
		if(j==0)
		{
		System.out.print(""+m +"Not Available" );
		}
	}
}
