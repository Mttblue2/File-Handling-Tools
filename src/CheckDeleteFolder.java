import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckDeleteFolder
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Would you like to list files or delete folders? (List/Delete)");
		String input = keyboard.nextLine();
		input = input.toLowerCase();

		while (!(input.equals("list") || input.equals("delete")))
		{
			System.out.println("Please enter valid responce");
			input = keyboard.nextLine();
			input = input.toLowerCase();
		}

		if (input.equals("list"))
			listfiles();

		if (input.equals("delete"))
			deletefolder();

		keyboard.close();
	}

	private static void listfiles() throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please input file location");
		String input = keyboard.nextLine();

		File source = new File(input);

		Scanner file = new Scanner(source);

		while (file.hasNextLine())
		{
			File dir = new File(file.nextLine());
			listfiles(dir);
		}

		file.close();
		keyboard.close();
	}

	private static void listfiles(File file) throws FileNotFoundException
	{
		File[] array = file.listFiles();

		for (int x = 0; x < array.length; x++)
		{
			if (array[x].isDirectory())
			{
				listfiles(array[x]);
			}
			if (array[x].isFile())
			{
				int y = array[x].toString().lastIndexOf("\\");
				System.out.println(array[x].toString().substring(y));
			}
		}
	}

	private static void deletefolder() throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please input file location");
		String input = keyboard.nextLine();

		File source = new File(input);
		File delete;

		Scanner file = new Scanner(source);
		
		while(file.hasNextLine())
		{
			delete = new File (file.nextLine());
			deletecontents(delete);
			delete.delete();
		}
		
		file.close();
		keyboard.close();
	}
	
	private static void deletecontents(File file) throws FileNotFoundException
	{
		File[] array = file.listFiles();

		for (int x = 0; x < array.length; x++)
		{
			if (array[x].isDirectory())
			{
				deletecontents(array[x]);
				array[x].delete();
			}
			if (array[x].isFile())
			{
				array[x].delete();
			}
		}
	}

}
