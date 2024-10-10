package ud1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileListing {
    public static void main(String[] args) {
        File file = new File("files");
        File[] files = file.listFiles();
        for (File f : files){
            System.out.println(f.getName());
        }

        // Files:
        // Files.list --> Stream<Path> -- No es recursivo
        // Files.walk --> Stream<Path> -- Si es recursivo
        // Files.find --> Stream<Path> -- Si es recursivo



        Path path = Path.of("files");

        try(Stream<Path> stream = Files.find(path, Integer.MAX_VALUE, (p, attr) -> attr.isRegularFile())) {
            stream.forEach(path1 -> {
                try {
                    System.out.println(path1.getFileName().toString()
                    + " " + Files.size(path1));
                } catch (IOException e) {

                }
            });

        } catch (IOException e) {
            System.err.println("Error...");
        }
    }
}
