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

public class AutomationWomen_TopPage {
    public AutomationWomen_TopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[.='Women - Tops Products']")
    WebElement header;
    @FindBy(xpath = "//div[@class='single-products']/div/p")
    List<WebElement> productNames;
    @FindBy(xpath = "//h4/a[@href='#Men']")
    WebElement categoryMen;
    @FindBy(xpath = "//div[@id='Men']//a[.='Tshirts ']")
    WebElement categoryTShirts;
    public void validateHeader(String header){
        Assert.assertEquals(header, BrowserUtils.getText(this.header));
    }
    public void validateProductNames(String expected){
        for (WebElement name:productNames){
            Assert.assertTrue(BrowserUtils.getText(name).toLowerCase().contains(expected));
        }
    }
    public void clickMen_TShirt(WebDriver driver) throws InterruptedException {
        categoryMen.click();
        categoryTShirts.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(categoryMen));
        categoryMen.click();
        categoryTShirts.click();
    }
}
