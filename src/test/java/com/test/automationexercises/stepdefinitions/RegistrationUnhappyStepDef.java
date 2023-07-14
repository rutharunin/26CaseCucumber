package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationSignupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class RegistrationUnhappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationSignupPage automationSignupPage=new AutomationSignupPage(driver);

    @When("User provides username {string} and existing email address {string} and clicks sign up button")
    public void user_provides_username_and_existing_email_address_and_clicks_sign_up_button(String name, String email) throws InterruptedException {
        automationSignupPage.fillSignupInfo(driver,name,email);
    }
    @Then("User Verifies sign-in error with {string} is visible")
    public void user_verifies_sign_in_error_with_is_visible(String errorMessage) {
        automationSignupPage.validateErrorMessage(errorMessage);
    }
}
