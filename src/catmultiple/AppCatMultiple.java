package catmultiple;

import cat.MyFileReader;

/**
 * Application for reading multiple files.
 * @author Vladimirs Ivanovs
 *
 */
public class AppCatMultiple {
	
	/**
	 * Reads multiple files.
	 * @param fileNames
	 */
	public static void readMultiple(String[] fileNames){
		MyFileReader reader = new MyFileReader();
		for(String file: fileNames){
			reader.readRes(file);
			System.out.println("STATUS: COMPLETED READING FILE "+ file);
		}
	}
	
	public static void main(String[] args) {
		try{
			String[] args2 = {"test_read.txt","test_read2.txt","test_read4.txt","test_read3.txt"};
			readMultiple(args2);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No file entered. Please enter a valid file name.");
		}
	}
}
