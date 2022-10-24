package com.stv.bdd.steps;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL_US;

public class BasicBddTest {
    public static WebDriver getDriver() {
        return Driver.getDriver();
    }

    public void setUp() {
        WebDriver driver = getDriver();
        driver.get(START_URL_US);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void quit() {
        getDriver().quit();
    }
}
