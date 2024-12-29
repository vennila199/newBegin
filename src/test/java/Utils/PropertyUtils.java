package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties getPropload()
    {
        Properties properties=new Properties();
        FileInputStream fs;
        File file=new File("src/test/resources/QA_config.properties");
        try {
            fs=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(fs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     return properties;
    }
}
