package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutomationSearchPage {
    public AutomationSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement header;
    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    List<WebElement>searchResultNames;
    @FindBy(xpath = "//div[@class='productinfo text-center']")
    List<WebElement>targetSearch;
    @FindBy(xpath = "//div[@class='productinfo text-center']/a")
    List<WebElement>searchResultAddToCart;
    @FindBy(xpath = "//button[.='Continue Shopping']")
    WebElement continueShoppingButton;
    @FindBy(xpath = "//a[.=' Cart']")
    WebElement shoppingCardIcon;
    @FindBy(xpath = "//td[@class='cart_description']//a")
    List<WebElement>listOfAddedInCart;

    public void validateHeader(String expectedHeader){
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(header));
    }
    public void validateSearchName(String searchResult){
        for (WebElement name:searchResultNames){
            Assert.assertTrue(BrowserUtils.getText(name).toLowerCase().contains(searchResult));
        }
    }
    public void addAllToCart(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,header);
        Actions actions=new Actions(driver);
        for (int i=0;i<searchResultAddToCart.size();i++){
            actions.moveToElement(targetSearch.get(i)).perform();
            searchResultAddToCart.get(i).click();
            continueShoppingButton.click();
        }
    }
    public void validateAddedItemsInCart(){
        List<String>listOfSearchName = new ArrayList<>();
        for (WebElement name:searchResultNames){
            listOfSearchName.add(BrowserUtils.getText(name));
        }
        shoppingCardIcon.click();
        for (int i=0;i<listOfSearchName.size();i++){
            Assert.assertEquals(listOfSearchName.get(i),BrowserUtils.getText(listOfAddedInCart.get(i)));
        }
    }
}
