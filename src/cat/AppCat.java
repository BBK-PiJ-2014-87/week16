package cat;

/**
 * Application to read given file.
 * @author Workstation
 *
 */
public class AppCat {
	public static void main(String[] args) {
		String fileName = "test_read.txt";
		//String fileName = args[0];
		MyFileReader reader = new MyFileReader();
		reader.read(fileName);
	}

}
