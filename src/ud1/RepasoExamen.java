package ud1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * java.io --> File --> gestion de rutas
 * java.nio --> Files y Path --> rutas y ficheros
 *
 *
 * Files.list,walk y find
 *
 * Leer y escribir archivos --> BufferedReader/Writer
 * Files.readAll...
 *
 * Properties --> key=valor
 * - load
 * - setProperty, put, compute
 * - getProperty
 * - store
 *
 * JSON --> clases a json, json a clases
 *
 * Serializar -- serialVersionUID - ObjectOutputStream
 * - writeObject
 *  ObjectInputStream --> readObject
 *
 *
 *  Crea un metodo que recibe un path que contiene fichero por parámetro
 *  Primero comprueba que el fichero existe y no es un directorio.
 *  Lee el fichero que contiene varias lineas de texto. Modifica
 *  cada linea agregando un número de línea al principio de la misma
 *  y escribe el resultado en un nuevo fichero.
 *
 *
 *
 *  Busca e imprime los directorios que solo contiene un fichero
 *  con una extension especificada por parametro al método
 *  Busca en todos los niveles.
 *
 *
 *
 *
 *  Crea un metodo que pasado un fichero o path, validar si el fichero de log
 *  cumple cierto formato.
 *  Formato: [Fecha] [Hora] [Nivel] Mensaje
 *  Ejemplo: [2024-10-10] [19:10] [ERROR] Failed to start server
 *  Nivel: ERROR, WARN, INFO, DEBUG
 *
 *  Imprime y cuenta el número de líneas que no cumplen el formato
 */
public class RepasoExamen {
    public static void main(String[] args) {
        lineNumber(Path.of("files/noticias.txt"));
        extensionSearcher(Path.of("files"), "txt");
    }

    public static void lineNumber(Path path){

        if(Files.exists(path) && !Files.isDirectory(path)){
            AtomicInteger cont = new AtomicInteger(0);
            try {
                List<String> lineas = Files.readAllLines(path).stream()
                        .map(line ->{
                            cont.getAndIncrement();
                            return cont + " " + line;
                        })
                        .toList();
                Files.write(Path.of("files/lineNumber.txt"), lineas);
            } catch (IOException e) {
                System.err.println("Error...");
            }
        }

    }

    public static void extensionSearcher(Path path, String extension){
        try(Stream<Path> extensionSearch = Files.walk(path)){
            extensionSearch
                    .filter(Files::isDirectory)
                    .forEach(directory -> {
                        try(Stream<Path> filesStream = Files.list(directory)){
                            long num = filesStream.filter(Files::isRegularFile)
                                    .filter(path1 -> path1.getFileName().toString().endsWith(extension))
                                    .count();
                            if(num == 1){
                                System.out.println(directory);
                            }
                        } catch (IOException e) {
                            System.err.println("Error...");
                        }
                    });

        } catch (IOException e) {
            System.err.println("Error...");
        }
    }
}
