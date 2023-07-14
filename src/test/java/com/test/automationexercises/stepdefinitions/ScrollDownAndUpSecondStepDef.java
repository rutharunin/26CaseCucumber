package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ScrollDownAndUpSecondStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    @When("User scroll up to the top of the page")
    public void user_scroll_up_to_the_top_of_the_page() {
        automationHomePage.scrollUpToHeader(driver);
    }
}
