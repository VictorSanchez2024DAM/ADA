package ud1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            props.load(new FileReader("config/game-settings.properties"));
            PropertiesManager.showProperties(props);

            Scanner sc = new Scanner(System.in);

            String changeProperty = "S";
            while(changeProperty.equals("S")){
                System.out.println("Desea cambiar alguna propiedad?(S/N)");
                changeProperty = sc.nextLine();
                if(changeProperty.equals("S")){
                    PropertiesManager.modifyPropertie(props);
                }

            }

            System.out.println("Saliendo...");
            PropertiesManager.addPoints(props);

        } catch (IOException e) {
            System.err.println("Error....");
        }
    }
}
