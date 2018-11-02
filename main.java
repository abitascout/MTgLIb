import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
public class main {
	public static void main (String args[])
	{
		
		importFile();
		Card q = new Card("adj;klf","1B","pussy",1.24);
		TTtree<Card> library = new TTtree<Card>();
		System.out.println(q);
		exportFile();
	}
	public static void importFile()
	{
		File in = new File("Deck.txt");
		try
		{
			Scanner FileReader = new Scanner(in).useDelimiter("\t|\r\n");
			FileReader.nextLine();
			System.out.println(FileReader.next()+" name");//name
			System.out.println(FileReader.next()+" cmc");//cmc
			System.out.println(FileReader.next()+" type");//type
			System.out.println(FileReader.nextDouble()+" price");//price
			FileReader.nextLine();
			while(FileReader.hasNext())
			{
				System.out.println(FileReader.next());
				FileReader.nextLine();
				
			}
			FileReader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Data File Missing.\nShutting down..");
			System.exit(0);
		}
	}
	public static void exportFile()
	{
		// Create a PrintStream attached to a file named "output.txt"
		// This will overwrite  the file if its already extis
		PrintStream ps = new PrintStream("output.txt");
		// Buffer some data to write to the file (doesnt write till its flu
		ps.print("Some test data");
		
		// Flush all buffered data to the file
		ps.flush();
		
		ps.println("data");
		
		// Close the file (by closing the PrintStream)
		// also flushes any remainin buffered output
		ps.close();
		
		
	}

}
