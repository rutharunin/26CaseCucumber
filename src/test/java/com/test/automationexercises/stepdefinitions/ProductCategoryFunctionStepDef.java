package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationHomePage;
import com.test.automationexercises.pages.AutomationMen_TShirtPage;
import com.test.automationexercises.pages.AutomationWomen_TopPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ProductCategoryFunctionStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AutomationHomePage automationHomePage=new AutomationHomePage(driver);
    AutomationWomen_TopPage automationWomen_topPage=new AutomationWomen_TopPage(driver);
    AutomationMen_TShirtPage automationMen_tShirtPage=new AutomationMen_TShirtPage(driver);

    @Given("User verifies that text category {string} is visible on left side bar")
    public void user_verifies_that_text_category_is_visible_on_left_side_bar(String expected) {
        automationHomePage.validateCategoryHeader(driver,expected);
    }
    @When("User clicks Women category and clicks Tops as the sub-category")
    public void user_clicks_women_category_and_clicks_tops_as_the_sub_category() throws InterruptedException {
        automationHomePage.clickWomen_Top(driver);
    }
    @Then("User verifies that the page header reads {string} and all items headers contain the word {string}")
    public void user_verifies_that_the_page_header_reads_and_all_items_headers_contain_the_word(String header, String containedWord) {
        automationWomen_topPage.validateHeader(header);
        automationWomen_topPage.validateProductNames(containedWord);
    }
    @Then("User clicks TSHIRTS sub-category link of MEN category")
    public void user_clicks_tshirts_sub_category_link_of_men_category() throws InterruptedException {
        automationWomen_topPage.clickMen_TShirt(driver);
    }
    @Then("User verifies that all items headers contain the word {string} or {string} or {string}")
    public void user_verifies_that_all_items_headers_contain_the_word_or_or(String opt1, String opt2, String opt3) {
        automationMen_tShirtPage.ValidateProductName(opt1,opt2,opt3);
    }
}
