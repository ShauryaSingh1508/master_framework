package com.test.mobile.pages;


import com.test.commonutils.TestUtils;
import com.test.mobile.base.MobileBasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends MobileBasePage {

	@AndroidFindBy (accessibility = "test-Username") 
	@iOSXCUITFindBy (id = "test-Username")
	private WebElement usernameTxtFld;

	@AndroidFindBy (accessibility = "test-Password") 
	@iOSXCUITFindBy (id = "test-Password")
	private WebElement passwordTxtFld;
	
	@AndroidFindBy (accessibility = "test-LOGIN") 
	@iOSXCUITFindBy (id = "test-LOGIN")
	private WebElement loginBtn;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private WebElement errTxt;
	
public LoginPage enterUserName(String username) {
	clear(usernameTxtFld);	
	sendKeys(usernameTxtFld, username, "login with " + username);
	return this;
}

public LoginPage enterPassword(String password) {
	clear(passwordTxtFld);
	sendKeys(passwordTxtFld, password, "password is " + password);
	return this;
}

public ProductsPage pressLoginBtn() {
	click(loginBtn, "press login button");
	return new ProductsPage();
}

/*public ProductsPage login(String username, String password) {
	enterUserName(username);
	enterPassword(password);
	return pressLoginBtn();
}*/

public String getErrTxt() {
	String err = getText(errTxt, "error text is - ");
	return err;
}

}
