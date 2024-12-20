package com.test.web.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverFinder;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ChromeDriverManager implements DriverManager{
    RemoteWebDriver driver;

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
            //driver = new RemoteWebDriver(new URL("http://zalenium:4444/wd/hub"), options);
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
            ltOptions.put("username", username);
            ltOptions.put("accessKey", accesskey);
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
//            WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache();

//           WebDriverManager.chromedriver().driverVersion("latest").cachePath("Drivers").setup();
//            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win32/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
//            options.setBrowserVersion("116.0.5845.96");
            options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
            options.addArguments("--start-maximized");
            //options.setBrowserVersion("beta");
            //DriverFinder finder = new DriverFinder(ChromeDriverService.createDefaultService(), options);
            //options.setBinary(finder.getBrowserPath());
            //options.addArguments("--headless");
            SeleniumManagerOutput.Result result = SeleniumManager.getInstance().getDriverPath(options,false);

            System.out.println(result.getDriverPath()+"  "+result.getBrowserPath());
            //System.setProperty("webdriver.http.factory", "jdk");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
            //driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
//            return driver;
        }
        return driver;
    }

}
