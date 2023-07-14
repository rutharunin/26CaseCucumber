package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class NavigationHappyTestCasePageStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    @Then("User clicks Test Cases button and Verifies user arrives on the page that the header reads {string}")
    public void user_clicks_test_cases_button_and_verifies_user_arrives_on_the_page_that_the_header_reads(String testCaseHeader) throws InterruptedException {
        automationHomePage.ValidateTestCaseHeader(driver,testCaseHeader);
    }

}
