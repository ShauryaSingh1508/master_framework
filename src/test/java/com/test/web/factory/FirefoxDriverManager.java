package com.test.web.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverManager implements DriverManager {
    RemoteWebDriver driver;

    @Override
    public RemoteWebDriver createDriver(String envToExecute) {
        if (envToExecute.equalsIgnoreCase("github")) {
            System.out.println("test");
        } else {
            //WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setBrowserVersion("stable");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        }
        return driver;
    }
}
