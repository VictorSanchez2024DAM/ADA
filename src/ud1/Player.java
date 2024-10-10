package ud1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringJoiner;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient int accountId;


    private String name;
    private int score;
    private List<String> weapons;


    public Player(String name, List<String> weapons, int score) {
        this.name = name;
        this.weapons = weapons;
        this.score = score;
    }

    @Override
    public String toString() {
        return new StringJoiner(",", Player.class.getSimpleName() + "[",
                "]")
                .add(name)
                .add("" + score)
                .add("" + weapons)
                .toString();
    }
}

class MainObjeto {
    public static void main(String[] args) {
        try (ObjectOutputStream os = new ObjectOutputStream(
                Files.newOutputStream(Path.of("files/object.data")))) {
            os.writeObject(new Player("Victor", List.of("canyon", "revolver"), 100));

        } catch (IOException e) {
            System.err.println("Error..." + e.getMessage());
        }

        try (ObjectInputStream oi = new ObjectInputStream(Files.newInputStream(Path.of("files/object.data")))) {
            System.out.println((Player) oi.readObject());


        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error...");
        }
    }
}
