/*

This code uses try/catch to ensure that the user enters the correct type of data to play the game

CS 007 Fall 2013 Roberts  Program12A
Name: John Golden
Email:  jwg28@pitt.edu
Recitation: Thurs, 10AM
Java Versions: 1.6.0_51
Students with whom I worked: None

*/

import java.util.*;
import java.io.*;

public class Program12B
{
	static public void main( String [] args) throws Exception
	{
		String[] roomData = new String[10];
		String[] roomChoices = new String[10];
		Random generator = new Random();
		File dataFile = new File( args [ 0 ] );	
		Scanner inputFile = new Scanner( dataFile );
		while(inputFile.hasNext())
		{
		   // read one line
		   for(int i = 1; i<roomData.length; i++)
		   {
		   		roomData[i] = inputFile.nextLine();
		   		roomChoices[i] = inputFile.nextLine();
		   }
		   
		}
		Scanner kbd = new Scanner (System.in);
		
		System.out.println();
		System.out.println();
		System.out.println("---------Welcome to the Tower of Rocks, Paper, and Scissors----------");
		System.out.println();
		System.out.println();
		System.out.println("First you must defeat an opponent in a classic game of Rock, Paper, Scissors");
		System.out.println();
		System.out.println("Then you may choose which room you will enter next, which will determine who is your next opponent.");
		System.out.println();
		System.out.println("You have the advantage of being able to use any of the three moves, while each opponent has only mastered one move!");
		System.out.println();
		System.out.println("Pay attention to your opponent's name and reputation for a hint to which move they will use.");
		System.out.println();
		System.out.println("You may lose up to 5 times before you lose and are banished from the tower, so choose wisely!");
		System.out.println();
		System.out.println("Press return whenever you are ready to enter the first room and meet your first opponent.");
		
		kbd.nextLine();
	
		
		int room = 1;
		int loses = 0;
		
		while(room<10)
		{
			String [] roomInfo = roomData[room].split(":");
			String [] nextRoom = roomChoices[room].split(":");
			System.out.println();
			System.out.println("-----------------------------Room " + room + "----------------------------------");
			System.out.println();
			if(room < 4)
			{
				System.out.println("You enter room number " + room + " and face your opponent, " + roomInfo[0] + ".");
			}
			else if (room < 7)
			{
 				System.out.println("You enter room number " + room + " and face your opponents, " + roomInfo[0] + ".");	
 				System.out.println("They are teaming up so now they have two possible moves!");			
			}
			else
			{
				System.out.println("You enter room number " + room + " and face your opponents, " + roomInfo[0] + ".");
				System.out.println("They are all teaming up so now they can use any of the three possible moves!");
			}
				
			boolean win = false;
			while(win == false)
			{
				String opponent = "";
				if (roomInfo.length == 2)
				{
					opponent = roomInfo[1];
				}
				else if (roomInfo.length == 3)
				{
					
					int randomanswer = generator.nextInt(2);
					if(randomanswer == 0)
					{
						opponent = roomInfo[1];
					}
					else
					{
						opponent = roomInfo[2];
					}
				}
				else
				{
					int randomanswer = generator.nextInt(3);
					if(randomanswer == 0)
					{
						opponent = roomInfo[1];
					}
					else if (randomanswer == 1)
					{
						opponent = roomInfo[2];
					}
					else
					{
						opponent = roomInfo[3];
					}
				}
				
				System.out.println();
				boolean possibleMove = false;
				String player = "";
				while(!possibleMove)
				{
					System.out.print("What do you play? [rock], [paper], or [scissors]: ");
					String choice = kbd.next();
					if(choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"))
					{
						player = choice;
						possibleMove = true;
					}
					else
					{
						System.out.println("Read carefully! The move you chose was not one of the options.");
						System.out.println();
					}
				}
				System.out.println();
				
				
				if (player.equals(opponent))
				{
					System.out.println("You both used " + player + "!");
					System.out.println("Since there is no winner, you must play again!");
					System.out.println();
				
				}
				else if ((opponent.equals("rock") && player.equals("scissors")) || (opponent.equals("scissors") && player.equals("paper")) || (opponent.equals("paper") && player.equals("rock")))
				{
					System.out.println("We're sorry but you lose.");
					System.out.println("You played " + player + " but your opponent used " + opponent + ", and " + opponent + " beats " + player + ".");
					System.out.println();
					System.out.println("You must play until you defeat your opponent");
					System.out.println();
					loses++;
					if(loses == 5)
					{
						System.out.println();
						System.out.println("-----------------------------YOU LOSE----------------------------------");
						System.out.println();
						System.out.println("Sorry! You've lost 5 times and you are now banished from the Tower of Rocks, Paper, and Scissors.  Never come back!");
						System.out.println();
						System.out.println();
						System.exit(0);
					}
				}
				else 
				{
					System.out.println("Congratulations, you defeated your opponent!");
					System.out.println("You played " + player + " and your opponent used " + opponent + ", and " + player + " beats " + opponent + ".");
					System.out.println();
					
					while(!win)
					{
						
						try
						{
							System.out.print("Your choices are Rooms " + ArraytoString(nextRoom) + ", which do you choose? ");
							int choice = kbd.nextInt();
							
							if(ArrayhasNumber(nextRoom, choice))
							{
								room = choice;
								win = true;
							}
							else
							{
								System.out.println();
								System.out.println("Read carefully! The room you chose was not one of the options.");
							}
						}
						catch(Exception e)
						{
							System.out.println();
							System.out.println("Read carefully! The room you chose was not one of the options.");
						}
						kbd.nextLine( );
					}
				}
				
			}
		}
		System.out.println();
		System.out.println("-----------------------------YOU WIN----------------------------------");
		System.out.println();
		System.out.println("You have been crowned the new champion of the Tower of Rock, Paper, and Scissors!");
		System.out.println();		
		System.out.println("Congratulations!");
		System.out.println();
		System.out.println("Now you will live in the tenth room and be the final challenger for anyone who enters the tower.");
		System.out.println();
		System.out.println();
	}
	static public String ArraytoString(String [] anyArray)
	{
		String s = "";
		if (anyArray.length == 1)
		{
			s = anyArray[0];
		}
		else if (anyArray.length == 2)
		{
			s = anyArray[0] + " or " + anyArray[1];
		}
		else
		{
			for(int i = 0; i < anyArray.length - 1; i++)
			{
				s += anyArray[i] + ", ";
			}
			s += "or " + anyArray[anyArray.length - 1];
		}
		return s;
	}
	static public boolean ArrayhasNumber(String[] anyArray, int number)
	{
		boolean trueorfalse;
		for(int i = 0; i < anyArray.length; i++)
		{
			if (Integer.parseInt(anyArray[i]) == number)
			{
				return true;
			}
		}
		return false;
	}
} 