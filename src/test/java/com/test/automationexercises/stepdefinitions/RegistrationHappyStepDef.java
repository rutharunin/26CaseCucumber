package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationMemberPage;
import com.test.automationexercises.pages.AutomationSignupDetailPage;
import com.test.automationexercises.pages.AutomationSignupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class RegistrationHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationSignupPage automationSignupPage=new AutomationSignupPage(driver);
    AutomationSignupDetailPage automationSignupDetailPage=new AutomationSignupDetailPage(driver);
    AutomationMemberPage automationMemberPage=new AutomationMemberPage(driver);

    @Given("User navigates to the AutomationExercise and validate the title {string}")
    public void user_navigates_to_the_automation_exercise_and_validate_the_title(String string) {
        Assert.assertEquals(string,driver.getTitle());
    }

    @When("User clicks signUp Login button and validates signup and login messages {string} {string} is visible")
    public void user_clicks_sign_up_login_button_and_validates_signup_and_login_messages_is_visible(String signupMessage, String loginMessage) {
        automationSignupPage.validateSignupLoginMessage(signupMessage,loginMessage);
}
    @When("User provides username {string} and email address {string} and clicks sign up button")
    public void user_provides_username_and_email_address_and_clicks_sign_up_button(String name, String email) throws InterruptedException {
    automationSignupPage.fillSignupInfo(driver,name,email);
    }
    @When("User verifies {string} message is visible")
    public void user_verifies_message_is_visible(String string) {
    automationSignupDetailPage.ValidateSignupMessage(string);
    }

//    @When("User provides title {string}, name {string}, email, {string}, password, date of birth {string}, {string}, {string}")
//    public void user_provides_title_name_email_password_date_of_birth(String gender, String userName, String email, String day, String month, String year) {
//        automationSignupDetailPage.fillAccount1(gender,userName,email,ConfigReader.readProperty("automationsigninpassword"),day,month,year);
//    }
    @When("User provides title {string}, password, date of birth {string},{string},{string}")
    public void user_provides_title_password_date_of_birth(String male, String day, String month, String year) {
        automationSignupDetailPage.fillAccount1(male,ConfigReader.readProperty("automationsigninpassword"),day,month,year);
    }

    @When("User selects Sign up for our newsletter! and Receive special offers from our partners!")
    public void user_selects_sign_up_for_our_newsletter_and_receive_special_offers_from_our_partners() throws InterruptedException {
        automationSignupDetailPage.fillAccount2(driver);
    }

    @When("User provides {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_provides(String firstNm, String lastNm, String comp, String add1, String add2, String country, String state, String city, String zip, String phoneNo) {
        automationSignupDetailPage.fillAccount3(firstNm,lastNm,comp,add1,add2,country,state,city,zip,phoneNo);
    }

    @Then("User click Create Account button and validates {string}")
    public void user_click_create_account_button_and_validates(String header) {
        automationSignupDetailPage.validateCreationOfAccount(header,driver);

    }
    @Then("User clicks Continue Button and validates logged in as username {string}")
    public void user_clicks_continue_button_and_validates_logged_in_as_username(String string) throws InterruptedException {
        automationMemberPage.validateLoginName(string,driver);
    }
}
