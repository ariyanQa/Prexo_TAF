package com.prexo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prexo.utility.ScreenshotUtil;
import com.prexo.utility.WebDriverUtil;

public class XmlSiteMapPage {
	private WebDriver driver;

    @FindBy(xpath = "//td/a")
    private List<WebElement> webLinks;
    @FindBy(xpath ="//body")
    private WebElement pageBody;
    
    public XmlSiteMapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public List<String> getUrls() {
        List<String> urls = new ArrayList<>();
        for (WebElement link : webLinks) {
            urls.add(link.getText());
        }
        WebDriverUtil.passedTestSteps(driver, "Get Urls", true);
        
        return urls;
    }
    
    public void launchUrls(List<String> urls,String folder,String filename) {
    	for(int i=0;i<=urls.size();i++) {
    		if(i<=4) {
    			WebDriverUtil.launchUrl(driver, urls.get(i));
    			WebDriverUtil.waitForElementToBeVisible(driver, pageBody);
    			WebDriverUtil.passedTestSteps(driver, urls.get(i), true);
    			ScreenshotUtil.getScreenshot(driver,folder, folder+"_"+filename+"_URL"+i);
    		} else {
    			break;
    		}
    	}
    }
}
