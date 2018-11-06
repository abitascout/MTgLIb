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
import java.io.Writer;
public class main {
	//using linked lists to store cards due to 
	public static List<Card> nameList = new List<Card>();
	public static List<Card> typeList = new List<Card>();
	public static void main (String args[])
	{
		/*
		List<Card> test = new List<Card>();
		Card benis = new Card("Q","A","Creature",1.10,true);
		test.InsertAfter(benis);
		benis = new Card("A","Q","Creature",1.10,true);
		test.InsertAfter(benis);
		System.out.println(test);
		test.insertSort();
		System.out.println(test);*/
		importFile();
		//System.out.println(nameList+"\n"+nameList.GetSize());
		nameList.insertSort();
		//System.out.println(nameList+"\n"+nameList.GetSize());
		printList(nameList);
		exportFile(printList(nameList));
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
				Card nameCard = new Card(name, cmc, type, price, true);
				nameList.InsertAfter(nameCard);
				Card typeCard = new Card(name, cmc, type, price, false);
				typeList.InsertAfter(typeCard);
			}
			FileReader.close();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Data File Missing.\nShutting down..");
			System.exit(0);
		}
	}

	//A stack will be used to print out the list, this is due to the nature of a stack already being in list format.
	//it will also ensure that we have no chance of printing out cards that are not available
	public static String printList(List<Card> printer)
	{
		printer.Last();
		Stack<Card> forwardStack = new Stack<Card>();
		for (int scroller = 0; scroller < printer.GetSize(); scroller++)
		{
			if(printer.GetValue().getStock())
			{
				forwardStack.Push(printer.GetValue());
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
			File file = new File("output.txt");
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

}
