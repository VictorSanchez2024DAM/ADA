package ud1;

import java.io.Serializable;

public class Villain implements Serializable {
    private String name;
    private String organization;

    public Villain(String name, String organization) {
        this.name = name;
        this.organization = organization;
    }
}
