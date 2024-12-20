package com.test.listeners;


import com.aventstack.extentreports.Status;
import com.test.commonutils.CustomCheckedException;
import com.test.commonutils.CustomRuntimeException;
import com.test.commonutils.ExtentReport;
import com.test.commonutils.TestUtils;
import com.test.mobile.base.MobileBasePage;
import com.test.web.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListener extends BaseTest implements ITestListener {


	public void onTestFailure(ITestResult result) {

		try {
			if(result.getThrowable() != null) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				result.getThrowable().printStackTrace(pw);
				String logType = getString(result);
				TestUtils.log(logType).error(sw.toString());

			}

		} catch (CustomRuntimeException e1) {
			e1.getCause();
        }

	}

	private String getString(ITestResult result) {
		String packageName = result.getMethod().getTestClass().getName();
		  return switch (packageName) {
					default -> {
						if (packageName.contains("api")) {
							yield "rest";
						} else if (packageName.contains("web")) {
							yield "web";
						} else {
							yield "mobile";
						}
					}
				};

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
