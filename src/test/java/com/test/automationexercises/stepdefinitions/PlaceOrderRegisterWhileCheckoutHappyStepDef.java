package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class PlaceOrderRegisterWhileCheckoutHappyStepDef {

    WebDriver driver= DriverHelper.getDriver();
    AutomationAllProductPage automationAllProductPage=new AutomationAllProductPage(driver);
    AutomationShoppingCartPage automationShoppingCartPage=new AutomationShoppingCartPage(driver);
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationCheckoutPage automationCheckoutPage=new AutomationCheckoutPage(driver);
    AutomationPaymentPage automationPaymentPage=new AutomationPaymentPage(driver);
    @When("User hovers over a product and click Add to cart and clicks View Cart button and verifies that the page has header reads {string}")
    public void user_hovers_over_a_product_and_click_add_to_cart_and_clicks_view_cart_button_and_verifies_that_the_page_has_header_reads(String string) {
        automationAllProductPage.addProductAndValidateCartPage(driver);
        automationShoppingCartPage.validateShoppingCartHeader(string);
    }
    @When("User clicks Proceed To Checkout and clicks Register-Login button")
    public void user_clicks_proceed_to_checkout_and_clicks_register_login_button() {
        automationShoppingCartPage.clickCheckout();
        automationShoppingCartPage.navigateToRegistrationPage();
    }
    @When("User clicks Cart button and clicks Proceed To Checkout button")
    public void user_clicks_cart_button_and_clicks_proceed_to_checkout_button() {
        automationHomePage.clickShoppingCartIcon();
        automationShoppingCartPage.clickCheckout();
    }
    @When("User verifies {string} header is visible")
    public void user_verifies_header_is_visible(String header) {
        automationCheckoutPage.validateReviewHeader(header);
    }
    @When("User verifies Address Details contains {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_verifies_address_details_contains(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
        automationCheckoutPage.validateAddress(a,b,c,d,e,f,g,h,i);
    }
    @When("User enters description {string} in comment text area and click Place Order")
    public void user_enters_description_in_comment_text_area_and_click_place_order(String string) {
        automationCheckoutPage.enterTextAndPlaceOrder(driver,string);
    }
    @When("User enters payment details: Name on Card {string}, Card Number {string}, CVC {string}, Expiration date {string} and {string}")
    public void user_enters_payment_details_name_on_card_card_number_cvc_expiration_date_and(String name, String cardNo, String cvc, String exp1, String exp2) throws InterruptedException {
        automationPaymentPage.fill(name,cardNo,cvc,exp1,exp2);
    }
    @Then("User clicks Pay and Confirm Order button and verifies success message {string}")
    public void user_clicks_pay_and_confirm_order_button_and_verifies_success_message(String string) {
        automationPaymentPage.validatePayAndConfirm(string);
    }

}
