package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static final String USER_CONFIG_FILE = "src/test/resources/config.properties";
    private Properties properties;

    public ConfigLoader() {
        this.properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try (FileInputStream file = new FileInputStream(USER_CONFIG_FILE)) {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
