package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationContactUsPage;
import com.test.automationexercises.pages.AutomationHomePage;
import com.test.automationexercises.pages.AutomationMemberPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ContactHappyStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationContactUsPage automationContactUsPage=new AutomationContactUsPage(driver);
    @Given("User clicks Contact Us button and verifies {string} header")
    public void user_clicks_contact_us_button_and_verifies_header(String getInTouch) throws InterruptedException {
        automationHomePage.navigateToContactUsPage(driver);
        automationContactUsPage.validateHeader(getInTouch);
    }
    @When("User enters name {string},email {string},subject {string} and message {string}")
    public void user_enters_name_email_subject_and_message(String name, String email, String subject, String message) {
        automationContactUsPage.fillInfo(name,email,subject,message);
    }
    @When("User uploads file {string} and clicks submit button")
    public void user_uploads_file_and_clicks_submit_button(String string) {
        automationContactUsPage.uploadFile(string,driver);
    }
//    @Then("User clicks ok button and Verifies success message {string} is visible then clicks Home button")
//    public void user_clicks_ok_button_and_verifies_success_message_is_visible_then_clicks_home_button(String successMessage) {
//        automationContactUsPage.validateSuccessMessage(successMessage,driver);
//        automationContactUsPage.clickHome(driver);
//        automationContactUsPage.fillInfo("Bla bla bla","email@email.xxx","Greeting","YoYoYo");
//        automationContactUsPage.clickHome(driver);
//    }
    @Then("User clicks ok button and Verifies success message {string} is visible then clicks Home button and enters second time upload file {string}")
    public void user_clicks_ok_button_and_verifies_success_message_is_visible_then_clicks_home_button_and_enters_second_time_upload_file(String successMessage, String upload) {
        automationContactUsPage.validateSuccessMessage(successMessage,driver);
        automationContactUsPage.clickHome(driver);
        automationContactUsPage.fillInfo("Bla bla bla","email@email.xxx","Greeting","YoYoYo");
        automationContactUsPage.uploadFile(upload,driver);
        automationContactUsPage.clickHome(driver);
    }
    @Then("User and verifies that user navigates to home page that the title reads {string}")
    public void user_and_verifies_that_user_navigates_to_home_page_that_the_title_reads(String string) {
        automationHomePage.validationHomepageTitle(string, driver);
    }
}
