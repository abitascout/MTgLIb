/*
Authors: Matthew Gerber and Robert Morton
Version: a.07
Date: 11/5/2018
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class main {
	//using linked lists to store cards due to 
	public static List<Card> nameList = new List<Card>();
	public static List<Card> typeList = new List<Card>();
	public static Queue<Card> nameTemp = new Queue<Card>();
	public static Queue<Card> typeTemp = new Queue<Card>();
	public static void main (String args[])
	{
		//import data from file Deck.txt
		importFile();
		// Main Menu
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println(" (1) Display List\n (2) Add Card\n (3) Sell Card\n (4) Search for a Card\n (5) Incase of fire\n (6) Quit\n");
			String choice = input.next();
			switch(choice)
			{
				case "1":
					System.out.println("Name\tType\tCMC\tPrice\tInStock\n__________________________________________________");
					System.out.println(displayList());
					break;
				case "2":
					addCard();
					break;
				case "3":
					//System.out.println(searchCard(input.next(), true)); //return only do not edit list
					removeCard();
					break;
				case "4":
					searchCard(true);
					break;
				case "5":
					fireDrill();
					break;
				case "6":
					exportFile(printList(nameList,true));
					System.exit(0);
					break;
				default:
					System.out.println("That is not a command");
					break;
						
			}
		}
		//exportFile(printList(nameList));
	}
	public static void importFile()
	{
		File in = new File("Deck.txt");
		try
		{
			Scanner FileReader = new Scanner(in).useDelimiter("\t|\r\n");
			FileReader.nextLine();
			while(FileReader.hasNext())
			{
				String name = FileReader.next();
				String cmc = FileReader.next();
				String type = FileReader.next();
				Double price = FileReader.nextDouble();
				Boolean available = FileReader.nextBoolean();
				Card nameCard = new Card(name, cmc, type, price, true, available);
				nameList.InsertAfter(nameCard);
				Card typeCard = new Card(name, cmc, type, price, false, available);
				typeList.InsertAfter(typeCard);
			}
			FileReader.close();
			nameList.insertSort();
			typeList.insertSort();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Data File Missing.\nShutting down..");
			System.exit(0);
		}
	}
	//A stack will be used to print out the list, this is due to the nature of a stack already being in list format.
	//it will also ensure that we have no chance of printing out cards that are not available
	public static String printList(List<Card> printer, boolean showAll)
	{
		printer.Last();
		Stack<String> forwardStack = new Stack<String>();
		for (int scroller = 0; scroller < printer.GetSize(); scroller++)
		{
			if(!showAll && printer.GetValue().getStock())
			{
				forwardStack.Push(printer.GetValue().printCard());
			}
			else
			{
				forwardStack.Push(printer.GetValue().printCard());
			}
			printer.Prev();
		}
		return forwardStack+"";
	}
	//output text to file
	public static void exportFile( String contents)
	{
		try
		{// Create a PrintStream attached to a file named "output.txt"
		// This will overwrite  the file if its already exists
			Scanner breakdown = new Scanner(contents);
			File file = new File("Deck.txt");
			FileWriter filewriter = new FileWriter(file);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			while(breakdown.hasNextLine())
			{
				bufferwriter.write(breakdown.nextLine());
				bufferwriter.newLine();
			}
			breakdown.close();
			bufferwriter.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static int binarySearch(List<Card> inList, String search)
	{
		inList.First();
		int l = 0, r = inList.GetSize() - 1;
		while(l <= r)
		{
			int m = (l + (r-1))/2;
			inList.SetPos(m);
			if(inList.GetValue().getName().compareTo(search) == 0)
			{
				return inList.GetPos();
			}
			if(inList.GetValue().getName().compareTo(search) < 0)
			{
				l = m + 1;	
			}
			else
			{
				r = m - 1;
			}
		}
		return -1;
	}
	public static String displayList()
	{
		return printList(nameList,false);
	}
	//a Queue will be used to hold all cards that are to be added to lists, this way user input is fast and the computer
	//will deal with adding new cards after the user has finished adding new cards
	public static void addCard()
	{
		boolean count = true;
		while (count)
		{
			
			Scanner reader = new Scanner(System.in);
			System.out.println("What is the name of the card?");
			String Title = reader.nextLine();
			System.out.println("What is the Converted Mana Cost of the card?\n U is blue B is black G is green R is red W is white.");
			String mana = reader.nextLine();
			System.out.println("What is the type of the card? Make sure to meantion if it is legendary.");
			String thing = reader.nextLine();
			System.out.println("What is the price of the card?");
			Double money = reader.nextDouble();
			Card add = new Card(Title, mana, thing, money, true, true);
			nameTemp.Enqueue(add);
			Card k = new Card(Title, mana, thing, money, false, true);
			typeTemp.Enqueue(k);
			System.out.println("Do you wish to continue? y/n");
			String answer = reader.nextLine();
			if (answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("y"))
			{
				;
			}
			else if (answer.toLowerCase().equals("no") || answer.toLowerCase().equals("n"))
			{ 
				count = false;
<<<<<<< HEAD
				nameList.Last(); 
				typeList.Last();
=======
				
>>>>>>> ae9746e0eb8ab57595d24a390b3778c3da4c2db3
				for ( int adder = 0; adder < nameTemp.GetSize(); adder++)
				{
						nameList.InsertAfter(nameTemp.First().GetValue());
						nameTemp.Dequeue();
						typeList.InsertAfter(typeTemp.First().GetValue());
						typeTemp.Dequeue();
						
				}
				
			}	
		}
	}
	public static void removeCard()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("What is the name of the card that you want to sell?");
		String cname = read.nextLine();
		nameList.SetPos(binarySearch(nameList, cname));
		nameList.GetValue().setStock(false);

	}
	public static String searchCard(Boolean onlyFinding)
	{
		Queue<Card> newTypeTemp = new Queue<Card>();
		Scanner say = new Scanner(System.in);
		System.out.println("Do you want to search by name or type?");
		String input = say.nextLine();
		if (input.toLowerCase().equals("name"))
		{
			System.out.println("What is the name of the card?");
			String na = say.nextLine();
			binarySearch(nameList, na);
			 return System.out.println(nameList.GetValue());
		}
		else if (input.toLowerCase().equals("type"))
		{
			System.out.println("What is the type of the card?");
			String ty = say.nextLine();
			nameList.First();
			for (int i = 0; i < MAX_SIZE; i++)
			{
				if (nameList.getType().toLowerCase().equals("Creature") || nameList.getType().toLowerCase().equals("Legendary_Creature"))
				{
					newTypeTemp.Enqueue(nameList.GetData());
					nameList.Next();
				}
				else
				{
					;
				}
				
			}
			return printList(newTypeTemp,false);
		}
		else
		{
				return "error. name or type was spelled incorrect or card not found.";
		}
			return  "all done";
	}
	public static String fireDrill()
	{
		return null;
	}
	
}
