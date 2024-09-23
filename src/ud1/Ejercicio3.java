package ud1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Ejercicio3 {
    public static void main(String[] args) {
        try{
            // 1
            long lessThan4 =  Files.readAllLines(Path.of("files/fichero1.txt"))
                    .stream().flatMap(s -> Arrays.stream(s.split("\\s+")))
                    .filter(w -> w.length()<4)
                    .count();
            System.out.println(lessThan4);

            // 2

        } catch (IOException e){
            System.err.println("Error...");
        }
    }
}
