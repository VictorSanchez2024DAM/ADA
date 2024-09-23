package ud1;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Alumno{
    private String nombre;
    private int edad;
    private LocalDate birthday;

    public Alumno(int edad, LocalDate birthday, String nombre) {
        this.edad = edad;
        this.birthday = birthday;
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", birthday=" + birthday +
                '}';
    }
}
public class FileWriting {
    public static void main(String[] args) {
        try {
            Files.readAllLines(Path.of("files/fichero1.txt"))
                    .stream().mapToInt(line -> line.length())
                    .sum();

            Files.readAllLines(Path.of("files/fichero1.txt"))
                    .stream().flatMap(s -> Arrays.stream(s.split("\\s+")))
                    .filter(w -> w.length()>=10)
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error...");
        }

        Path path = Path.of("files/alumno.csv");
        String header = "edad,birthday,nombre";

        Alumno victor = new Alumno(15, LocalDate.now(), "victor");

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(victor);
        alumnos.add(victor);

        // BufferedWriter
        try(BufferedWriter bw = Files.newBufferedWriter(path)){
            bw.write(header);
            for(Alumno a : alumnos){
                bw.newLine();
                bw.write(a.toString());
            }
        } catch (IOException e){
            System.err.println("Error...");
        }

        // PrintWriter
        try(PrintWriter pw = new PrintWriter("files/printwrite.csv")){
            pw.println(header);
            for(Alumno a : alumnos){
                pw.format("%s%3d%2d%2d%4d", a.getNombre(),
                        a.getEdad(), a.getBirthday().getDayOfMonth(),
                        a.getBirthday().getMonth(), a.getBirthday().getYear());
                pw.println();
            }
        } catch (FileNotFoundException e){
            System.err.println("Error....");
        }
    }

    }


