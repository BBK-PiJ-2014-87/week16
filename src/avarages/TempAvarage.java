package avarages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Application reads CSV file with numerical data and outputs
 * average number by line and average of whole file.
 * @author Vladimirs Ivanovs
 *
 */
public class TempAvarage {
	public static void main(String[] args) {
		String file = "Untitled.csv";
		double lineAvrg = 0.0;			//average value of a line
		double fileAvrg = 0.0;			//average value of a file
		int lineCount = 0;				//number of lines in a file
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String str;
			String[] array;
			while((str = reader.readLine()) != null){
				lineCount++;
				array = str.split(",");	//splits string into tokens and puts in the array
				lineAvrg = 0;
				for(String s:array){
					lineAvrg = lineAvrg + Double.parseDouble(s.trim());
				}
				lineAvrg = lineAvrg/array.length;
				System.out.println(lineCount+". Average: "+lineAvrg);
				fileAvrg = fileAvrg + lineAvrg;
			}
			fileAvrg = fileAvrg/lineCount;
			System.out.println("File avarage is: "+ fileAvrg);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
