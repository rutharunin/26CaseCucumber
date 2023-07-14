package com.test.automationexercises.pages;

import io.cucumber.java.et.Ja;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://automationexercise.com");
        WebElement brandHeader=driver.findElement(By.xpath("//div[@class='brands_products']/h2"));
        BrowserUtils.scrollIntoView(driver,brandHeader);
        WebElement hAndM=driver.findElement(By.xpath("//div[@class='brands_products']//li[2]/a"));
        hAndM.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        WebElement header=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        hAndM=driver.findElement(By.xpath("//div[@class='brands_products']//li[2]/a"));
        System.out.println(header.getText());
        System.out.println("===================");
        System.out.println(hAndM.getText().substring(4));


//        WebElement prodLink=driver.findElement(By.xpath("//a[@href='/products']"));
//        prodLink.click();
//        driver.navigate().refresh();
//
//        prodLink=driver.findElement(By.xpath("//a[@href='/products']"));
//        prodLink.click();
//        AutomationAllProductPage automationAllProductPage=new AutomationAllProductPage(driver);
//        automationAllProductPage.iniTwoProductAdded();
//
//        automationAllProductPage.addFirstProduct(driver);
//        automationAllProductPage.addSecondProduct(driver);
//
//        List<String> allAdded= Arrays.asList(automationAllProductPage.prod1N,automationAllProductPage.prod2N,automationAllProductPage.prod1P,automationAllProductPage.prod2P);
//        automationAllProductPage.viewCartButton.click();
//        List<WebElement> allNamesInShoppingCart=driver.findElements(By.xpath("//a[contains(@href,'product_details')]"));
//        for (int i=0; i<allNamesInShoppingCart.size();i++){
//            System.out.println("inCart "+allNamesInShoppingCart.get(i).getText());
//            System.out.println("added "+allAdded.get(i));
//            Assert.assertEquals(allNamesInShoppingCart.get(i).getText(),allAdded.get(i));
//        }



//        AutomationShoppingCartPage automationShoppingCartPage=new AutomationShoppingCartPage(driver);
//        automationShoppingCartPage.validateAllIntendedProductAdded(driver);

//        driver.navigate().to("https://automationexercise.com/login");
//        WebElement loginEmailBox=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
//        WebElement loginPasswordBox=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
//        WebElement loginButtonInLoginPage=driver.findElement(By.xpath("//button[.='Login']"));
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(loginEmailBox));
//
//        loginEmailBox.sendKeys("emailaddress1@gmail.com");
//        loginPasswordBox.sendKeys("1234567");
//        loginButtonInLoginPage.click();
//        WebElement shoppingCart=driver.findElement(By.xpath("//a[.=' Cart']"));
//        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
//        shoppingCart.click();
//        WebElement processToCheckoutButton=driver.findElement(By.xpath("//a[.='Proceed To Checkout']"));
//        processToCheckoutButton.click();
//        String a="Mr. Russ Arunin";
//        String b="Hohoho";
//        String c="1234 N Heaven St";
//        String d="Apt 2";
//        String e="United States";
//        String f="Chicago";
//        String g=" IL";
//        String h=" 60000";
//        String i="1234567890";
//        String all=a+b+c+d+e+f+g+h+i;
//        System.out.println(all);
//        List<WebElement>address=driver.findElements(By.xpath("//ul[@id='address_delivery']//li"));
//
//        for (int j=1;j<address.size();j++) {
//            System.out.println(address.get(j).getText());
////            Assert.assertTrue(all.toLowerCase().contains(address.get(j).getText().trim().toLowerCase()));
//        }
    }
}
