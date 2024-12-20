package com.test.web.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface DriverManager {
    RemoteWebDriver createDriver(String envTYpe) throws MalformedURLException;
}
