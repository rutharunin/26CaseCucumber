package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationAllProductPage;
import com.test.automationexercises.pages.AutomationHomePage;
import com.test.automationexercises.pages.AutomationSearchPage;
import com.test.automationexercises.pages.AutomationShoppingCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchAddAndLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationAllProductPage automationAllProductPage=new AutomationAllProductPage(driver);
    AutomationSearchPage automationSearchPage=new AutomationSearchPage(driver);
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationShoppingCartPage automationShoppingCartPage=new AutomationShoppingCartPage(driver);

    @When("User enters text {string} in search input and click search button")
    public void user_enters_text_in_search_input_and_click_search_button(String keyword) {
        automationAllProductPage.searchProduct(keyword);
    }
    @When("User verifies that the header reads {string} and that all products headers contains the word {string}")
    public void user_verifies_that_the_header_reads_and_that_all_products_headers_contains_the_word(String header, String searchResult) {
        automationSearchPage.validateHeader(header);
        automationSearchPage.validateSearchName(searchResult);
    }
    @When("User adds all products to the cart and verifies that all added products are in the cart")
    public void user_adds_all_products_to_the_cart_and_verifies_that_all_added_products_are_in_the_cart() {
        automationSearchPage.addAllToCart(driver);
        automationSearchPage.validateAddedItemsInCart();
    }

    @Then("User clicks cart button and confirms that all products name in cart contains the word {string}")
    public void user_clicks_cart_button_and_confirms_that_all_products_name_in_cart_contains_the_word(String searchKeyWord) {
        automationHomePage.clickShoppingCartIcon();
        automationShoppingCartPage.validateShoppingCartOnceMore(searchKeyWord);
    }
}
