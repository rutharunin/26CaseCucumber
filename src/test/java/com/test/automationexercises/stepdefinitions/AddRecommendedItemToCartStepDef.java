package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddRecommendedItemToCartStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);

    @Given("User scrolls to bottom of page and verifies that header {string} is visible")
    public void user_scrolls_to_bottom_of_page_and_verifies_that_header_is_visible(String expectedHeader) {
        automationHomePage.validateRecommendedHeader(driver,expectedHeader);
    }
    @Given("User clicks Add To Cart button on the first product")
    public void user_clicks_add_to_cart_button_on_the_first_product() {
        automationHomePage.addRecommendedItemToCart();
    }
    @Then("User clicks View Cart button and verifies that product is displayed in cart page then empty the cart")
    public void user_clicks_view_cart_button_and_verifies_that_product_is_displayed_in_cart_page_then_empty_the_cart() {
        automationHomePage.validateAddedRecommended();
    }
}
