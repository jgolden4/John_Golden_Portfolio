import java.lang.Math;
import java.lang.Long;
import java.io.*;
import java.util.*;

public class Problem9 
{
	public static void main(String[] args) throws Exception
	{
		double c = 0;
		for (int i = 0; i < 500; i++)
		{
			for (int j = i + 1; j < 500; j++)
			{
				c = Math.sqrt(i*i + j*j);
				if (sum(i, j, c) && c == Math.floor(c))
				{
					c = (int)c; 
					System.out.println(i * j * c);
				}
			}
		}
	}
	
	
	public static boolean sum(int a, int b, double c)
	{
		if (a + b + c  == 1000)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}