/*
package com.northladder.web.pages;


import com.northladder.web.base.WebBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPageWeb extends WebBasePage {
*/
/*    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn = By.cssSelector(".checkout-button");
    private final By cartHeading = By.cssSelector(".has-text-align-center");*//*

    @FindBy(css = "td[class='product-name'] a") private WebElement productName;
    @FindBy(how = How.CSS, using = ".checkout-button") @CacheLookup private WebElement checkoutBtn;

    public CartPageWeb(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public CheckoutPageWeb checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        return new CheckoutPageWeb(driver);
    }
}
*/
