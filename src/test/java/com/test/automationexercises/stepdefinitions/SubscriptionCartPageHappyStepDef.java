package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SubscriptionCartPageHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    @Given("User clicks shopping cart icon")
    public void user_clicks_shopping_cart_icon() {
        automationHomePage.clickShoppingCartIcon();
    }
}
