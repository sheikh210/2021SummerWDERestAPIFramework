package base;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {

    public Properties properties;
    public final String PATH = System.getProperty("user.dir") + "/src/main/resources/secret.properties";

    public LoadProperties() {

        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(PATH);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
