import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * This deletes files in a directory named in a "names.txt" file in the directory
 */

public class DeleteFilesNames
{

	public static void main(String[] args) throws FileNotFoundException
	{
		File source = new File("names.txt");

		Scanner names = new Scanner(source);
		
		while (names.hasNext())
		{
			try
			{
				File file = new File (names.nextLine());
				
				
				System.out.println(file.getName());
				if (!file.getName().equals("names.txt"))
					file.delete();
			}
			
			catch(Exception e)
			{
			}
			
			
		}
		
		names.close();

	}

}
