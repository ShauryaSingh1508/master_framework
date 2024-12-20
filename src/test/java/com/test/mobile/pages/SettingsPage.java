package com.test.mobile.pages;


import com.test.commonutils.TestUtils;
import com.test.mobile.base.MobileBasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SettingsPage extends MobileBasePage {

	
	@AndroidFindBy (accessibility="test-LOGOUT") 
	@iOSXCUITFindBy (id = "test-LOGOUT")
	private WebElement logoutBtn;
	
	public LoginPage pressLogoutBtn() {
		click(logoutBtn, "press Logout button");
		return new LoginPage();
	}

}
