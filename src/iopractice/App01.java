package iopractice;

import java.io.File;

/**
 * Initial testing of input/output classes and methods.
 * To be updated.
 * @author Vladimirs Ivanovs
 *
 */
public class App01 {
	public static void main(String[] args) {
		String filepath = "." + File.separator + "src" + File.separator
				+ "filejava" + File.separator;
		String filename = "myfile.txt";
		String fullFileName = filepath + filename;

		File file = new File(fullFileName);
		File dir = new File(filepath);

		System.out.println(file.exists()); // check if file exists
		System.out.println(dir.listFiles()[1]); // return 0 element of the array
												// of files in directory

		// Prints all files within given directory

		File[] fileNames = dir.listFiles();
		for (File e : fileNames) {
			System.out.println(e);
		}

		// ////////////check current directory
		String curDirPath = "." + File.separator; // similar to ./ -- current
													// directory
		File curDir = new File(curDirPath);
		System.out.println(curDir.listFiles()[0]);
		System.out.println(System.getProperty("user.dir")); // current directory

	}

}
