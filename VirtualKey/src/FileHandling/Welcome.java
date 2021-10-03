package FileHandling;

import java.util.*;
public class Welcome 
{
	public static void welcome1()
	{
		System.out.println("Welcome to Virtual Key Repository Project.	");
		System.out.println("Developed by : Priyam Gupta");
	}
	public static void menu1()
	{
		System.out.println("1. Show Files in ascending order.");
		System.out.println("2. Show File Menu.");
		System.out.println("3. Exit.");
	}
	public static void menu2()
	{
		System.out.println("1. Add a File.");
		System.out.println("2. Delete a File.");
		System.out.println("3. Search a File.");
		System.out.println("4. Return to Main Menu.");
		System.out.println("5. Exit");
	}
	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileFunctions func = new FileFunctions();
		welcome1();
		System.out.println("");
		boolean flag = true;
		while(flag)
		{
			menu1();
			try
			{
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				func.showFiles();
				System.out.println("Files are : ");
				break;
			case 2:
				menu2();
				System.out.println("Enter your input : ");
				int input = sc.nextInt();
				switch(input)
				{
				case 1:
					func.addFile();
					continue;
				case 2:
					func.deleteFile();
					continue;
				case 3:
					func.searchFile();
					continue;
				case 4:
					continue;
				case 5:
					System.out.println("Exit successful. Thank you for using the File Handling program.");
					System.exit(1);		
				default:
					System.out.println("Invalid Option. Please select a valid option.");
					continue;
				}
			case 3:
				System.out.println("Exit successful. Thank you for using the File Handling program.");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice. Please enter a valid choice.");
			}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter a correct choice..");
				break;
			}
		}
		sc.close();
		

	}

}

