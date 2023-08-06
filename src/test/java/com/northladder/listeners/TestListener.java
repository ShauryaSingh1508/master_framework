package com.northladder.listeners;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.northladder.commonutils.ExtentReport;
import com.northladder.commonutils.TestUtils;
import com.northladder.mobile.base.MobileBasePage;
import com.northladder.web.base.BaseTest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TestListener extends BaseTest implements ITestListener {
	TestUtils utils = new TestUtils();
	
	public void onTestFailure(ITestResult result) {

		byte[] encoded = null;
		try {
			if(result.getThrowable() != null) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				result.getThrowable().printStackTrace(pw);
				utils.log().error(sw.toString());
			}

		/*	MobileBasePage base = new MobileBasePage();
			File file = base.getDriver().getScreenshotAs(OutputType.FILE);

			Map <String, String> params = new HashMap<String, String>();
			params = result.getTestContext().getCurrentXmlTest().getAllParameters();
			//This is for mobile App settings
			String imagePath = "Screenshots" + File.separator + params.get("platformName")
			+ "_" + params.get("deviceName") + File.separator + base.getDateTime() + File.separator
			+ result.getTestClass().getRealClass().getSimpleName() + File.separator + result.getName() + ".png";

			String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;

		*//*	String imagePath = "Screenshots" + File.separator + params.get("browser")
					+ "_" + params.get("env") + File.separator + new TestUtils().dateTime() + File.separator
					+ result.getTestClass().getRealClass().getSimpleName() + File.separator + result.getName() + ".png";

			String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;
			File file = new BaseTest().takeScreenshotAs( new File(completeImagePath));*//*
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
			FileUtils.copyFile(file, new File(imagePath));
			Reporter.log("This is the sample screenshot");
			Reporter.log("<a href='"+ completeImagePath + "'> <img src='"+ completeImagePath + "' height='400' width='400'/> </a>");
			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());

			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
			ExtentReport.getTest().fail(result.getThrowable());*/
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		




	}
	@Override
	public void onTestStart(ITestResult result) {
		MobileBasePage base = new MobileBasePage();
		ExtentReport.startTest(result.getName(), result.getMethod().getDescription(),"Web")
		.assignCategory(base.getPlatform() + "_" + base.getDeviceName())
		.assignAuthor("Shaurya");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.getReporter("Web").flush();
	}

}
