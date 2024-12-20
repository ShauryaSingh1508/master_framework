package com.test.mobile.pages;

import com.test.commonutils.TestUtils;
import com.test.mobile.base.MobileBasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MenuPage extends MobileBasePage {

	
	@AndroidFindBy (xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView\n" + 
			"") 
	@iOSXCUITFindBy (xpath="//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
	private WebElement settingsBtn;
	
	public SettingsPage pressSettingsBtn() {
		click(settingsBtn, "press Settings button");
		return new SettingsPage();
	}

}
