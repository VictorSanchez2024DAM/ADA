package ud1;
import java.io.Serializable;
import java.util.List;

public class Friend implements Serializable {
    private String name;
    private String clan;
    private List<String> skills;

    public Friend(String name, String clan, List<String> skills) {
        this.name = name;
        this.clan = clan;
        this.skills = skills;
    }
}
