package com.github.matveisergin.coloringbook.cofig;

import java.util.Properties;

public class DatabaseProperties extends Properties {

    private static final String URL = "database.url";
    private static final String USER = "database.user";
    private static final String PASSWORD = "database.password";

    public String getUrl() {
        return getProperty(URL);
    }

    public String getLogin() {
        return getProperty(USER);
    }

    public String getPassword() {
        return getProperty(PASSWORD);
    }
}
