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
import java.util.Arrays;
import java.util.List;

import static com.test.automationexercises.pages.AutomationAllProductPage.*;

public class AutomationShoppingCartPage {
    public AutomationShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr[@id='product-1']//td")
    List<WebElement> firstProductDetails;
    @FindBy(xpath = "//tr[@id='product-2']//td")
    List<WebElement> secondProductDetails;
    @FindBy(xpath = "//li[.='Shopping Cart']")
    WebElement shoppingCartHeader;
    @FindBy(xpath = "//a[.='Proceed To Checkout']")
    WebElement processToCheckoutButton;
    @FindBy(xpath = "//u[.='Register / Login']")
    WebElement registerLoginButton;
    @FindBy(xpath = "//td[@class='cart_quantity']//button")
    WebElement quantityDisplay;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement deleteItem1InCart;
    @FindBy(xpath = "//a[@class='cart_quantity_delete' and @data-product-id='2']")
    WebElement deleteItem2InCart;
    @FindBy(xpath = "//a[@class='cart_quantity_delete' and @data-product-id='3']")
    WebElement deleteItem3InCart;
    @FindBy(xpath = "//ul//a[@href='/products']")
    WebElement productButton;
    @FindBy(xpath = "//img[@src='/get_product_picture/1']//..//p")
    WebElement addedProductName;
    @FindBy(xpath = "//a[@href='/view_cart' and contains(text(),' Cart')]")
    WebElement cartButton;
    @FindBy(xpath = "//h4//a")
    WebElement nameInCart;
    @FindBy(xpath = "//b[contains(text(),'empty')]")
    WebElement emptyCartMessage;
    @FindBy(xpath = "//td[@class='cart_description']//a")
    List<WebElement>listOfAddedInCart;

    @FindBy(xpath = "(//a[contains(@href,'product_details')])[1]")
    WebElement product1NameInCart;
    @FindBy(xpath = "(//td[@class='cart_price'])[1]//p")
    WebElement product1PriceInCart;
    @FindBy(xpath = "(//a[contains(@href,'product_details')])[2]")
    WebElement product2NameInCart;
    @FindBy(xpath = "(//td[@class='cart_price'])[2]")
    WebElement product2PriceInCart;
    public void validateShoppingCartHeader(String expectedHeader){
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(shoppingCartHeader));
    }
    public void clickCheckout() {
        processToCheckoutButton.click();
    }
    public void navigateToRegistrationPage(){
        registerLoginButton.click();
    }
    public void validateCalculationOfTotalPrice(){
        //total price=price x quantity >>> of product 1 and 2
        Assert.assertTrue((Integer.parseInt(firstProductDetails.get(4).getText().substring(4))==
                Integer.parseInt(firstProductDetails.get(2).getText().substring(4))*
                        Integer.parseInt(firstProductDetails.get(3).getText()))
                                                &&
                (Integer.parseInt(secondProductDetails.get(4).getText().substring(4))==
                        Integer.parseInt(secondProductDetails.get(2).getText().substring(4))*
                                Integer.parseInt(secondProductDetails.get(3).getText())));
    }
    public void validateQuantityInCart(String quantity){
        Assert.assertEquals(quantity,BrowserUtils.getText(quantityDisplay));
    }
    public void deleteItem1InCart(){
        deleteItem1InCart.click();
    }
    public void deleteItem2InCart(){
        deleteItem2InCart.click();
    }
    public void clearCartForOneItem(){
        deleteItem3InCart.click();
    }
    public void clickProductButton(WebDriver driver){
        productButton.click();
        driver.navigate().refresh();
        productButton=driver.findElement(By.xpath("//ul//a[@href='/products']"));
        productButton.click();
    }
    public void validateProductInTheCart(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,addedProductName);
        String nameAdded=BrowserUtils.getText(addedProductName);
        cartButton.click();
        Assert.assertEquals(nameAdded,BrowserUtils.getText(nameInCart));
    }
    public void validateEmptyCartMessage(String expected,WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        Assert.assertEquals(expected,emptyCartMessage.getText());
    }
    public void validateShoppingCartOnceMore(String keyword){
        for (WebElement addedProduct:listOfAddedInCart){
            Assert.assertTrue(BrowserUtils.getText(addedProduct).toLowerCase().contains(keyword));
        }
    }

    public void validateAllIntendedAddedProducts() {
        List<String>allAdded= Arrays.asList(prod1N,prod2N,prod1P,prod2P);
        List<WebElement>allInShoppingCart=Arrays.asList(product1NameInCart,product2NameInCart,product1PriceInCart,product2PriceInCart);
        for (int i=0; i<allAdded.size();i++){
            Assert.assertEquals(allAdded.get(i),BrowserUtils.getText(allInShoppingCart.get(i)));
        }
    }
}
