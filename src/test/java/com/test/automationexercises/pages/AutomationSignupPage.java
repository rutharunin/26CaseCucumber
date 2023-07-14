package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.time.Duration;

public class AutomationSignupPage {
    public AutomationSignupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//i[@class='fa fa-lock']")
    WebElement loginButton;
    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement signupMessage;
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameBox;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailBox;
    @FindBy(xpath = "//button[.='Signup']")
    WebElement signupButton;
    @FindBy(xpath = "//h2[.='Login to your account']")
    WebElement loginMessage;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmailBox;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPasswordBox;
    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButtonInLoginPage;
    @FindBy(xpath = "//p[@style='color: red;']")
    WebElement errorMessage;
    public void validateSignupLoginMessage(String signupMessage,String loginMessage){
        loginButton.click();
        Assert.assertEquals(signupMessage, BrowserUtils.getText(this.signupMessage));
        Assert.assertEquals(loginMessage,BrowserUtils.getText(this.loginMessage));
    }
    public void fillSignupInfo(WebDriver driver,String myName,String myEmail) throws InterruptedException {
        Thread.sleep(1000);
        nameBox.sendKeys(myName);
        emailBox.sendKeys(myEmail);
        signupButton.click();
    }
    public void fillLoginInfo(String email){
        loginEmailBox.sendKeys(email);
        loginPasswordBox.sendKeys(ConfigReader.readProperty("automationsigninpassword"));
        loginButtonInLoginPage.click();
    }
    public void validateErrorMessage(String errorMessage){
        Assert.assertEquals(errorMessage,BrowserUtils.getText(this.errorMessage));
    }

}
