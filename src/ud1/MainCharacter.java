package ud1;

import java.io.Serializable;
import java.util.List;

public class MainCharacter implements Serializable {
    private String name;
    private int age;
    private List<String> abilities;
    private boolean isGenin;
    private List<Friend> friends;

    public MainCharacter(String name, int age, List<String> abilities, boolean isGenin, List<Friend> friends) {
        this.name = name;
        this.age = age;
        this.abilities = abilities;
        this.isGenin = isGenin;
        this.friends = friends;
    }
}
