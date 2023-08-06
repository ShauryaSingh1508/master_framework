package com.northladder.web.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverManager implements DriverManager{

    @Override
    public RemoteWebDriver createDriver(String envToExecute) {
        WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
        RemoteWebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
