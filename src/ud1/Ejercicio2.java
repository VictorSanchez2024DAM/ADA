package ud1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio2 {

    public static void main(String[] args) {
        // 1
        Path path1 = Path.of("ej2");
        Path path2 = Path.of("files");

        directoryCompare(path1, path2);

        // 2
        Path path3 = Path.of(args[0]);
        try(Stream<Path> pathFind = Files.walk(path3)) {
            pathFind.forEach(path -> {
                if (path.getFileName().toString().equals(args[1])) {
                    System.out.println("El archivo " + args[1] + " existe");
                }
            });

        } catch (IOException e) {
            System.err.println("Error....");
        }

        // 3
        try{
            long totalSize = Files.walk(path2)
                    .filter(Files::isRegularFile)
                    .mapToLong(file ->{
                        try {
                            return Files.size(file);
                        } catch (IOException e) {
                            System.err.println("Error....");
                            return 0;
                        }
                    })
                    .sum();

            long totalFiles = Files.walk(path2)
                    .filter(Files::isRegularFile)
                    .count();

            long totalDirectories = Files.walk(path2)
                    .filter(Files::isDirectory)
                    .count();


            System.out.println("Tamaño total del directorio: " + totalSize + " bytes");
            System.out.println("Cantidad de archivos: " + totalFiles);
            System.out.println("Cantidad de directorios: " + totalDirectories);

        } catch (IOException e){
            System.err.println("Error...");
        }

        // 4
        fileSearchDuplicate(path2);

        // 5
        emptyDirectoryCount(path2);



    }

    // 1
    public static void directoryCompare(Path path1, Path path2) {
        try {
            List<Path> dir1 = obtainPath(path1);
            List<Path> dir2 = obtainPath(path2);

            System.out.println("Archivos en " + dir1 + " que no estan en " + dir2);
            dir1.stream()
                    .filter(path ->  !dir2.contains(path.getFileName()))
                    .forEach(System.out::println);

            System.out.println("Archivos en " + dir2 + " que no estan en " + dir1);
            dir2.stream()
                    .filter(path ->  !dir1.contains(path.getFileName()))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error....");
        }

    }
    public static List<Path> obtainPath(Path path) throws IOException {
        try (Stream<Path> obtain = Files.list(path)) {
            return obtain
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .collect(Collectors.toList());
        }
    }

    // 4
    public static void fileSearchDuplicate(Path path){
        Set<String> unicNames = new HashSet<>();
        Set<String> duplicateNames = new HashSet<>();

        try(Stream<Path> search = Files.walk(path)){
            search.filter(Files::isRegularFile)
                    .forEach(file -> {
                        String name = file.getFileName().toString();
                        if(!unicNames.add(name)){
                            duplicateNames.add(name);
                        }
                    });

            System.out.println("Total de archivos duplicados es " + duplicateNames.size());
        } catch (IOException e){
            System.err.println("Error...");
        }
    }

    // 5
    public static void emptyDirectoryCount(Path path){
        try(Stream<Path> emptyDirectory = Files.walk(path)){
            long totalEmptyDirectories = emptyDirectory
                    .filter(Files::isDirectory)
                    .filter(directory -> {
                        try {
                            return Files.list(directory).findAny().isEmpty();
                        } catch (IOException e) {
                            System.err.println("Error...");
                            return false;
                        }
                    })
                    .count();
            System.out.println("El total de directorios vacíos es " + totalEmptyDirectories);
        } catch (IOException e){
            System.err.println("Error...");
        }
    }
}
