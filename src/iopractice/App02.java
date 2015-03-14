package iopractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

/**
 * Initial file Read/Write test.
 * To be updated.
 * @author Vladimirs Ivanovs
 *
 */
public class App02 {
	String filename = "." + File.separator + "src" + File.separator
			+ "filejava" + File.separator + "myfile.txt";
	File file = new File(filename);

	public void closeReader(Reader reader) {
		try {
			if (reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String read() {
		BufferedReader in = null;
		String str = "";
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				str = str + line.toUpperCase() + "*****\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + file + " doesn't exist!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(in);
		}
		return str;
	}

	public void write(String str) {
		PrintWriter out;
		out = null;
		try {
			out = new PrintWriter(file);
			out.write(str);
		} catch (FileNotFoundException ex) {
			// This happens if file doesn't exist and cannot be created
			// or if it exists, but is not writable
			System.out.println("Cannot write to file " + file + ".");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		App02 app1 = new App02();
		app1.write(app1.read());
		System.out
				.println("File " + app1.filename.toString() + " was changed!");
	}
}
