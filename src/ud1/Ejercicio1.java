package ud1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {
        // 1
        Path path = Path.of(args[0]);
        try {
            // 2
            if(!Files.exists(path)){
                Files.createFile(path);

                Scanner sc = new Scanner(System.in);

                System.out.println("Introduce lineas en el nuevo archivo, introduzca FIN para finalizar.");

                String input = sc.nextLine();
                Files.writeString(path, input);

                while(!input.equals("FIN")){
                    input = sc.nextLine();
                    Files.writeString(path, input, StandardOpenOption.APPEND);
                }
            } else{
                List<String> lines = Files.readAllLines(path);
                System.out.println(lines);
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado o no se ha podido crear");
        }


        // 3
        Path pathTest = Path.of("files/Test.txt");

        String content = "Ejemplo";

        try {
            Files.writeString(path, content, StandardOpenOption.CREATE_NEW);
            System.out.println("Archivo creado y escrito con éxito");
        } catch (IOException e) {
            System.out.println("El archivo ya existe o ocurrió un problema al escribir.");
        }

        // 4
        Path pathCont = Path.of("files/fichero1.txt");

        String word = "java";

        long wordQuantity = contWordFiles(pathCont, word);

        System.out.println("La palabra " + word + " aparece " + wordQuantity + " veces");

        // 5
        // Files.copy() permite copiar archivos o directorios, recibiendo como parametros
        // una ruta destino(target)  y una ruta origen(source).
        // Si el archivo ya existe lanza una excepcion de tipo FileAlreadyExistException a no ser que el target y el source sean el mismo.
        // Con opciones se puede modificar este comportamiento.


        // 6
        Path sourcePath = Path.of("files/fichero1.txt");
        Path targetPath = Path.of("files/fichero3.txt");

        moveFile(sourcePath, targetPath);


    }
    // 4
    public static long contWordFiles(Path path, String word){
        String lowerWord = word.toLowerCase();

        long cont = 0;

        try (Stream<String> lineas = Files.lines(path)) {
            cont = lineas
                    .map(String::toLowerCase)
                    .flatMap(linea -> Stream.of(linea.split("[\\s,.;:!?()]+")))
                    .filter(fileWord -> fileWord.equals(lowerWord))
                    .count();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return cont;
    }

    public static void moveFile(Path source, Path target){
        if(Files.exists(source) && Files.exists(target)){
            try {
                Files.move(source, target);
            } catch (IOException e) {
                System.out.println("Error al intentar mover el fichero: " + e.getMessage());
            }
        } else{
            System.out.println("El origen o el destino no existen");
        }
    }
}
