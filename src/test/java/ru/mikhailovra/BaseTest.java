package ru.mikhailovra;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver = null;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver_m1");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
