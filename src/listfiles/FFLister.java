package listfiles;

import java.io.File;

/**
 * Class provides static methods to list files and folders
 * in a current working directory.
 * 
 * @author Workstation
 *
 */
public class FFLister {
	static private final String CURRENT_DIRECTORY = ".";
	static private File folder;
	static private File[] files;

	// initialize variables
	static {
		folder = new File(CURRENT_DIRECTORY);
		files = folder.listFiles();
	}
	
	
	/**
	 * Prints all files in current working directory.
	 * 
	 * @throws NullPointerException if directory is empty
	 */
	public static void listFiles() throws NullPointerException {
		for (File f : files) {
			if (f.isFile())
				System.out.println("File: "+ f.getName());
		}
	}

	/**
	 * Prints all directories in current working directory.
	 * 
	 * @throws NullPointerException
	 */
	public static void listFolders() throws NullPointerException {
		for (File f : files) {
			if (f.isDirectory())
				System.out.println("Folder: "+ f.getName());
		}
	}

}
