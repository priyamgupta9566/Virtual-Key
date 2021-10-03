package FileHandling;

import java.util.*;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileFunctions 
{
	Scanner sc = new Scanner(System.in);
	FolderDirectory dir = new FolderDirectory();
	public void addFile()
	{
		System.out.println("Enter the name of the file you want to add : ");
		String name = sc.nextLine();
		
		try {
			File file = new File(dir.getName() + name);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
		
	}
	
	public void deleteFile()
	{
		System.out.println("Enter the name of the file you want to delete : ");
		String name = sc.nextLine();
		
		Path path = FileSystems.getDefault().getPath(FolderDirectory.name + name).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file:" + name + ", file was not found.");
	      }
    }
			
	public void searchFile()
	{
		System.out.println("Enter the name of the file you want to search : ");
		String name = sc.nextLine();
		
		boolean found = false;
		ArrayList<File> files = dir.getFiles();
        for(int i = 0; i < files.size(); i++) 
        {
			if(files.get(i).getName().equals(name)) 
			{
				System.out.println("Found " + name);
				found = true;
			}
        }
        if (found == false) 
        	System.out.println("File not found");
	}
	
	private static FolderDirectory fd = new FolderDirectory();
	public void showFiles()
	{
		fd.fillFiles();

        for (File file : FileFunctions.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static FolderDirectory getFileDirectory() {
        return fd;
    }

    public static void setFileDirectory(FolderDirectory fd) {
        FileFunctions.fd = fd;
	}

}
