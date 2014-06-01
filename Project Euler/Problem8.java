import java.lang.Math;
import java.lang.Long;
import java.io.*;
import java.util.*;

public class Problem8 
{
	public static void main(String[] args) throws Exception
	{
		Scanner infile  = new Scanner ( new File(args[0]) );       
		int tokenNum = 0;
		String[] temp = new String[20];
		while( infile.hasNext() ) 
		{
			temp[tokenNum] = infile.next();  
			++tokenNum;
		}
		
		int count = 0;
		
		int[] arr = new int[temp.length * temp[0].length()];
		for( int i = 0; i < temp.length; i++)
		{
			for(int j = 0; j < temp[i].length(); j++)
			{
				arr[count] = Character.getNumericValue(temp[i].charAt(j));
				count++;
			}
		}
				
		int length = 13; 
		long prod = 1;
		long maxprod = 0;
		for (int i = length - 1; i < arr.length; i++)
		{
			prod = 1; 
			for(int j = 0; j < length; j++)
			{
				prod *= arr[i - j];
				
			}
			if (prod > maxprod)
			{
				maxprod = prod;
			}
		}
		
		System.out.println("Max product is: " + maxprod);
		
	}
	
}