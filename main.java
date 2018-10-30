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
		File in = new File("input.txt");
		try
		{
			Scanner FileReader = new Scanner(in);
			String x = FileReader.next();
			System.out.println(x);
			FileReader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Data File Missing.\nShutting down..");
			System.exit(0);
		}
	}

}
