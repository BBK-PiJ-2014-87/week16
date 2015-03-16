package recursivelist;

import java.io.File;

public class RecursiveListApp {
	public static void main(String[] args) {
		FileTree tree = new FileTree();
		tree.traverseTree(new File("."));
	}

}
