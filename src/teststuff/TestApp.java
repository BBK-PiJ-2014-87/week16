package teststuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TestApp {
	public static void main(String[] args) {
		String source = "test.txt";

		ArrayList<String> list = new ArrayList<String>();
		// read from file
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String str;
			while ((str = reader.readLine()) != null) {
				list.add(str.toUpperCase());
				list.add("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// write to the same file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(source))) {
			for (String s : list) {
				writer.write(s);
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
