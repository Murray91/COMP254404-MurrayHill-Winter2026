package ex3;

import java.io.File;

/**
 * Exercise 3
 * Recursively searches a directory tree for a file with a given name.
 */
public class RecursiveFileFinder {

    public static void find(String path, String filename) {

        File file = new File(path);

        // If path doesn't exist
        if (!file.exists()) {
            System.out.println("Path does not exist.");
            return;
        }

        // If it's a directory
        if (file.isDirectory()) {

            File[] list = file.listFiles();

            if (list != null) {
                for (File f : list) {

                    // Recursive call if directory
                    if (f.isDirectory()) {
                        find(f.getAbsolutePath(), filename);
                    }

                    // If file matches filename
                    else if (f.getName().equals(filename)) {
                        System.out.println("Found: " + f.getAbsolutePath());
                    }
                }
            }
        }
    }
}