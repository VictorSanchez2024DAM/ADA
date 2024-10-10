package ud1;

import java.io.Serializable;

public class SpecialEpisode implements Serializable {
    private String title;
    private int lengthMinutes;

    public SpecialEpisode(String title, int lengthMinutes) {
        this.title = title;
        this.lengthMinutes = lengthMinutes;
    }
}
