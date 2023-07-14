package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ScrollDownAndUpFirstStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);

    @Given("User Scrolls down page to bottom ans verifies header {string} is visible")
    public void user_scrolls_down_page_to_bottom_ans_verifies_header_is_visible(String footer) {
        automationHomePage.scrollDownToSubscription(driver);
        automationHomePage.validateFooter(footer);
    }
    @When("User clicks the arrow at bottom right side to move upward")
    public void user_clicks_the_arrow_at_bottom_right_side_to_move_upward() {
        automationHomePage.scrollUpWithArrow();
    }
    @Then("User verifies that page is scrolled up and {string} text is visible on screen")
    public void user_verifies_that_page_is_scrolled_up_and_text_is_visible_on_screen(String header) {
        automationHomePage.validateHeader(header);
    }
}
