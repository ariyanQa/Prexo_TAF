package com.prexo.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class WebDriverUtil {

    public static void clickElement(WebDriver driver, WebElement element) {
        waitForElementToBeClickable(driver, element);
        element.click();
    }

    public static void enterText(WebDriver driver, WebElement element, String text) {
        waitForElementToBeVisible(driver, element);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(WebDriver driver, WebElement element) {
        waitForElementToBeVisible(driver, element);
        return element.getText();
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isElementPresent(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }
    
    public static void handleAlert(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred while handling alert: " + e.getMessage());
        }
    }
    
    public static void passedTestSteps(WebDriver driver,String step,boolean screenshotFlag) {
    	if(screenshotFlag) {
    		String base64Screenshot = ScreenshotUtil.captureScreenshot(driver);
        	ExtentManager.getTest().log(Status.PASS, step,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    	} else {
    		ExtentManager.getTest().log(Status.PASS, step);
    	}
    	
    }
    
    public static void failedTestSteps(WebDriver driver,String step,boolean screenshotFlag) {
    	if(screenshotFlag) {
    		String base64Screenshot = ScreenshotUtil.captureScreenshot(driver);
    		);

        	ExtentManager.getTest().log(Status.FAIL, step,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    	} else {
    		ExtentManager.getTest().log(Status.FAIL, step);
    	}
    	
    }
    
    public static void launchUrl(WebDriver driver, String url) {
        driver.get(url);
    }
}
