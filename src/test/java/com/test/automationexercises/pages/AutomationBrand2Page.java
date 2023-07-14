package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationBrand2Page {
    public AutomationBrand2Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='brands_products']//li[2]/a")
    WebElement brand2FromTop;
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement mainHeader;
    @FindBy(xpath = "//div[@class='brands_products']//li[4]/a")
    WebElement brand4FromTop;

    public void validateHeader(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,brand2FromTop);
        Assert.assertTrue(BrowserUtils.getText(mainHeader).toLowerCase().contains(BrowserUtils.getText(brand2FromTop).toLowerCase().substring(4)));
    }
    public void clickBrand4FromTop(){
        brand4FromTop.click();
    }
}
