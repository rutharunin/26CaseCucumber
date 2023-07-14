package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationAProductDetailPage {
    public AutomationAProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#quantity")
    WebElement quantityBox;
    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//u")
    WebElement viewCartButton;
    @FindBy(xpath = "//a[@href='#reviews']")
    WebElement writeReviewHeader;
    @FindBy(css = "#name")
    WebElement nameBox;
    @FindBy(css = "#email")
    WebElement emailBox;
    @FindBy(tagName = "textarea")
    WebElement messageArea;
    @FindBy(css = "#button-review")
    WebElement submitButton;
    @FindBy(xpath = "//span[.='Thank you for your review.']")
    WebElement reviewThankYouMessage;
    public void increaseQuantity(String quantity){
        while (!(Integer.parseInt(quantityBox.getAttribute("value"))==Integer.parseInt(quantity))){
            quantityBox.sendKeys(Keys.ARROW_UP);
        }
    }
    public void addToCartFromProductDetail(){
            addToCartButton.click();
    }
    public void clickViewCartButton(){
        viewCartButton.click();
    }
    public void validateWriteReviewHeader(String expected){
        Assert.assertEquals(expected,BrowserUtils.getText(writeReviewHeader));
    }
    public void enterReview(String name,String email,String message){
        nameBox.sendKeys(name);
        emailBox.sendKeys(email);
        messageArea.sendKeys(message);
        submitButton.click();
    }
    public void validateSuccessfulReview(String expected){
        Assert.assertEquals(expected,BrowserUtils.getText(reviewThankYouMessage));
    }
}
