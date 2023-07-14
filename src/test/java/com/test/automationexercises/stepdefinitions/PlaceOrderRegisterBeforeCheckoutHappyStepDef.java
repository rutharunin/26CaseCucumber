package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationShoppingCartPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class PlaceOrderRegisterBeforeCheckoutHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationShoppingCartPage automationShoppingCartPage=new AutomationShoppingCartPage(driver);

    @When("User verifies that the item is in the cart")
    public void user_verifies_that_the_item_is_in_the_cart() {
        automationShoppingCartPage.clickProductButton(driver);
        automationShoppingCartPage.validateProductInTheCart(driver);
    }
    @When("User clicks Proceed to Checkout")
    public void user_clicks_proceed_to_checkout() throws InterruptedException {
        automationShoppingCartPage.clickCheckout();
    }
}
