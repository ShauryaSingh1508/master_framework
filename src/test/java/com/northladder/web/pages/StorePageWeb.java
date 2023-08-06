/*
package com.northladder.web.pages;


import com.northladder.web.base.WebBasePage;
import com.northladder.web.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePageWeb extends WebBasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private ProductThumbnail productThumbnail;

    public StorePageWeb(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    private StorePageWeb enterTextInSearchFld(String txt){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }

    public StorePageWeb load(){
        load("/store");
        return this;
    }

    public StorePageWeb search(String txt){
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }

    private void clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
//        return this;
    }

    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
}
*/
