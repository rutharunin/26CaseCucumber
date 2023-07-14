package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationContactUsPage {
    public AutomationContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[.='Get In Touch']")
    WebElement getInTouchHeader;
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameBox;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailBox;
    @FindBy(xpath = "//input[@name='subject']")
    WebElement subjectBox;
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement messageBox;
    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadBox;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;
    @FindBy(xpath = "//span[.=' Home']")
    WebElement homeButton;

    public void validateHeader(String expected){
        Assert.assertEquals(expected, BrowserUtils.getText(getInTouchHeader));
    }
    public void fillInfo(String name,String email,String subject,String message){
        nameBox.sendKeys(name);
        emailBox.sendKeys(email);
        subjectBox.sendKeys(subject);
        messageBox.sendKeys(message);
    }
    public void uploadFile(String uploadFile,WebDriver driver){
        BrowserUtils.scrollIntoView(driver,uploadBox);
        uploadBox.sendKeys(uploadFile);
        submitButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void validateSuccessMessage(String expected,WebDriver driver) {
        BrowserUtils.scrollIntoView(driver,successMessage);
        Assert.assertEquals(expected,BrowserUtils.getText(successMessage));
    }
    public void clickHome(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,homeButton);
        homeButton.click();
        driver.navigate().refresh();
    }
}
