import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filechecker
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		File dir = new File(System.getProperty("user.dir"));
		System.out.println(dir);
		
		System.out.println("Enter type");
		String type = kb.nextLine();
		
		listfiles(dir, type);
	}
	
	private static void listfiles(File file, String type) throws FileNotFoundException
	{
		File[] array = file.listFiles();
		
		for (int x = 0; x< array.length; x++)
		{
			if(array[x].isDirectory())
			{
				listfiles(array[x],type);
			}
			
			if (checkFile(type, array[x]))
			{
				Scanner reader = new Scanner(array[x]);
				
				while (reader.hasNextLine())
				{
					if (reader.nextLine().equals("<TITLE>404 Not Found</TITLE>"))
						System.out.println(array[x].toString());
				}
				
				reader.close();
			}
		}
	}
	
	private static boolean checkFile(String type, File file)
	{
		String name = file.toString();
		int x = name.lastIndexOf(".");
		
		if (x > 0)
		{
			if (type.equals(name.substring(x)))
			{
			
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}