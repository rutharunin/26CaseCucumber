package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationCheckoutPage;
import com.test.automationexercises.pages.AutomationOrderPlacedPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class DownloadInvoiceStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationCheckoutPage automationCheckoutPage=new AutomationCheckoutPage(driver);
    AutomationOrderPlacedPage automationOrderPlacedPage=new AutomationOrderPlacedPage(driver);

    @When("User verifies that the order in cart matches what was added in the beginning")
    public void user_verifies_that_the_order_in_cart_matches_what_was_added_in_the_beginning() {
        automationCheckoutPage.validateAddedAndProductInCart(driver);
    }
    @Then("User clicks Download Invoice button and verifies invoice is downloaded successfully")
    public void user_clicks_download_invoice_button_and_verifies_invoice_is_downloaded_successfully() {
        automationOrderPlacedPage.downloadInvoice();
    }
    @Then("User clicks continue")
    public void user_clicks_continue() {
        automationOrderPlacedPage.clickContinue();
    }
}
