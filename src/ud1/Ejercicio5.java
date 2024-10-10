package ud1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        Anime naruto = new Anime(
                new MainCharacter(
                        "Naruto Uzumaki",
                        12,
                        List.of("Rasengan", "Shadow Clone Jutsu"),
                        true,
                        List.of(new Friend("Sasuke Uchiha", "Uchiha", List.of("Sharingan", "Chidori")),
                                new Friend("Sakura Haruno", "null", List.of("Medical Ninjutsu")))),
                220,
                true,
                List.of(
                        new Villain("Orochimaru", "null"),
                        new Villain("Itachi Uchiha", "null"), new Villain("Pain", "Akatsuki")),
                new Rating(8.3, 7.9),
                List.of(
                        new Season(1, 57),
                        new Season(2, 43),
                        new Season(3, 41,
                                List.of(new SpecialEpisode("Konoha Sports Festival", 11)))));



        try (ObjectOutputStream os = new ObjectOutputStream(
                Files.newOutputStream(Path.of("files/anime.dat")))) {

            os.writeObject(naruto);



        } catch (IOException e) {
            System.err.println("Error..." + e.getMessage());
        }

        try (ObjectInputStream oi = new ObjectInputStream(Files.newInputStream(Path.of("files/anime.dat")))) {
            Anime narutoDat = (Anime)oi.readObject();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String narutoJson = gson.toJson(narutoDat);

            Files.writeString(Path.of("files/anime.json"), narutoJson);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error...");
        }

    }
}
