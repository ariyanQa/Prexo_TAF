package com.prexo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prexo.utility.WebDriverUtil;

public class PrexoPage {
	private WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;
    
    @FindBy(xpath = "//span[text()='Order']")
    private WebElement orderElement;
    @FindBy(xpath = "//span[text()='Orders']")
    private WebElement ordersElemnt;
    @FindBy(xpath = "//button[@align='right']")
    private WebElement addBulkBtn;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement browseFile;
    @FindBy(xpath = "//button[text()='Import']")
    private WebElement importBtn;
    @FindBy(xpath = "//button[text()='Validate Data']")
    private WebElement validateBtn;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;
    
    String uploadFile = System.getProperty("user.dir")+"/UploadFolder/demo-data.xlsx";
	
    public PrexoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        WebDriverUtil.enterText(driver, usernameField, username);
    }

    public void enterPassword(String password) {
        WebDriverUtil.enterText(driver, passwordField, password);
    }

    public void clickSubmit() {
        WebDriverUtil.clickElement(driver, submitBtn);
        WebDriverUtil.passedTestSteps(driver, "Submit", true);
    }
    public void clickOrder() {
        WebDriverUtil.clickElement(driver, orderElement);
        WebDriverUtil.passedTestSteps(driver, "order", true);
    }
    public void clickOrders() {
        WebDriverUtil.clickElement(driver, ordersElemnt);
        WebDriverUtil.passedTestSteps(driver, "orders", true);
    }
    public void clickAddBulk() {
        WebDriverUtil.clickElement(driver, addBulkBtn);
        WebDriverUtil.passedTestSteps(driver, "ADD Bulk", true);
    }
    
    public void uploadFile() {
        WebDriverUtil.enterText(driver, browseFile, uploadFile);
    }
    
    public void acceptAlert() {
    	WebDriverUtil.handleAlert(driver);
    }
    
    public void clickImport() {
        WebDriverUtil.clickElement(driver, importBtn);
        WebDriverUtil.passedTestSteps(driver, "Import", true);
    }
    
    public void clickValidate() {
        WebDriverUtil.clickElement(driver, validateBtn);
        WebDriverUtil.passedTestSteps(driver, "Validate", true);
    }
    
    public void clickSubmitButton() {
        WebDriverUtil.clickElement(driver, submitButton);
        WebDriverUtil.passedTestSteps(driver, "Submitted", true);
    }
}