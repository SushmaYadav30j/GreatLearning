package java.greatlearning.tech;

public class merge {

	void merge(double a[], int beg, int mid, int end)    
	{    
	    int i, j, k;  
	    int n1 = mid - beg + 1;    
	    int n2 = end - mid;    
	      
	        double LeftArray[] = new double[n1];  
	        double RightArray[] = new double[n2];  
	      
	    for (i = 0; i < n1; i++)    
	    LeftArray[i] = a[beg + i];    
	    for (j = 0; j < n2; j++)    
	    RightArray[j] = a[mid + 1 + j];    
	      
	    i = 0;  
	    j = 0;   
	    k = beg;  
	      
	    while (i < n1 && j < n2)    
	    {    
	        if(LeftArray[i] <= RightArray[j])    
	        {    
	            a[k] = LeftArray[i];    
	            i++;    
	        }    
	        else    
	        {    
	            a[k] = RightArray[j];    
	            j++;    
	        }    
	        k++;    
	    }    
	    while (i<n1)    
	    {    
	        a[k] = LeftArray[i];    
	        i++;    
	        k++;    
	    }    
	      
	    while (j<n2)    
	    {    
	        a[k] = RightArray[j];    
	        j++;    
	        k++;    
	    }
	}    
	  
	void mergeSort(double a[], int beg, int end)  
	{  
	    if (beg < end)   
	    {  
	        int mid = (beg + end) / 2;  
	        mergeSort(a, beg, mid);  
	        mergeSort(a, mid + 1, end);  
	        merge(a, beg, mid, end);  
	    }  
	}  

	void printAccendingArray(double a[], int n)  
	{  
		mergeSort(a, 0, n-1);
	    int i;  
	    for (i = 0; i < n; i++)  
	        System.out.print(a[i] + " ");  
	}  
	void printDecendingArray(double a[], int n)  
	{  
		mergeSort(a, 0, n-1);
	    int i;  
	    for (i = n-1; i >=0; i--)  
	        System.out.print(a[i] + " ");  
	}  
}
