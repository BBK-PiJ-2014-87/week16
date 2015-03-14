package catmultiple;

import cat.MyFileReader;

/**
 * @author Workstation
 *
 */
public class AppCatMultiple {
	
	public static void readMultiple(String[] fileNames){
		MyFileReader reader = new MyFileReader();
		for(String file: fileNames){
			reader.readRes(file);
		}
		
	}
	public static void main(String[] args) {
		readMultiple(args);
	}

}
