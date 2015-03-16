package tr;

/**
 * Application for changing text in files.
 * @author Vladimirs Ivanovs
 *
 */
public class SubstituteApp {
	public static void main(String[] args) {
		Tr app;
		app = new Tr("test_change4.txt", "mama", "REPLACED");
		app.run();
		app = new Tr("test_change4.txt", "test_change3.txt", "REPLACED", "mama");
		app.run();
		
	}
}
	