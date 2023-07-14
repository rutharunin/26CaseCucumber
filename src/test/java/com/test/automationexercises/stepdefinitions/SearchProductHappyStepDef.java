package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationProductSearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchProductHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationProductSearchPage automationProductSearchPage=new AutomationProductSearchPage(driver);

    @When("User enters product name {string} in search input and click search button")
    public void user_enters_product_name_in_search_input_and_click_search_button(String string) {
        automationProductSearchPage.searchProduct(string);
    }
    @Then("User Verifies header {string} is visible")
    public void user_verifies_header_is_visible(String string) {
        automationProductSearchPage.validateHeader(string);
    }
    @Then("User verifies that all the product name contains text {string} related to search")
    public void user_verifies_that_all_the_product_name_contains_text_related_to_search(String keyword) {
        automationProductSearchPage.validateSearchKeyword(keyword);
    }
}
