/*
Problem: Summation of Primes

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

*/


import java.lang.Math;
import java.lang.Long;
import java.io.*;
import java.util.*;

public class Problem10 
{
	public static void main(String[] args) 
	{
		long sum = 0;
		for(int i = 2; i < 2000000; i++)
		{
			if(isPrime(i))
			{
				sum += i; 
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isPrime(int num)
	{
		for(int i = 2; i < (int)Math.sqrt(num) + 1; i++)
		{
			if ( num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
