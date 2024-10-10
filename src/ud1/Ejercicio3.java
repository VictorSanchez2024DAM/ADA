package ud1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio3 {
    public static void main(String[] args) {
        try{
            // 1
            long lessThan4 =  Files.readAllLines(Path.of("files/fichero1.txt"))
                    .stream().flatMap(s -> Arrays.stream(s.split("\\s+")))
                    .filter(w -> w.length() < 4)
                    .count();
            System.out.println(lessThan4);

            // 2
            long linesWithNumber = Files.readAllLines(Path.of("files/datos.txt"))
                    .stream()
                    .filter(line -> line.matches(".*\\d.*"))
                    .count();
            System.out.println(linesWithNumber);

            // 3
            Set<String> mails = new HashSet<>();
            Files.readAllLines(Path.of("files/correos.txt"))
                    .stream().flatMap(s -> Arrays.stream(s.split("\\s+")))
                    .filter(mail -> mail.matches(".+@.+\\..+"))
                    .forEach(mails::add);
            try(BufferedWriter bw = Files.newBufferedWriter(Path.of("files/emails_extraidos.txt"))){
                for(String mail : mails){
                    bw.newLine();
                    bw.write(mail);
                }
            }
            // 4
            System.out.println(countKeyWord("java"));

            // 5
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca el nivel de error(WARN, INFO, ERROR)");
            String errorLevel = sc.nextLine();
            String linea;
            try(BufferedReader br = Files.newBufferedReader(Path.of("files/log.txt"))){
                while((linea = br.readLine()) != null) {
                    try(BufferedWriter bw = Files.newBufferedWriter(Path.of("files/logs_" + errorLevel), StandardOpenOption.APPEND)){
                        if(linea.contains(errorLevel)){
                            bw.newLine();
                            bw.write(linea);
                            bw.flush();
                    }
                    }
                }
            }

            // 6
            Map<String, Integer> wordCountText = Files.readAllLines(Path.of("files/wiki.txt"))
                    .stream().flatMap(s -> Arrays.stream(s.split("[\\s\\p{Punct}]+")))
                    .filter(w -> w.length() > 5)
                    .map(String::toLowerCase)
                    .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));


            wordCountText.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .forEach(word -> System.out.println(word.getKey()));

        } catch (IOException e){
            System.err.println("Error...");
        }
    }

    // 4
    public static long countKeyWord(String keyWord)throws IOException{
       return Files.readAllLines(Path.of("files/noticias.txt"))
                .stream().flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(word -> word.matches(keyWord))
                .count();
    }
}
