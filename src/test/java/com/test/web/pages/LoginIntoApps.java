package com.test.web.pages;

import com.test.api.tests.GetMailtrapPropsTest;
import com.test.web.base.WebBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginIntoApps extends WebBasePage{

    private final By emailAddress = By.name("email");
    private final By otp = By.name("otp");
    private final By submitButton = By.xpath("//*[@type='submit']");
    private final By logINButton = By.xpath("//*[@type='submit' and text() = 'Log In']");

    public LoginIntoApps(RemoteWebDriver driver) {
        super(driver);

    }

    public LoginIntoApps load(){
        load("");
        return this;
    }

    public LoginIntoApps loginintoPrismApp(String txt) throws Exception {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress)).sendKeys(txt);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
        Thread.sleep(10000);
        String otpforAdmin = GetMailtrapPropsTest.getOTPfromMsgBody();
        wait.until(ExpectedConditions.visibilityOfElementLocated(otp)).sendKeys(otpforAdmin);
//        wait.until(ExpectedConditions.elementToBeClickable(logINButton)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(logINButton)).click();
        return this;


    }


}
