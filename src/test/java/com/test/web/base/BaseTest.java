package com.test.web.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.test.commonutils.ExtentReport;
import com.test.commonutils.TestUtils;
import com.test.web.constants.DriverType;
import com.test.web.factory.DriverManagerFactory;
import com.test.commonutils.CookieUtils;
import io.restassured.http.Cookies;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BaseTest {

    public static String envType;
    private final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    private void setDriver(RemoteWebDriver driver){
        this.driver.set(driver);

    }
    public RemoteWebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters({ "browser", "env", "envToExecute"})
    @BeforeMethod
    public synchronized void startDriver(@Optional String browser, String env, String envToExecute) throws MalformedURLException {
        browser = System.getProperty("browser", browser);
        envType = System.getProperty("env", env);
        setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver(envToExecute));
/*        String strFile = "logs" + File.separator + browser + "_" + env;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        //route logs to separate file for each thread
        ThreadContext.put("ROUTINGKEY", strFile);*/
          System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver(@Optional String browser, ITestResult result) throws InterruptedException, IOException {
        byte[] encoded = null;
        Thread.sleep(300);
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
        if(result.getStatus() == ITestResult.FAILURE){
            File destFile = new File("Screenshots" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");
            takeScreenshot(destFile);

            //For reporting into Extent reports
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(destFile));
            //To attach the screenshot in a file format
            /*String completeImagePath = System.getProperty("user.dir") + File.separator + destFile;
            ExtentReport.getTest().fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());*/
            //To attach the screenshot in a byte format
            ExtentReport.getTest().fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
            ExtentReport.getTest().fail(result.getThrowable());
        }
        getDriver().quit();

    }

    public void injectCookiesToBrowser(Cookies cookies){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie: seleniumCookies){
            System.out.println(cookie.toString());
            getDriver().manage().addCookie(cookie);
        }
    }

    public void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }



    private void takeScreenshotUsingAShot(File destFile){
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver());
        try{
           ImageIO.write(screenshot.getImage(), "PNG", destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
