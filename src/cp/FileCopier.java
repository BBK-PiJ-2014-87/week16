package cp;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class FileCopier {
	
	/**
	 * Decides which copy method to use based on the input.
	 * @param names at least first one is a file name and the last one is a directory name
	 */
	public void chooseCopyMethod(String[] names){
		File check = new File(names[names.length-1]);
		if(names.length ==2){
			System.out.println("TWO FILES METHOD");
			copyOne(names[0], names[1]);
		}else if (names.length>2 && check.isDirectory()){
			System.out.println("MULTIPLE FILES METHOD");
			copyMultiple(names);
		}else{
			System.out.println("ERROR: Invalid entry.");
		}
	}
	
	/**
	 * Copies multiple files to a given directory.
	 * @param names
	 */
	private void copyMultiple(String names[]){
		for(int i =0; i< names.length-1; i++){
			copyOne(names[i], names[names.length-1]+File.separator+names[i]);
		}
	}

	/**
	 * Copies file to specified file.
	 * 
	 * @param from source file name/path as String
	 * @param to target file name/path as String
	 */
	public void copyOne(String from, String to) {
		File source = new File(from);
		if (sourceExists(source)) {
			File target = new File(to);
			try{
				if(!targetExists(target)){
					Files.copy(source.toPath(), target.toPath());
					System.out.println("File " + target.getName()
							+ " COPIED!");
				} else if (target.exists() && confirmReplace()) {
					Files.copy(source.toPath(), target.toPath(),
							REPLACE_EXISTING);
					System.out.println("File " + target.getName() + " REPLACED!");
				}else{
					System.out.println("File WASN'T copied!");
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
			

	/**
	 * Checks if source file exists.
	 * 
	 * @param fileToCheck
	 * @return true if source exists. False otherwise.
	 */
	private boolean sourceExists(File fileToCheck) {
		if (fileToCheck.exists()) {
			System.out.println("Source file "+fileToCheck.getName()+ " exists.");
			return true;
		} else {
			System.out.println("Source file "+fileToCheck.getName()+ " DOESN'T exist.");
			return false;
		}
	}

	/**
	 * Checks if target file already exists and lets user know about it.
	 * 
	 * @param fileToCheck
	 * @return true if file exists, and false otherwise.
	 */
	private boolean targetExists(File fileToCheck) {
		if (!fileToCheck.exists()) {
			System.out.println("Target file "+fileToCheck.getName()+  " DOESN'T exist.");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if user input is correct.
	 * 
	 * @param answer
	 * @return true if input is a valid string, and false otherwise.
	 */
	private boolean isValidEntry(String answer) {
		Answer[] ans = Answer.values();
		for (Answer a : ans) {
			if (answer == a.toString())
				return true;
		}
		return false;
	}

	/**
	 * Confirms if user wants to overwrite existing file.
	 * 
	 * @return true if input starts with character 'y'. Returns false otherwise.
	 * 
	 */
	private boolean confirmReplace() {
		String answer = "";
		int attempts = 3;
		// takes user input
		// if string is invalid it loops 3 times before exiting with the false
		// return
		do {
			System.out.println("Files already exists.Do you want to replace it? y/n");
			Scanner in = new Scanner(System.in);
			answer = in.nextLine();
			attempts--;
		} while (isValidEntry(answer) && attempts > 0);
		
		if (answer.charAt(0) == 'y')
			return true;
		else
			return false;
	}
}
