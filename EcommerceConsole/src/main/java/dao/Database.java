package com.example.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
    private static String URL;
    private static String USER;
    private static String PASS;

    static {
        try (InputStream in = Database.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties p = new Properties();
            p.load(in);
            URL = p.getProperty("db.url");
            USER = p.getProperty("db.user");
            PASS = p.getProperty("db.password");
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB config", e);
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
