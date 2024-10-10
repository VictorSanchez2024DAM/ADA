package ud1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Properties;

public class Propertiess {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileReader("config/config.properties"));

            // leer valores
            System.out.println("db.username");
            System.out.println(props.getProperty("db.username", "root"));
            System.out.println(props.getOrDefault("db.username", "root"));

            // escribir clave-valor
            props.setProperty("db.password", "victor");
            props.put("db.username", "test");
            props.putIfAbsent("db.username", "1111");
            props.compute("db.username", (k, v) -> v+"1234");

            props.store(new FileWriter("config/config.properties"), LocalDate.now().toString());

        } catch (FileNotFoundException e) {
            System.err.println("Error...");
        } catch (IOException e) {
            System.err.println("Error...");
        }
    }
}
