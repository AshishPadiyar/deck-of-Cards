package com.basic.framework.test.setUp;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.basePath;

public class Setup {


    public static InputStream fis;
    public static Properties config;


    @BeforeAll
    public static void setup() throws IOException {
        config = new Properties();
        try {

            fis = Setup.class.getClassLoader().getResourceAsStream("config.properties");
            config.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        RestAssured.baseURI = config.getProperty("baseURI");
        basePath = config.getProperty("basePath");

    }
}
