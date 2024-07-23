package com.doowup.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties properties;

    @BeforeClass
    public void loadConfig() {
        try {
            FileReader file = new FileReader(System.getProperty("user.dir")
                    + "/configuration/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Error loading configuration file: " + e.getMessage());
        }
    }

    public void launchApp() {
//        loadConfig();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

}
