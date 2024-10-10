package ud1;

import java.io.Serializable;
import java.util.List;

public class Season implements Serializable {
    private int seasonNumber;
    private int episodes;
    private List<SpecialEpisode> specialEpisodes;

    public Season(int seasonNumber, int episodes) {
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
        this.specialEpisodes = null;
    }

    public Season(int seasonNumber, int episodes, List<SpecialEpisode> specialEpisodes) {
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
        this.specialEpisodes = specialEpisodes;
    }
}
