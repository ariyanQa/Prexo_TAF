package com.prexo.utility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ScreenshotUtil {
    
    public static String captureScreenshot(WebDriver driver) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot tsDriver = (TakesScreenshot) driver;

            // Capture the screenshot as a base64 string
            String base64Screenshot = tsDriver.getScreenshotAs(OutputType.BASE64);

            return base64Screenshot;
        } else {
            throw new RuntimeException("Driver does not support screenshots");
        }
    }

    public static String captureFullPageScreenshot(WebDriver driver) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot tsDriver = (TakesScreenshot) driver;
            String originalScrollPosition = ((JavascriptExecutor) driver).executeScript("return window.scrollY;").toString();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            String base64Screenshot = tsDriver.getScreenshotAs(OutputType.BASE64);
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + originalScrollPosition + ");");

            return base64Screenshot;
        } else {
            throw new RuntimeException("Driver does not support screenshots");
        }
    }
    
    public static void getScreenshot(WebDriver driver,String folder,String file_name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String filename=System.getProperty("user.dir")+"/TAF-Results/screenshots/"+folder+"/"+file_name + ".png";
		File destination = new File(filename);
		try {
			 FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed "+ e.getMessage());
		}
	}
}
