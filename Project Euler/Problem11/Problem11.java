import java.lang.Math;
import java.lang.Long;
import java.io.*;
import java.util.*;

public class Problem11 
{
	public static void main(String[] args) throws Exception
	{
		int[][] arr = readFile(args[0]);
		int[][] majorDiag = majorDiag(arr);
		int[][] minorDiag = minorDiag(arr);
		
		int length = 4;
		int prod1 = 1;
		int prod2 = 1;
		
		int maxprod = 0;
		
				
		//rows and columns
		for(int row = 0; row < arr.length; row++)
		{
			for (int i = length - 1; i < arr[row].length; i++)
			{
				prod1 = 1; 
				prod2 = 1; 
				for(int j = 0; j < length; j++)
				{
					prod1 *= arr[row][i - j];
					prod2 *= arr[i - j][row];
					
				}
				if (prod1 > maxprod)
				{
					maxprod = prod1;
					
				}
				else if (prod2 > maxprod)
				{
					maxprod = prod2;
					 
				}
			}
		}
		
		// major diagonals
		for(int row = 0; row < majorDiag.length; row++)
		{
			for (int i = length - 1; i < majorDiag[row].length; i++)
			{
				prod1 = 1; 
				prod2 = 1; 
				for(int j = 0; j < length; j++)
				{
					prod1 *= majorDiag[row][i - j];
				}
				if (prod1 > maxprod)
				{
					maxprod = prod1;
				}
			}
		}
		
		//minor diagonals
		for(int row = 0; row < minorDiag.length; row++)
		{
			for (int i = length - 1; i < minorDiag[row].length; i++)
			{
				prod1 = 1; 
				prod2 = 1; 
				for(int j = 0; j < length; j++)
				{
					prod1 *= minorDiag[row][i - j];
				}
				if (prod1 > maxprod)
				{
					maxprod = prod1;
				}
			}
		}
		
		System.out.println(maxprod);
		//print(majorDiag);
		print(minorDiag);
	}
	
	public static void print(int[][] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] readFile(String fileName) throws Exception
	{
		Scanner infile  = new Scanner ( new File(fileName) );       
		int rowNum = 0;
		
		int[][] arr = new int[20][20];
		String[] temp = new String[20];
		while( infile.hasNext() ) 
		{
			for(int i = 0; i < 20; i++)
			{
				arr[rowNum][i] = infile.nextInt();
			}
			rowNum++; 
		}
		//print(arr);
		return arr;
	}
	public static int[][] majorDiag(int[][] arr)
	{
		int numRows = arr.length;
		int numCols = arr[1].length;
		int[][] majorDiag = new int[numRows + numCols - 1][numRows];
		
		for( int row = 0; row < numRows; row++)
		{	
			for( int col = 0; col < numCols; col++)
			{	
				//checking major diagonals
				if(row == col)
 				{
 					majorDiag[19][col] = arr[row][col];
 				}
				for(int i = 1; i < numRows; i++)
				{
					if((row - col) == i)
					{
						majorDiag[numRows - 1 + i][col] = arr[row][col];
						majorDiag[numRows - 1 - i][col] = arr[col][row];
					}
				}
			}
		}
		return majorDiag;
	}
	
	public static int[][] minorDiag(int[][] arr)
	{
		int numRows = arr.length;
		int numCols = arr[1].length;
		int[][] minorDiag = new int[numRows + numCols - 1][numRows];
		
		
		for( int row = 0; row < numRows; row++)
		{	
			for( int col = 0; col < numCols; col++)
			{	
				for(int i = 0; i < (numRows + numCols) - 1; i++)
				{
					if(row + col == i)
					{
						minorDiag[i][col] = arr[row][col];
					}
				}
			}
		}
		return minorDiag;	
	}
	
}