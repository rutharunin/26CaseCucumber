package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationAProductDetailPage;
import com.test.automationexercises.pages.AutomationAllProductPage;
import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class AddReviewHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationAllProductPage automationAllProductPage=new AutomationAllProductPage(driver);
    AutomationAProductDetailPage automationAProductDetailPage=new AutomationAProductDetailPage(driver);

    @Given("User clicks View Product button of item seven from top and verifies header {string} is visible")
    public void user_clicks_view_product_button_of_item_seven_from_top_and_verifies_header_is_visible(String header) {
        automationHomePage.navigateToProductPage(driver);
        automationAllProductPage.viewProduct7(driver);
        automationAProductDetailPage.validateWriteReviewHeader(header);
    }
    @When("User enters name {string} email address {string} message {string} and click submit button")
    public void user_enters_name_email_address_message_and_click_submit_button(String name, String email, String message) {
        automationAProductDetailPage.enterReview(name,email,message);
    }
    @Then("User verifies success message {string}")
    public void user_verifies_success_message(String successfulMessage) {
        automationAProductDetailPage.validateSuccessfulReview(successfulMessage);
    }
}
