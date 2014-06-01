/*
Problem: Special Pythagorean Triplet

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

*/
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
