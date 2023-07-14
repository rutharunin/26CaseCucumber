package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class AutomationPaymentPage {
    public AutomationPaymentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@data-qa='pay-button']")
    WebElement payAndConfirm;
    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameBox;
    @FindBy(xpath = "//input[@name='card_number']")
    WebElement card;
    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvc;
    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement ex1;
    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement ex2;
    @FindBy(xpath = "//p[.='Congratulations! Your order has been confirmed!']")
    WebElement successMessage;
    public void fill(String name,String cardNumber,String cvc,String exp1,String exp2) throws InterruptedException {
        Thread.sleep(500);
        nameBox.sendKeys(name);
        card.sendKeys(cardNumber);
        this.cvc.sendKeys(cvc);
        ex1.sendKeys(exp1);
        ex2.sendKeys(exp2);
    }
    public void validatePayAndConfirm(String expectedMessage){
        payAndConfirm.click();
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(successMessage));
    }
}
