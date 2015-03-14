package makedirectory;

import java.io.File;


/**
 * This application takes folder names as console arguments
 * and creates folders in a current working directory.
 * 
 * @author Vladimirs Ivanovs
 *
 */
public class MakeDirsApp{

	public static void main(String[] args) {
		MakeDirectory.makeDirectories(args);
	}
}

/**
 * Class contains static methods for creating folders and
 * checking folder names if they are valid.
 * 
 * @author Vladimirs Ivanovs
 *
 */
class MakeDirectory{
	 private static final String CURRENT_DIRECTORY = ".";
	 private static final String SEP = File.separator;

	/**
	 * Creates one folder with a given name.
	 * @param name
	 */
	private static void makeOneDirectory(String name) {
		if(isValid(name)){
			File folder = new File(CURRENT_DIRECTORY+SEP+name);
			boolean created = folder.mkdir();
			if (created) {
				System.out.println("Folder " + folder.getName() + " was creted");
			} else {
				System.out.println("Folder wasn't created");
			}
		}else{
			System.out.println(name +" is invalid folder name!");
		}
	}

	/**
	 * Creates multiple folders from the array of names.
	 * @param names
	 */
	public static void makeDirectories(String[] names) {
		for (String folderName : names) {
			makeOneDirectory(folderName);
		}
	}
	
	/**
	 * Checks folder names for correct naming.
	 * @param folderName
	 * @return
	 */
	public static boolean isValid(String folderName){
		char[] array = folderName.toCharArray();
		//checks if array is NOT empty and first/last characters are NOT whitespace
		if(array.length == 0 || array[0]==' ' || array[array.length-1]==' ')
			return false;
		//checks if names contain just letters, whitespace and digits
		for(char c : array){
			if (!Character.isLetter(c) && !Character.isDigit(c) && !(c==' '))
				return false;
		}
		return true;
	}
}


