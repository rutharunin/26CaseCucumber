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
import java.util.List;

public class AutomationCheckoutPage {
    public AutomationCheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[.='Review Your Order']")
    WebElement reviewHeader;
    @FindBy(xpath = "//ul[@id='address_delivery']//li")
    List<WebElement> address;
    @FindBy(tagName = "textarea")
    WebElement textArea;
    @FindBy(xpath = "//a[.='Place Order']")
    WebElement placeOrderButton;
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productButton;
    @FindBy(xpath = "//img[@src='/get_product_picture/1']//..//p")
    WebElement addedProduct;
    @FindBy(xpath = "//div[@class='shop-menu pull-right']//a[@href='/view_cart']")
    WebElement cartIcon;
    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement actualItemInCart;
    public String expected;
    @FindBy(xpath = "//a[.='Proceed To Checkout']")
    WebElement proceedToCheckout;

    public void validateReviewHeader(String expectedHeader){
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(reviewHeader));
    }
    public void validateAddress(String a,String b,String c,String d,String e,String f,String g,String h,String i){
        String allAddress=a+b+c+d+e+f+g+h+i;
        for (int j=1;j<address.size();j++){
            Assert.assertTrue(allAddress.toLowerCase().contains(address.get(j).getText().trim().toLowerCase()));
        }
    }
    public void enterTextAndPlaceOrder(WebDriver driver,String description){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textArea));
        BrowserUtils.scrollIntoView(driver,textArea);
        textArea.sendKeys(description);
        placeOrderButton.click();
    }
    public void validateAddedAndProductInCart(WebDriver driver){
        productButton.click();
        expected=BrowserUtils.getText(addedProduct);
        cartIcon.click();
        Assert.assertEquals(expected,BrowserUtils.getText(actualItemInCart));
        proceedToCheckout.click();
        BrowserUtils.scrollIntoView(driver,placeOrderButton);
    }
}
