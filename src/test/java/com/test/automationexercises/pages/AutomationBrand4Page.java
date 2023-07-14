package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationBrand4Page {
    public AutomationBrand4Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement mainHeader;
    @FindBy(xpath = "//div[@class='brands_products']//li[4]/a")
    WebElement brand4FromTop;

    public void validateHeader(){
        Assert.assertTrue(BrowserUtils.getText(mainHeader).contains(BrowserUtils.getText(brand4FromTop).toUpperCase().substring(4)));
    }
}
