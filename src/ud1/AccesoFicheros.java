package ud1;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AccesoFicheros {
    public static void main(String[] args) {
        // FileWriter
        try (FileWriter fw = new FileWriter("files/fichero1.txt")) {
            fw.write("texto de prueba");
        } catch (IOException e) {
            System.err.println("AH");
        }
        // File, Files, Path, Paths
        // File --> gestionar rutas, directorios y ficheros.
        File file = new File("files/fichero1.txt");
        if(file.exists()){
            System.out.println("El fichero existe");
        }
        System.out.println(file.getAbsoluteFile());

        // Files, Path, Paths
        Path path = Path.of("files/fichero1.txt");
        if(Files.exists(path)){
            System.out.println("si");
        }

        try {

            Files.write(path, "soy victor".getBytes(), StandardOpenOption.APPEND);
            Files.writeString(path, "estoy en clase de ada", StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines.size());
            String textoTotal = Files.readString(path, StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
