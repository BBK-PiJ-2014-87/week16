package cp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileCopier {

	/**
	 * Copies file to specified file.
	 * 
	 * @param from source file name/path as String
	 * @param to target file name/path as String
	 */
	public void copyFiles(String from, String to) {
		File source = new File(from);
		if (sourceExists(source)) {
			File target = new File(to);
			try {
				if (targetExists(target) && confirmReplace()) {
					Files.copy(source.toPath(), target.toPath(),
							REPLACE_EXISTING);
					System.out.println("File " + target.getName()
							+ " replaced.");
				} else {
					Files.copy(source.toPath(), target.toPath());
					System.out.println("File " + target.getName() + " copied");
				}
			} catch (IOException e) {
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
			return true;
		} else {
			System.out
					.println("File to copy doesn't exist. Please enter another name.");
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
		if (fileToCheck.exists()) {
			return true;
		} else {
			System.out.println("File to copy doesn't exist.");
			return false;
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
			System.out
					.println("Files with such name exists.Do you want to overwrite it? y/n");
			answer = System.console().readLine();
			attempts--;
		} while (isValidEntry(answer) && attempts >= 3);
		if (answer.charAt(0) == 'y')
			return true;
		else
			return false;
	}
}
