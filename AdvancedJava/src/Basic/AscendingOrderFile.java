package Basic;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class AscendingOrderFile {

    public static void main(String[] args) {

        File dir = new File("D:/Projects and working files");

        if (!dir.exists()) {
            try {
                boolean created = dir.mkdir();
                System.out.println("Directory created: " + created);
            }
            catch (SecurityException e) {
                System.out.println("Permission denied to create directory.");
            }
        }
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                Arrays.sort(files, (f1, f2) ->
                        Long.compare(f1.length(),f2.length())
                );
                System.out.println("Files in ascending order:");
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
            else {
                System.out.println("Directory is empty.");
            }
        }
        else {
            System.out.println("Directory does not exist.");
        }
    }
}
