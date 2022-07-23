package program;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class fileHandling 
{
	static int a=1;
	
	//read the data
	public static void read()
	{
		try
		{
			File obj = new File("fileHandling.txt");
			Scanner sc = new Scanner(obj);
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error occured: ");
			e.printStackTrace();
		}
	}
	
	//append the data
	public static void append()
	{
			try
			{
				FileWriter obj = new FileWriter("fileHandling.txt",true);
				Scanner in = new Scanner(System.in);
				System.out.println("\nEnter new data to the file: ");
				obj.write(in.nextLine());
				in.close();
				obj.close();
				System.out.println("\nFile updated: commit "+a+"\n");
			}
			catch(IOException e)
			{
				System.out.println("error occured: ");
				e.getMessage();
			}
	}
	
    //main method
	public static void main(String[] args) 
	{
		try
		{
			FileWriter f1 = new FileWriter("fileHandling.txt");
			f1.write("1. Write the data \n2. Read the data \n");
			f1.close();
			System.out.println("File updated: commit "+a+"\n");
			a++;
		}
		catch(IOException e)
		{
			System.out.println("error occured..");
			e.getMessage();
		}
		
		read();
		append();
		read();
		
		System.out.println("\n Execution Completed..");
   
	}

}
