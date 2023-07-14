package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class AutomationMemberPage {
    public AutomationMemberPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;
    @FindBy(xpath = "//div[@id='dismiss-button']")
    WebElement dismissButton;
    @FindBy(xpath = "//i[@class='fa fa-user']/following-sibling::b")
    WebElement loginName;
    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement deleteAccountButton;
    @FindBy(xpath = "//b[.='Account Deleted!']")
    WebElement accountDeleteMessage;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement lastClick;

    @FindBy(xpath = "//iframe[@id='aswift_6']")
    WebElement adFrame0;
    @FindBy(xpath = "//iframe[@id='ad_iframe' and @title='Advertisement']")
    WebElement adFrame1;
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productButton;
    @FindBy(xpath = "//i[@class='fa fa-lock']")
    WebElement logoutButton;

    public void validateLoginName(String expected, WebDriver driver) throws InterruptedException {
        continueButton.click();
        driver.navigate().refresh();
        Thread.sleep(1000);
        continueButton=driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();
        Assert.assertEquals(expected, BrowserUtils.getText(loginName));
    }
    public void validateDeleteAccount(String expected, WebDriver driver) {
        productButton.click();
        driver.navigate().refresh();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        deleteAccountButton=wait.until(ExpectedConditions.visibilityOf(deleteAccountButton));
        deleteAccountButton.click();
        Assert.assertEquals(expected, BrowserUtils.getText(accountDeleteMessage));
    }
    public void lastClick(){
        lastClick.click();
    }
    public void validateLogin(String message){
        Assert.assertEquals(message,BrowserUtils.getText(loginName));
    }
    public void logout(){
        logoutButton.click();
    }
}
