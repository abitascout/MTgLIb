import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class main {
	public static void main (String args[])
	{
		
		importFile();
		Card q = new Card();
		q.setCmc("1B");
		q.setPrice(1.14);
		System.out.println(q);
	}
	public static void importFile()
	{
		File in = new File("Deck.txt");
		try
		{
			Scanner FileReader = new Scanner(in).useDelimiter("\t");
			FileReader.nextLine();
			System.out.println(FileReader.next());//name
			System.out.println(FileReader.next());//cmc
			System.out.println(FileReader.next());//type
			System.out.println(FileReader.next());//price
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

}
