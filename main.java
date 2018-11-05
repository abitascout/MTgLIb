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
		System.out.println(nameList);
		Card q = new Card("adj;klf","1B","pussy",1.24,true);
		System.out.println(q);
		
	}
	public static void importFile()
	{
		File in = new File("Deck.txt");
		try
		{
			@SuppressWarnings("resource")
			Scanner FileReader = new Scanner(in).useDelimiter("\t|\r\n");
			FileReader.nextLine();
			while(FileReader.hasNext())
			{
<<<<<<< HEAD
				String contents = FileReader.next();
				System.out.println(FileReader.next());
				FileReader.nextLine();
				
=======
				String name = FileReader.next();
				String cmc = FileReader.next();
				String type = FileReader.next();
				Double price = FileReader.nextDouble();
				Card nameCard = new Card(name, cmc, type, price, true);
				nameList.InsertAfter(nameCard);
				Card typeCard = new Card(name, cmc, type, price, false);
				typeList.InsertAfter(typeCard);
>>>>>>> 207ab0e7af375ac9cb4b064dfaba320cf5678ab9
			}
			exportFile(contents);
			FileReader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Data File Missing.\nShutting down..");
			System.exit(0);
		}
	}
<<<<<<< HEAD
	public static void exportFile( String contents)
=======
	public static String printNameList()
	{
		nameList.First();
		while(true)
		{
			
		}
	}
	public static void exportFile()
>>>>>>> 207ab0e7af375ac9cb4b064dfaba320cf5678ab9
	{
		try{// Create a PrintStream attached to a file named "output.txt"
		// This will overwrite  the file if its already extis
		File file = new File("output.txt");
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter bufferwriter = new BufferedWriter(filewriter);
		
		try(Writer writer = bufferwriter)
		{
			
			
			writer.write(contents);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
