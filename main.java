import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class main {
	public static void main (String args[])
	{
		
		importFile();
		Card q = new Card("adj;klf","1B","pussy",1.24);
		TTtree<Card> library = new TTtree<Card>();
		System.out.println(q);
		
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
				String contents = FileReader.next();
				System.out.println(FileReader.next());
				FileReader.nextLine();
				
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
	public static void exportFile( String contents)
	{
		try{// Create a PrintStream attached to a file named "output.txt"
		// This will overwrite  the file if its already extis
		File file = new File("output.txt");
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter bufferwriter = new BufferedWriter(filewriter);
		
		try(Writer writer = bufferwriter)
		{
			
			
			writer.write(contents);
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
