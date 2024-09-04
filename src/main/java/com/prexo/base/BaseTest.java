package com.prexo.base;

import com.aventstack.extentreports.Status;
import com.prexo.utility.Config;
import com.prexo.utility.DriverManager;
import com.prexo.utility.ExtentManager;
import com.prexo.utility.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentManager.createTest(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String base64Screenshot = ScreenshotUtil.captureScreenshot(driver);

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentManager.getTest().log(Status.FAIL, "Test Failed")
                          .addScreenCaptureFromBase64String(base64Screenshot);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentManager.getTest().log(Status.PASS, "Test Passed")
                          .addScreenCaptureFromBase64String(base64Screenshot);
        }
        
        DriverManager.quitDriver();
        ExtentManager.getExtentReports().flush();
    }
}
