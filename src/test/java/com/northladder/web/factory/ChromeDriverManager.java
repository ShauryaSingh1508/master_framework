package com.northladder.web.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class ChromeDriverManager implements DriverManager{
    RemoteWebDriver driver = null;
    String username= "shauryasingh1508";
    String accesskey= "dlUtov4GDGyx41JnPqhgpIeQlVbJz90BXfwIonZ48cCpq5S03G";
    String gridURL = "@hub.lambdatest.com/wd/hub";
    @Override
    public RemoteWebDriver createDriver(String envToExecute) throws MalformedURLException {

        if (envToExecute.equalsIgnoreCase("github")) {
            WebDriverManager.chromedriver().cachePath("Drivers").setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
            //options.addArguments("--headless");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
            driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
            return driver;
        } else if(envToExecute.equalsIgnoreCase("lambdaTest")){
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("114.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "shauryasingh1508");
            ltOptions.put("accessKey", "dlUtov4GDGyx41JnPqhgpIeQlVbJz90BXfwIonZ48cCpq5S03G");
            ltOptions.put("project", "Admin");
            ltOptions.put("w3c", true);
            ltOptions.put("plugin", "java-testNG");
            ltOptions.put("network", true);
            ltOptions.put("console", true);
            ltOptions.put("visual", true);
            ltOptions.put("video", true);
            browserOptions.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL),browserOptions);
        } else{
            WebDriverManager.chromedriver().cachePath("Drivers").setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
            driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
            return driver;
        }
        return driver;
    }

}
