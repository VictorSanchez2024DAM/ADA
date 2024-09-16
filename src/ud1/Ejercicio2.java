package ud1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio2 {

    public static void main(String[] args) {
        // 1
        Path path1 = Path.of("ej2");
        Path path2 = Path.of("files");

        directoryCompare(path1, path2);


    }

    // 1
    public static Stream<Path> directoryCompare(Path path1, Path path2){
        Stream<Path> diffs;
        try {
            Stream<Path> stream1 = Files.list(path1);
            Stream<Path> stream2 = Files.list(path2);

        } catch (IOException e) {
            System.err.println("Error....");
        }

        return diffs;
    }

}
