package cat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Reads the file and prints its content to the console.
 * @author Workstation
 *
 */
public class MyFileReader {
	public void read(String fileName){
		File file = new File(fileName);
		BufferedReader bufReader = null;
		try {
			FileReader fileReader = new FileReader(file);
			bufReader = new BufferedReader(fileReader);
			String line;
			while((line = bufReader.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File "+ fileName+ " not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			closeReader(bufReader);
		}
	}
	
	/**
	 * Closes the reader.
	 * @param reader
	 */
	private void closeReader(Reader reader){
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			//if reader won't be created at all
			System.out.println("File was not opened. Nothing to read.");
		}
	}

}
