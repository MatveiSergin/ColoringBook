package com.github.matveisergin.coloringbook.cofig;

import java.io.IOException;
import java.io.InputStream;

public final class PropertiesFactory {

    private static DatabaseProperties properties;
    private static final String FILE_PROPERTIES_NAME = "application.properties";
    private static final int STATUS = -1;

    private PropertiesFactory() {
    }

    public synchronized static DatabaseProperties getProperties() {
        if (properties == null) {
            init();
        }
        return properties;
    }

    private static void init() {
        String filePropertiesName = FILE_PROPERTIES_NAME;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        properties = new DatabaseProperties();
        try (InputStream stream = classLoader.getResourceAsStream(filePropertiesName)) {
            properties.load(stream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(STATUS);
        }
    }
}
