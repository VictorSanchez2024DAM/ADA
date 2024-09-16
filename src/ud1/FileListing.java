package ud1;

import java.io.File;

public class FileListing {
    public static void main(String[] args) {
        File file = new File("files");
        File[] files = file.listFiles();
        for (File f : files){
            System.out.println(f.getName());
        }

        //
    }
}
