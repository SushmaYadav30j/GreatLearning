package greatlearning.buildingconstruction.com;
import java.util.Arrays;
import java.util.Scanner;
import org.w3c.dom.Node;

public class BuildingConstruction {	   

	public static int array[];
	public static int array2[];
	public static int array3[];
	public int num,len;
	Node root=null;
	Scanner sc=new Scanner(System.in);
	public void function() {
	System.out.println("Enter the total no of floors in the building");
	num=sc.nextInt();
	array=new int[num];
	array2=new int[num];
	array3=new int[num];
	insertValue();
	Arrays.sort(array2);
	int k = num-1;
	int f = 0;
	for(int i=0; i<=k; i++)
	{	f = i+1;
		array3[i]=array2[k-i];
	//	System.out.println("Sorted Array value: "+i+"  "+ array3[i]);
	}

	printValue();
	
	}
	
	public void insertValue() {
		int j;
		for (int i=0; i<num; i++) {
			j=i+1;
			System.out.print("Enter the floor size given on day : " +j);
			array[i]=sc.nextInt();		
			array2[i]=array[i];
		}	
	}
	
	public void printValue() {
		int index1 = 0;
		int index2;
		System.out.println("The order of construction is as follow");
		//System.out.println("Day: "+f);
		for(int i=0; i<num; i++)
		{ int f = i + 1;
		System.out.println("Day:"+f);
			for(int j=0; j<=i;j++)
			{
				if (array[j]==array3[i])
				{
					index2 = i;
					//System.out.println("index 2 is "+index2);
					for(int a=index1;a<=index2;a++)
					{
						System.out.print(array3[a]);
	
					}
					index1 = index2+1;

				}
			}

		}
		}
		
	
	public static void main(String[]args) {
		BuildingConstruction obj= new BuildingConstruction();
		obj.function();
	}

}
