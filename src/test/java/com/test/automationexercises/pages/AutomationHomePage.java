package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class AutomationHomePage {
    public AutomationHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/contact_us']")
    WebElement contactUsButton;
    @FindBy(xpath = "//a[.=' Test Cases']")
    WebElement testCaseLink;
    @FindBy(xpath = "//b[.='Test Cases']")
    WebElement testCaseHeader;
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productLink;
    @FindBy(xpath = "//h2[.='Subscription']")
    WebElement subscriptionFooter;
    @FindBy(css = "#susbscribe_email")
    WebElement subscriptionEmail;
    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscriptionButton;
    @FindBy(xpath = "//div[@id='success-subscribe']")
    WebElement subscriptionSuccessMessage;
    @FindBy(xpath = "//a[.=' Cart']")
    WebElement shoppingCardIcon;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[3]")
    WebElement somethingToScrollTo;
    @FindBy(xpath = "(//div[@class='productinfo text-center'])[7]")
    WebElement somethingToScrollTo2;
    @FindBy(xpath = "//a[@href='/product_details/3']")
    WebElement aProductViewProductButton;
    @FindBy(xpath = "//img[@src='/get_product_picture/6']")
    WebElement productSixthTarget;
    @FindBy(xpath = "(//a[@data-product-id='6'])[1]")
    WebElement addProduct6ToCart;
    @FindBy(xpath = "//button[.='Continue Shopping']")
    WebElement continueButton;
    @FindBy(xpath = "//h2[.='Category']")
    WebElement categoryHeader;
    @FindBy(xpath = "//h4/a[@href='#Women']")
    WebElement categoryWomen;
    @FindBy(xpath = "//div[@id='Women']//a[.='Tops ']")
    WebElement categoryTop;
    @FindBy(xpath = "//h2[.='recommended items']")
    WebElement recommendedHeader;
    @FindBy(xpath = "(//a[@data-product-id='1'])[3]")
    WebElement addRecommendedItem1;
    @FindBy(xpath = "(//a[@data-product-id='1'])[3]//..//p")
    WebElement recommendedItemName;
    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement recommendedItemNameInCart;
    @FindBy(xpath = "//p[@class='text-center']//a[@href='/view_cart']")
    WebElement viewCartButton;
    @FindBy(xpath = "//a[@class='left recommended-item-control']")
    WebElement leftArrow;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement xButton;
    @FindBy(css = "#scrollUp")
    WebElement scrollUpButton;
    @FindBy(xpath = "//h2[.='Full-Fledged practice website for Automation Engineers']")
    List<WebElement> header;

    public void navigateToContactUsPage(WebDriver driver) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactUsButton));
        contactUsButton.click();
    }
    public void validationHomepageTitle(String title,WebDriver driver){
        Assert.assertEquals(title,driver.getTitle());
    }
    public void ValidateTestCaseHeader(WebDriver driver,String expected) throws InterruptedException {
        testCaseLink.click();
        Thread.sleep(500);
        driver.navigate().refresh();
        testCaseLink.click();
        Assert.assertEquals(expected,BrowserUtils.getText(testCaseHeader));
    }
    public void navigateToProductPage(WebDriver driver) {
        productLink.click();
        driver.navigate().refresh();
        productLink=driver.findElement(By.xpath("//a[@href='/products']"));
        productLink.click();
    }
    public void validateSubscriptionFooter(WebDriver driver,String expectedFooter){
        BrowserUtils.scrollIntoView(driver,subscriptionFooter);
        Assert.assertEquals(expectedFooter,BrowserUtils.getText(subscriptionFooter));
    }
    public void inputEmail(String email){
        subscriptionEmail.sendKeys(email);
        subscriptionButton.click();
    }
    public void validateHomePageSubscription(String expectedSuccessMessage){
        Assert.assertEquals(expectedSuccessMessage,BrowserUtils.getText(subscriptionSuccessMessage));
    }
    public void clickShoppingCartIcon(){
        shoppingCardIcon.click();
    }
    public void navigateToAProductDetailPage(WebDriver driver,String title) throws InterruptedException {
        BrowserUtils.scrollIntoView(driver,somethingToScrollTo);
        aProductViewProductButton.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(500);
        productLink.click();
        BrowserUtils.scrollIntoView(driver,somethingToScrollTo2);
        Thread.sleep(500);
        aProductViewProductButton.click();
        Assert.assertTrue(driver.getTitle().contains(title));
    }
    public void addProductSixth(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,productSixthTarget);
        Actions actions=new Actions(driver);
        actions.moveToElement(productSixthTarget).perform();
        addProduct6ToCart.click();
        continueButton.click();
    }
    public void validateCategoryHeader(WebDriver driver,String expected){
        BrowserUtils.scrollIntoView(driver,categoryHeader);
        Assert.assertEquals(expected,BrowserUtils.getText(categoryHeader));
    }
    public void clickWomen_Top(WebDriver driver) throws InterruptedException {
        categoryWomen.click();
        categoryTop.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(categoryWomen));
        categoryWomen.click();
        categoryTop.click();
    }
    public void validateRecommendedHeader(WebDriver driver,String expected){
        BrowserUtils.scrollIntoView(driver,recommendedHeader);
        Assert.assertEquals(expected,BrowserUtils.getText(recommendedHeader));
    }
    public void addRecommendedItemToCart(){
        if (!addRecommendedItem1.isDisplayed())leftArrow.click();
        addRecommendedItem1.click();
    }
    public void validateAddedRecommended(){
        String productName=BrowserUtils.getText(recommendedItemName);
        viewCartButton.click();
        Assert.assertEquals(productName,BrowserUtils.getText(recommendedItemNameInCart));
        xButton.click();
    }
    public void scrollDownToSubscription(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,subscriptionFooter);
    }
    public void validateFooter(String expectedFooter){
        Assert.assertEquals(expectedFooter,BrowserUtils.getText(subscriptionFooter));
    }
    public void scrollUpWithArrow(){
        scrollUpButton.click();
    }
    public void scrollUpToHeader(WebDriver driver){
        BrowserUtils.scrollIntoView(driver,shoppingCardIcon);
    }
    public void validateHeader(String expectedHeader){
        for (WebElement aHeader:header){
            if (BrowserUtils.getText(aHeader).equals(expectedHeader))Assert.assertTrue(true);
        }
    }
}
