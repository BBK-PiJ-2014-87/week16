package tr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tr {
	private File source; 			
	private File target;
	private String oldText; 	//text to be replaced
	private String newText; 	//replacement text
	public String fileContent;	//all content of the file
	
	public Tr(String source, String target, String oldText, String newText){
		this.source = new File(source);
		this.target = new File(target);
		this.oldText = oldText;
		this.newText = newText;
	}
	
	public Tr(String source, String oldText, String newText){
		this.source = new File(source);
		target = this.source;
		this.oldText = oldText;
		this.newText = newText;
	}
	
	public void run(){
		readContent();
		replaceText();
		writeContent();
	}
	
	private void replaceText(){
		fileContent = fileContent.replaceAll(oldText, newText);
	}
	
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
