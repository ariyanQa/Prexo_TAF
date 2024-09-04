package com.prexo.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.prexo.base.BaseTest;
import com.prexo.pages.PrexoPage;
import com.prexo.pages.XmlSiteMapPage;
import com.prexo.utility.Config;
import com.prexo.utility.DriverManager;
import com.prexo.utility.ScreenshotUtil;

public class Testcases extends BaseTest {
	@Test(priority = 1)
    public void verifyUploadedFile() {
		driver = DriverManager.getDriver("chrome");
        driver.get(Config.get("baseUrl1"));
        PrexoPage loginPage = new PrexoPage(driver);
        loginPage.enterUsername("prexo.mis@dealsdray.com");
        loginPage.enterPassword("prexo.mis@dealsdray.com");
        loginPage.clickSubmit();
        loginPage.clickOrder();
        loginPage.clickOrders();
        loginPage.clickAddBulk();
        loginPage.uploadFile();
        loginPage.clickImport();
        loginPage.clickValidate();
        loginPage.acceptAlert();
        loginPage.clickSubmitButton();
        loginPage.acceptAlert();
        ScreenshotUtil.captureScreenshot(driver);
    }
	
	@Test(priority = 2)
    public void verifyChrome() {
		driver = DriverManager.getDriver("chrome");
        driver.get(Config.get("baseUrl2"));
        XmlSiteMapPage xp = new XmlSiteMapPage(driver);
        List<String> urls = xp.getUrls();
        xp.launchUrls(urls,"Chrome");
	}
	
	@Test(priority = 3)
    public void verifyFireFox() {
		driver = DriverManager.getDriver("firefox");
        driver.get(Config.get("baseUrl2"));
        XmlSiteMapPage xp = new XmlSiteMapPage(driver);
        List<String> urls = xp.getUrls();
        xp.launchUrls(urls,"Firefox");
	}
	
	@Test(enabled=false)
    public void verifySafari() {
		driver = DriverManager.getDriver("safari");
        driver.get(Config.get("baseUrl2"));
       XmlSiteMapPage xp = new XmlSiteMapPage(driver);
        List<String> urls = xp.getUrls();
        xp.launchUrls(urls,"safari");
	}
	
	@Test(priority = 4)
    public void verifyEdge() {
		driver = DriverManager.getDriver("edge");
        driver.get(Config.get("baseUrl2"));
       XmlSiteMapPage xp = new XmlSiteMapPage(driver);
        List<String> urls = xp.getUrls();
        xp.launchUrls(urls,"edge");
	}
}
