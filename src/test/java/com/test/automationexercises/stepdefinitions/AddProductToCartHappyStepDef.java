package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationAllProductPage;
import com.test.automationexercises.pages.AutomationHomePage;
import com.test.automationexercises.pages.AutomationShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;


public class AddProductToCartHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();

    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationAllProductPage automationAllProductPage=new AutomationAllProductPage(driver);
    AutomationShoppingCartPage automationShoppingCartPage=new AutomationShoppingCartPage(driver);

    @Given("User clicks Products button")
    public void user_clicks_products_button() {
        automationHomePage.navigateToProductPage(driver);
    }
    @When("User hovers over first product and clicks Add to cart and clicks Continue Shopping button")
    public void user_hovers_over_first_product_and_clicks_add_to_cart_and_clicks_continue_shopping_button() {
        automationAllProductPage.addFirstProduct(driver);
    }
    @When("User hovers over second product and clicks Add to cart")
    public void user_hovers_over_second_product_and_clicks_add_to_cart() {
        automationAllProductPage.addSecondProduct(driver);
    }
    @Then("User clicks View Cart button and verifies both products are added to Cart")
    public void user_clicks_view_cart_button_and_verifies_both_products_are_added_to_cart() {
        automationShoppingCartPage.validateAllIntendedAddedProducts();
    }
    @Then("User verifies their prices, quantity and total price")
    public void user_verifies_their_prices_quantity_and_total_price() {
        automationShoppingCartPage.validateCalculationOfTotalPrice();
    }
    @Then("User deletes products from the cart")
    public void user_deletes_products_from_the_cart() {
        automationShoppingCartPage.deleteItem1InCart();
        automationShoppingCartPage.deleteItem2InCart();
    }
}
