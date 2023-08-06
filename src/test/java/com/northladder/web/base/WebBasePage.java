package com.northladder.web.base;

import com.northladder.commonutils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebBasePage {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public WebBasePage(RemoteWebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }


    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if(overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        } else{
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    public void getWindowHandles(){
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        // Iterate through the window handles and switch to the new tab
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void click(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void enterText(By by,String key){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(key);
    }
    /**
     *
     * @param by Identifier(xpath,id,css etc)
     *
     */
    public String getText(By by){
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
        return text;
    }

    /**
     *
     * @param by Identifier(xpath,id,css etc)
     *
     */
    public boolean isSelected(By by){
        boolean checkbox = driver.findElement(by).isSelected();
        return checkbox;
    }

    /**
     *
     * @param by
     * @param key
     */
    public void enterTextByClearingText(By by,String key){
        click(by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(key);
    }

    /**
     * This method excepts and enter's the text in the box and click on the element.
     * @param by The xpath of the text box.
     * @param text The text to be entered in the text box.
     * @param finalElement The created xpath of the selected element to be clicked.
     */
    public void selectByEnteringText(By by,String text,By finalElement){
        enterText(by,text);
        click(finalElement);
    }
    public void selectAnElementFromTheList(By by,String expectedText, String xpathgettextstringone,String xpathgettextstringtwo, String editliststring){
        List<WebElement> webElementsList = driver.findElements(by);
        for (int i = 0; i < webElementsList.size(); i++) {
            String text = driver.findElement(By.xpath(xpathgettextstringone + (i + 1) + xpathgettextstringtwo)).getText();
            if (text.equalsIgnoreCase(expectedText)) {
                click(By.xpath(xpathgettextstringone + (i + 1) + editliststring));
                break;
            }
        }

    }
}
