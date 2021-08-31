package Helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String IMAGE_PATH;
    public static void loadPropertiesFile() {

        try (InputStream input = new FileInputStream("/home/husseljo/IdeaProjects/demo/Ragdag/src/main/resources/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            IMAGE_PATH = prop.getProperty("images.path");
            System.out.println(IMAGE_PATH);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) {
       Config.loadPropertiesFile();
    }
}
