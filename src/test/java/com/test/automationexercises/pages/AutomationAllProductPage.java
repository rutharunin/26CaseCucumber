package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AutomationAllProductPage {
    public AutomationAllProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement viewFirstProductLink;
    @FindBy(xpath = "//p[contains(text(),'Category')]")
    WebElement categoryAttribute;
    @FindBy(xpath = "//span[contains(text(),'Rs.')]")
    WebElement priceAttribute;
    @FindBy(xpath = "//b[contains(text(),'Availability')]")
    WebElement availabilityAttribute;
    @FindBy(xpath = "//b[.='Condition:']")
    WebElement conditionAttribute;
    @FindBy(xpath = "//b[.='Brand:']")
    WebElement brandAttribute;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]")
    WebElement product1;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[2]")
    WebElement product2;
    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    WebElement addProduct1ToCart;
    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
    WebElement addProduct2ToCart;
    @FindBy(xpath = "//button[.='Continue Shopping']")
    WebElement continueShoppingButton;
    @FindBy(xpath = "//u[.='View Cart']")
    WebElement viewCartButton;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]//p")
    WebElement somethingToScrollTo;
    public static String prod1N;
    public static String prod2N;
    public static String prod1P;
    public static String prod2P;
     WebElement product1Name;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[1]//h2")
    WebElement product1Price;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[2]//p")
    WebElement product2Name;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[2]//h2")
    WebElement product2Price;

    @FindBy(xpath = "//h2[.='Brands']")
    WebElement headerBrands;
    @FindBy(xpath = "//div[@class='brands_products']//li[2]/a")
    WebElement brand2FromTop;
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchBox;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchButton;
    @FindBy(xpath = "(//div[@class='product-image-wrapper'])[7]//ul//a")
    WebElement viewProduct7;

    public void validateTitleProductPage(String expectedContainedName,WebDriver driver){
        Assert.assertTrue(driver.getTitle().contains(expectedContainedName));
    }
    public void validateTitleProductDetails(String partOfTitle,WebDriver driver){
        BrowserUtils.scrollIntoView(driver,viewFirstProductLink);
        viewFirstProductLink.click();
        Assert.assertTrue(driver.getTitle().contains(partOfTitle));
    }
    public void validateTypesOfDetail(String category,String price,String availability,String condition,String brand){
        Assert.assertTrue(BrowserUtils.getText(categoryAttribute).contains(category)
                && BrowserUtils.getText(priceAttribute).contains(price)
                && BrowserUtils.getText(availabilityAttribute).contains(availability)
                && BrowserUtils.getText(conditionAttribute).contains(condition)
                && BrowserUtils.getText(brandAttribute).contains(brand));
    }
    public void addFirstProduct(WebDriver driver) {
        BrowserUtils.scrollIntoView(driver,product1Price);
         Actions actions=new Actions(driver);
        actions.moveToElement(product1Name).perform();

//        prod1N=product1Name.getText();
//        prod2N=product2Name.getText();
//        prod1P=product1Price.getText();
//        prod2P=product2Price.getText();
        addProduct1ToCart.click();
        continueShoppingButton.click();
    }
    public void addSecondProduct(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(product2).perform();
        addProduct2ToCart.click();
        continueShoppingButton.click();
        addProduct2ToCart.click();
        viewCartButton.click();
    }
    public void iniTwoProductAdded(){
        prod1N=product1Name.getText();
        prod2N=product2Name.getText();
        prod1P=product1Price.getText();
        prod2P=product2Price.getText();
    }
//    public void validateAllIntendedAddedProducts() {
//        List<String>allAdded=Arrays.asList(prod1N,prod2N,prod1P,prod2P);
//        viewCartButton.click();
//        List<WebElement>allInShoppingCart=Arrays.asList(product1NameInCart,product2NameInCart,product1PriceInCart,product2PriceInCart);
//        for (int i=0; i<allAdded.size();i++){
//            Assert.assertEquals(allAdded.get(i),BrowserUtils.getText(allInShoppingCart.get(i)));
//        }
//    }
    public void addProductAndValidateCartPage(WebDriver driver) {
        BrowserUtils.scrollIntoView(driver,somethingToScrollTo);
        Actions actions=new Actions(driver);
        actions.moveToElement(product1).perform();
        addProduct1ToCart.click();
        viewCartButton.click();
    }
    public void validateBrandsHeader(WebDriver driver,String expectedHeader){
        BrowserUtils.scrollIntoView(driver,headerBrands);
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(headerBrands));
    }
    public void clickBrand2FromTop(WebDriver driver) throws InterruptedException {
        brand2FromTop.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        brand2FromTop.click();
    }
    public void searchProduct(String keyword){
        searchBox.sendKeys(keyword);
        searchButton.click();
    }
    public void viewProduct7(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,viewProduct7);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(viewProduct7));
        viewProduct7.click();
    }
}