package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationAllProductPage;
import com.test.automationexercises.pages.AutomationBrand2Page;
import com.test.automationexercises.pages.AutomationBrand4Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ProductBrandFunctionStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationAllProductPage automationAllProductPage=new AutomationAllProductPage(driver);
    AutomationBrand2Page automationBrand2Page=new AutomationBrand2Page(driver);
    AutomationBrand4Page automationBrand4Page=new AutomationBrand4Page(driver);

    @Given("User verifies that text, brands {string} is visible on left side bar")
    public void user_verifies_that_text_brands_is_visible_on_left_side_bar(String header) {
        automationAllProductPage.validateBrandsHeader(driver,header);
    }
    @When("User clicks the second brand from the top and verifies that the header of the next page contains the chosen name")
    public void user_clicks_the_second_brand_from_the_top_and_verifies_that_the_header_of_the_next_page_contains_the_chosen_name() throws InterruptedException {
        automationAllProductPage.clickBrand2FromTop(driver);
        automationBrand2Page.validateHeader(driver);
        automationBrand2Page.clickBrand4FromTop();
    }
    @Then("User clicks the fourth brand from the top and verifies that the header of the next page contains the chosen name")
    public void user_clicks_the_fourth_brand_from_the_top_and_verifies_that_the_header_of_the_next_page_contains_the_chosen_name() {
        automationBrand4Page.validateHeader();
    }
}
