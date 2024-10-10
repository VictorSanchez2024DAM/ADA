package ud1;

import java.io.Serializable;
import java.util.List;

public class Anime implements Serializable {

    private MainCharacter mainCharacter;
    private int episodes;
    private boolean hasFinished;
    private List<Villain> villains;
    private Rating ratings;
    private List<Season> seasons;

    public Anime(MainCharacter mainCharacter, int episodes, boolean hasFinished, List<Villain> villains, Rating ratings, List<Season> seasons) {
        this.mainCharacter = mainCharacter;
        this.episodes = episodes;
        this.hasFinished = hasFinished;
        this.villains = villains;
        this.ratings = ratings;
        this.seasons = seasons;
    }
}
