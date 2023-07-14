package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationMemberPage;
import com.test.automationexercises.pages.AutomationSignupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LogoutAndDeleteAccountStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationMemberPage automationMemberPage=new AutomationMemberPage(driver);
    AutomationSignupPage automationSignupPage=new AutomationSignupPage(driver);

    @When("User clicks Logout button and validates signup and login messages {string} {string} visible")
    public void user_clicks_logout_button_and_validates_signup_and_login_messages_visible(String signup, String login) {
        automationMemberPage.logout();
        automationSignupPage.validateSignupLoginMessage(signup,login);
    }
    @Then("User clicks Delete Account button and validates {string} is visible")
    public void user_clicks_delete_account_button_and_validates_is_visible(String deleteMessage) throws InterruptedException {
        automationMemberPage.validateDeleteAccount(deleteMessage,driver);
        automationMemberPage.lastClick();
    }

}
