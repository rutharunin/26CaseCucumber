package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AutomationMen_TShirtPage {
    public AutomationMen_TShirtPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='single-products']/div/p")
    List<WebElement> productNames;
    public void ValidateProductName(String opt1,String opt2,String opt3){
        for (WebElement name:productNames){
            BrowserUtils.getText(name).toLowerCase();
            Assert.assertTrue(BrowserUtils.getText(name).toLowerCase().contains(opt1)||
                    BrowserUtils.getText(name).toLowerCase().contains(opt2)||
                    BrowserUtils.getText(name).toLowerCase().contains(opt3));
        }
    }
}
