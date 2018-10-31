import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class main {
	public static void main (String args[])
	{
		
		importFile();
		Card q = new Card("adj;klf","1B","pussy",1.24);
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
