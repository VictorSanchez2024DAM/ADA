package ud1;

import java.io.Serializable;

public class Rating implements Serializable {
    private double IMDb;
    private double MyAnimeList;

    public Rating(double IMDb, double myAnimeList) {
        this.IMDb = IMDb;
        MyAnimeList = myAnimeList;
    }
}
