package ud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Charset --> conjunto caracteres
 * Carácter tiene un código numérico único llamado code point.
 *
 * 3 de los más usados : ASCII, Unicode, Windows-1252
 * ASCII --> es el más viejo, ASCII- o ISO-
 * Unicode --> UTF-8 (más usado en internet), UTF-16, UTF-32
 */
public class FileReading {
    public static void main(String[] args) {
        try(BufferedReader r = Files.newBufferedReader(Path.of(""))){
            r.lines();

        } catch (IOException e){
            System.err.println("Error...");
        }
    }
}
