package com.northladder.commonutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    static ExtentReports extent;
    final static String filePath = "Extent.html";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap();
    
    public synchronized static ExtentReports getReporter(String getReportType) {
        if (extent == null) {
            if(getReportType.equalsIgnoreCase("Mobile")) {
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("MobileAppReport.html");
                sparkReporter.config().setDocumentTitle("Dealer App");
                sparkReporter.config().setReportName("Daily Report");
                sparkReporter.config().setTheme(Theme.DARK);
                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
            }else if(getReportType.equalsIgnoreCase("Web")) {
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/WebAppReport.html");
                sparkReporter.config().setDocumentTitle("Admin App Report");
                sparkReporter.config().setReportName("Prism Report");
                sparkReporter.config().setTheme(Theme.DARK);
                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
            }else{
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ApiTestReport.html");
                sparkReporter.config().setDocumentTitle("API Test Report");
                sparkReporter.config().setReportName("API Testing Daily Report");
                sparkReporter.config().setTheme(Theme.DARK);
                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);

            }
        }
        
        return extent;
    }
    
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc, String getReportType) {
        ExtentTest test = getReporter(getReportType).createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
