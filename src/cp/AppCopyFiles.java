package cp;

public class AppCopyFiles {
	public static void main(String[] args) {
		FileCopier cp = new FileCopier();
		String[] names = {
				 "test_read.txt",
				 "test_read2.txt",
				 "test_read3.txt",
				 "test_read4.txt",
				 "/Users/Workstation/Desktop/test"};
		
//		String[] names = { "test_read2.txt", "test_read4.txt" };
		
		//RUN APPLICATION
		cp.chooseCopyMethod(names);
	}
}
