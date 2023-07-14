package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationAllProductPage;
import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ProductDetailHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationAllProductPage automationAllProductPage=new AutomationAllProductPage(driver);

    @Given("User clicks Products button and verifies user navigates to a page containing {string} in its title")
    public void user_clicks_products_button_and_verifies_user_navigates_to_a_page_containing_in_its_title(String string) throws InterruptedException {
        automationHomePage.navigateToProductPage(driver);
        automationAllProductPage.validateTitleProductPage(string,driver);
    }
    //Not sure how to do it.
//    @Given("User verifies that product list is visible")
//    public void user_verifies_that_product_list_is_visible() {
//
//    }
    @When("User clicks View Product button of first product and user navigates to a page containing {string} in its title")
    public void user_clicks_view_product_button_of_first_product_and_user_navigates_to_a_page_containing_in_its_title(String string) {
        automationAllProductPage.validateTitleProductDetails(string,driver);
    }
    @Then("User Verifies that the following details are visible: product name??? How, {string}, price {string}, {string}, {string}, {string}")
    public void user_verifies_that_the_following_details_are_visible_product_name_how_price(String category, String price, String availability, String condition, String brand) {
        automationAllProductPage.validateTypesOfDetail(category,price,availability,condition,brand);
    }

}
