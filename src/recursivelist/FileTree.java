package recursivelist;

import java.io.File;

public class FileTree {

	public void traverseTree(File dir) {
		String level = "-";
		File[] files = dir.listFiles();
		if (files.length > 0) {
			for (File f : files) {
				if (f.isDirectory()) {
					level = level.concat("-");
					traverseTree(f);
				}
				System.out.println(level+ f.getName());
			}
		} else {
			return;
		}
	}

}
