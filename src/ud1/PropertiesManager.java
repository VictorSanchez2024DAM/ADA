package ud1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesManager {


    public static void modifyPropertie(Properties props) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la propiedad que quieres cambiar");
        String propertie = sc.nextLine();
        System.out.println("Ahora introduzca su valor");
        String value = sc.nextLine();
        props.setProperty(propertie, value);
        props.store(new FileWriter("config/game-settings.properties"), "Cambios realizados");
        System.out.println("Propiedad cambiada con exito");
    }
    public static void showProperties(Properties props){
        System.out.println("sound.volume.music: " + props.getProperty("sound.volume.music", "60"));
        System.out.println("sound.mute: " + props.getProperty("sound.mute", "false"));
        System.out.println("game.difficulty: " + props.getProperty("game.difficulty", "Normal"));
        System.out.println("game.language: " + props.getProperty("game.language", "Español"));
        System.out.println("game.autosave: " + props.getProperty("game.autosave", "true"));
        System.out.println("user.username: " + props.getProperty("user.username", "Victor"));
        System.out.println("app.points: " + props.getProperty("app.points", "100"));
    }

    public static void addPoints(Properties props) throws IOException {
        int points = Integer.parseInt(props.getProperty("app.points", "100"));
        points += 50;
        props.setProperty("app.points", String.valueOf(points));
        props.store(new FileWriter("config/game-settings.properties"), "Cambios realizados");
    }
}
