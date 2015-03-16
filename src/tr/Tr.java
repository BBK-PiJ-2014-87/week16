package tr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application for changing each occurrence of a string with 
 * another defined string.
 * 
 * @author Vladimirs Ivanovs
 *
 */
public class Tr {
	private File source; 			
	private File target;
	private String oldText; 	//text to be replaced
	private String newText; 	//replacement text
	public String fileContent;	//all content of the file
	
	/**
	 * This constructor is used to save changes to new file.
	 * @param source
	 * @param target
	 * @param oldText
	 * @param newText
	 */
	public Tr(String source, String target, String oldText, String newText){
		this.source = new File(source);
		this.target = new File(target);
		this.oldText = oldText;
		this.newText = newText;
	}
	
	/**
	 * This constructor is used if we want to save changes in current file.
	 * @param source 
	 * @param oldText
	 * @param newText
	 */
	public Tr(String source, String oldText, String newText){
		this.source = new File(source);
		target = this.source;
		this.oldText = oldText;
		this.newText = newText;
	}
	
	/**
	 * Reads the file, makes changes to the text and writes them to the file.
	 */
	public void run(){
		readContent();
		replaceText();
		writeContent();
	}
	
	/**
	 * Replaces old string with new ones.
	 */
	private void replaceText(){
		fileContent = fileContent.replaceAll(oldText, newText);
	}
	
	/**
	 * Reads content of a file and saves it as one string.
	 */
	private void readContent(){
		StringBuilder content = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader(source))){
			String str;
			//reads and adds each line to StringBuilder
			while((str = reader.readLine()) != null){
				content.append(str);
				content.append("\n");
			}
			fileContent = content.toString();
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist.");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * Writes content to given file.
	 */
	private void writeContent(){
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(target))){
			writer.write(fileContent);
			writer.flush();
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
