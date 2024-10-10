package ud1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minecraft {
    private List<Biome> biomes;

    class Biome{
        private String name;
        private Characteristic characteristics;
        private List<String> resources;
        private List<Events> events;
        private String discoveryDate;

    }
    class Characteristic{
        private String temperature;
        private String precipitations;
        private List<String> mobs;
    }


    class Events{
        private String event;
        private String date;
        private List<String> activities;
    }
}
