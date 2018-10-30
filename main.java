import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class main {
	public static void main (String args[])
	{
		File in = new File("input.txt");
		try
		{
			Scanner FileReader = new Scanner(in);
			String x = FileReader.next();
			System.out.println(x);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Data File Missing.\nShutting down..");
			System.exit(0);
		}
		
		Card x = new Card();
		x.setCmc("1B");
		x.setPrice(1.14);
		System.out.println(x);
	}

}
