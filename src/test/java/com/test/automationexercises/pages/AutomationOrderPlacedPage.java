package com.test.automationexercises.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationOrderPlacedPage {
    public AutomationOrderPlacedPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Download Invoice']")
    WebElement downloadInvoice;
    @FindBy(xpath = "//a[.='Continue']")
    WebElement continueButton;

    public void downloadInvoice(){
        downloadInvoice.click();
    }
    public void clickContinue(){
        continueButton.click();
    }
}
