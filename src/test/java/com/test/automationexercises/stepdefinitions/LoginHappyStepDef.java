package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationMemberPage;
import com.test.automationexercises.pages.AutomationSignupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationSignupPage automationSignupPage=new AutomationSignupPage(driver);
    AutomationMemberPage automationMemberPage=new AutomationMemberPage(driver);

    @When("User provides email address {string} and password and clicks Login button")
    public void user_provides_email_address_and_password_and_clicks_login_button(String email) {
        automationSignupPage.fillLoginInfo(email);
    }

    @Then("User validates Logged in as {string} is visible")
    public void user_validates_logged_in_as_is_visible(String string) {
        automationMemberPage.validateLogin(string);
    }
}
