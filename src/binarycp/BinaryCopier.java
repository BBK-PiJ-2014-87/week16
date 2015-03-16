package binarycp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BinaryCopier {
	public static void main(String[] args) {
		String srcFile = "Source.class";
		String trgtFile = "Target.class";

		try (InputStream source = new FileInputStream(srcFile);
				OutputStream target = new FileOutputStream(trgtFile)) {
			copy(source, target);

		} catch (FileNotFoundException e) {
			System.out.println("No such file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copy(InputStream source, OutputStream target)
			throws IOException {
		while (true) {
			int data = source.read();
			if (data != -1) {
				target.write(data);
			} else {
				return;
			}
		}
	}

}
