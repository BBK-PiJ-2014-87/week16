package cat;

/**
 * Application reads file that is inputed through the console.
 * @author Workstation
 *
 */
public class AppCat {
	public static void main(String[] args) {
		//file to test
		//String fileName = "test_read.txt";
		String fileName = args[0];
		MyFileReader reader = new MyFileReader();
		reader.read(fileName);
	}

}
