package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static { //static block will make it run the very first in the program
        try {
            //here we will be reading from a file
            String path = "src/test/resources/configurations.properties"; //specifying where the file is located starting w source

            FileInputStream input = new FileInputStream(path);

            // will load our configurations into Properties object
            properties = new Properties();
            properties.load(input);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //single method that will use to read value  from a properties object
    public static String getProperty(String key){
        return properties.getProperty(key.trim()); // .trim() will get rid of extra spaces
    }

}




