package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SubscriptionHomePageHappyStepDef {

    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);

    @When("user Scrolls down to footer and verifies that text {string} is visible")
    public void user_scrolls_down_to_footer_and_verifies_that_text_is_visible(String expectedFooter) {
        automationHomePage.validateSubscriptionFooter(driver,expectedFooter);
    }
    @Then("User enters email address {string} in input and click arrow button")
    public void user_enters_email_address_in_input_and_click_arrow_button(String email) {
        automationHomePage.inputEmail(email);
    }
    @Then("User verifies that success message {string} is visible")
    public void user_verifies_that_success_message_is_visible(String expectedSuccessfulSubscriptionMessage) {
        automationHomePage.validateHomePageSubscription(expectedSuccessfulSubscriptionMessage);
    }
}
