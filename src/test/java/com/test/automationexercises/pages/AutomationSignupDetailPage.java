package com.test.automationexercises.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AutomationSignupDetailPage {
    public AutomationSignupDetailPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//b[.='Enter Account Information']")
    WebElement signUpHeader;
    @FindBy(xpath = "//div[@class='radio']//input")
    List<WebElement>genders;
    @FindBy(xpath = "//input[@id='name']")
    WebElement userNameBox;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailBox;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordBox;
    @FindBy(xpath = "//select[@id='days']")
    WebElement days;
    @FindBy(xpath = "//select[@id='months']")
    WebElement months;
    @FindBy(xpath = "//select[@id='years']")
    WebElement years;
    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsLetter;
    @FindBy(xpath = "//input[@id='optin']")
    WebElement offer;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstNameBox;
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastNameBox;
    @FindBy(xpath = "//input[@id='company']")
    WebElement companyBox;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement address1Box;
    @FindBy(xpath = "//input[@id='address2']")
    WebElement address2Box;
    @FindBy(xpath = "//select[@id='country']")
    WebElement countryBox;
    @FindBy(xpath = "//input[@id='state']")
    WebElement stateBox;
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityBox;
    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipBox;
    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement phoneNumberBox;
    @FindBy(xpath = "//button[.='Create Account']")
    WebElement createAccountButton;
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement accountCreatedHeader;

    public void ValidateSignupMessage(String header){
        Assert.assertEquals(header,BrowserUtils.getText(signUpHeader));
    }
    public void fillAccount1(String myGender, String password, String day, String month, String year){
        for (WebElement sex:genders){
            if (sex.getAttribute("value").equals(myGender))sex.click();
        }
        passwordBox.clear();
        passwordBox.sendKeys(password);
        BrowserUtils.selectBy(days,day,"text");
        BrowserUtils.selectBy(months,month,"text");
        BrowserUtils.selectBy(years,year,"text");
    }
    public void fillAccount2(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        BrowserUtils.scrollIntoView(driver,newsLetter);
        newsLetter.click();
        offer.click();
    }
    public void fillAccount3(String name,String lastName,String company, String add1, String add2,String country, String state, String city, String zip, String phone){
        firstNameBox.sendKeys(name);
        lastNameBox.sendKeys(lastName);
        companyBox.sendKeys(company);
        address1Box.sendKeys(add1);
        address2Box.sendKeys(add2);
        BrowserUtils.selectBy(countryBox, country,"text");
        stateBox.sendKeys(state);
        cityBox.sendKeys(city);
        zipBox.sendKeys(zip);
        phoneNumberBox.sendKeys(phone);
    }
    public void validateCreationOfAccount(String header,WebDriver driver){
        BrowserUtils.scrollIntoView(driver,createAccountButton);
        createAccountButton.click();
        Assert.assertEquals(header,BrowserUtils.getText(accountCreatedHeader));

    }

}
