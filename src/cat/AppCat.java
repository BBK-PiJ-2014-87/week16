package cat;

/**
 * Application reads file that is inputed through the console.
 * @author Vladimirs Ivanovs
 *
 */
public class AppCat {
	public static void main(String[] args) {
		
		MyFileReader reader = new MyFileReader();
		try{
			//below is a file for quick test
//			String fileName = "test_read.txt";
			String fileName = args[0];
//			reader.read(fileName);
			reader.readRes(fileName);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No file entered. Please enter a valid file name.");
		}
		
		
	}

}
