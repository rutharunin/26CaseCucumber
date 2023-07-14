package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import com.test.automationexercises.pages.AutomationShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class RemoveProductStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationShoppingCartPage automationShoppingCartPage=new AutomationShoppingCartPage(driver);

    @Given("User hovers over the sixth product from the top and clicks Add to cart then clicks continue button")
    public void user_hovers_over_the_sixth_product_from_the_top_and_clicks_add_to_cart_then_clicks_continue_button() {
        automationHomePage.addProductSixth(driver);

    }
    @Given("User clicks cart button and verifies that User arrives at page whose header reads, {string}")
    public void user_clicks_cart_button_and_verifies_that_user_arrives_at_page_whose_header_reads(String expectedHeader) {
        automationHomePage.clickShoppingCartIcon();
        automationShoppingCartPage.validateShoppingCartHeader(expectedHeader);
    }
    @Then("User clicks x button and verifies that User arrives at a page whose header contains text,{string}")
    public void user_clicks_x_button_and_verifies_that_user_arrives_at_a_page_whose_header_contains_text(String expectedEmptyCartMessage) {
        automationShoppingCartPage.deleteItem1InCart();
        automationShoppingCartPage.validateEmptyCartMessage(expectedEmptyCartMessage,driver);
    }
}
