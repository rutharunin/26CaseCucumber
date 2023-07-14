package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationAProductDetailPage;
import com.test.automationexercises.pages.AutomationHomePage;
import com.test.automationexercises.pages.AutomationShoppingCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddQuantityOfProductHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationAProductDetailPage automationAProductDetailPage=new AutomationAProductDetailPage(driver);
    AutomationShoppingCartPage automationShoppingCartPage=new AutomationShoppingCartPage(driver);

    @When("User clicks View Product for any product on home page and verifies the page title contains {string}")
    public void user_clicks_view_product_for_any_product_on_home_page_and_verifies_the_page_title_contains(String title) throws InterruptedException {
        automationHomePage.navigateToAProductDetailPage(driver,title);
    }
    @When("User increases quantity to {string} and clicks Add to cart button")
    public void user_increases_quantity_to_and_clicks_add_to_cart_button(String quantity) {
        automationAProductDetailPage.increaseQuantity(quantity);
        automationAProductDetailPage.addToCartFromProductDetail();
    }
    @Then("User clicks View Cart button and verifies product is displayed with quantity of {string}")
    public void user_clicks_view_cart_button_and_verifies_product_is_displayed_with_quantity_of(String quantity) {
        automationAProductDetailPage.clickViewCartButton();
        automationShoppingCartPage.validateQuantityInCart(quantity);
    }
    @Then("User clears shopping cart")
    public void user_clears_shopping_cart() {
        automationShoppingCartPage.clearCartForOneItem();
    }
}
