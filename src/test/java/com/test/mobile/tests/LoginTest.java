package com.test.mobile.tests;

import com.test.commonutils.TestUtils;
import com.test.mobile.base.MobileBasePage;
import com.test.mobile.pages.LoginPage;
import com.test.mobile.pages.ProductsPage;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class LoginTest extends MobileBasePage {
	LoginPage loginPage;
	ProductsPage productsPage;
	JSONObject loginUsers;

	
	  @BeforeClass
	  public void beforeClass() throws Exception {
			InputStream datais = null;
		  try {
			  String dataFileName = "data/loginUsers.json";
			  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  assert datais != null;
			  JSONTokener tokener = new JSONTokener(datais);
			  loginUsers = new JSONObject(tokener);
		  } catch(Exception e) {
			  e.printStackTrace();
			  throw e;
		  } finally {
			  if(datais != null) {
				  datais.close();
			  }
		  }
		  closeApp();
		  launchApp();
	  }

	  @AfterClass
	  public void afterClass() {

	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  TestUtils.log("mobile").info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
		  loginPage = new LoginPage();
	  }

	  @AfterMethod
	  public void afterMethod() {		  
	  }
	  
	  @Test
	  public void invalidUserName() {
		  loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
		  loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
		  loginPage.pressLoginBtn();
		  
		  String actualErrTxt = loginPage.getErrTxt();
		  String expectedErrTxt = getStrings().get("err_invalid_username_or_password");
		  
		  Assert.assertEquals(actualErrTxt, expectedErrTxt);
	  }
	  
	  @Test
	  public void invalidPassword() {
		  loginPage.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
		  loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
		  loginPage.pressLoginBtn();
		  		  
		  String actualErrTxt = loginPage.getErrTxt();
		  String expectedErrTxt = getStrings().get("err_invalid_username_or_password");
		  
		  Assert.assertEquals(actualErrTxt, expectedErrTxt);
	  }
	  
	  @Test
	  public void successfulLogin() {
		  loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
		  loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
		  productsPage = loginPage.pressLoginBtn();
		  		  
		  String actualProductTitle = productsPage.getTitle();		  
		  String expectedProductTitle = getStrings().get("product_title");
		  
		  Assert.assertEquals(actualProductTitle, expectedProductTitle);
	  }
}
