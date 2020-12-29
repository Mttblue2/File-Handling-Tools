import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GetNames
{

	public static void main(String[] args) throws IOException
	{
		File source = new File("names.txt");
		source.createNewFile();
		FileWriter writer = new FileWriter(source);
		
		File dir = new File(System.getProperty("user.dir"));
		System.out.println(dir);
		
		File[] array = dir.listFiles();
		
		for (int x = 0; x < array.length; x++)
		{
			int y = array[x].toString().lastIndexOf("\\");
			writer.write(array[x].toString().substring(y+1));
			writer.write("\n");
		}
		
		writer.close();
	}

}
