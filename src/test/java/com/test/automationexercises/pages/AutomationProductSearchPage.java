package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AutomationProductSearchPage {
    public AutomationProductSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchBox;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchButton;
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement header; //search products
    @FindBy(xpath = "//div[@class='productInfo text-center']//p")
    List<WebElement> allSearchedProducts;
    public void searchProduct(String keyword){
        searchBox.sendKeys(keyword);
        searchButton.click();
    }
    public void validateHeader(String expected){
        Assert.assertEquals(BrowserUtils.getText(header),expected);
    }
    public void validateSearchKeyword(String keyword){
        for (WebElement productName:allSearchedProducts){
            Assert.assertTrue(BrowserUtils.getText(productName).contains(keyword));
        }
    }
}
