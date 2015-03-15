package tr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tr {
	
	public boolean fileExists(String fileName){
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();
		if(file.exists()&& file.isFile()){
			return false;
		}else{
			System.out.println("File doesn't exist.");
			return true;
		}
	}
	
	public void readFile(String fileName, String fileName2){
		File file = new File(fileName);
		File file2 = new File(fileName2);
		BufferedReader bufReader=null;
		BufferedWriter bufWriter = null;
		try {
			bufReader = new BufferedReader(new FileReader(file));
			bufWriter = new BufferedWriter(new FileWriter(file2));
			String str;
			while((str = bufReader.readLine()) != null){
				bufWriter.write(str.toUpperCase());
				bufWriter.newLine();
				bufWriter.flush();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try {
				bufReader.close();
				bufWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}	 
	
	public void readFile(String fileName){
		StringBuilder content = new StringBuilder();
		File file = new File(fileName);
		BufferedReader bufReader=null;
		BufferedWriter bufWriter = null;
		
		try {
			bufReader = new BufferedReader(new FileReader(file));
			String str;
			while((str = bufReader.readLine()) != null){
				content.append(str.toLowerCase());
				content.append("\n");
			}
			
			bufWriter = new BufferedWriter(new FileWriter(file));
			bufWriter.write(content.toString());
			bufWriter.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try {
				bufReader.close();
				bufWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
	}	
	

}
