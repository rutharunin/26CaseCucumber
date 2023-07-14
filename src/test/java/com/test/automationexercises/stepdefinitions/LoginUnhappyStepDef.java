package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationSignupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginUnhappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationSignupPage automationSignupPage=new AutomationSignupPage(driver);

    @When("User provides incorrect email address {string} and password and clicks login button")
    public void user_provides_incorrect_email_address_and_password_and_clicks_login_button(String wrongEmail) {
        automationSignupPage.fillLoginInfo(wrongEmail);
    }
    @Then("User Verifies login error {string} is visible")
    public void user_verifies_login_error_is_visible(String errorMessage) {
        automationSignupPage.validateErrorMessage(errorMessage);
    }
}
