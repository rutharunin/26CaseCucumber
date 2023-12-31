package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String readProperty(String key){
        File file=new File("C:\\Users\\rutha\\IdeaProjects\\AutomationExercise_26\\Configuration.properties");
        Properties properties=new Properties();
        //This properties object will read the properties file.
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //more actions surround try ad catch
        return properties.getProperty(key);
    }
}
