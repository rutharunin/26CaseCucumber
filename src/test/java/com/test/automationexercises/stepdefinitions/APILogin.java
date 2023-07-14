package com.test.automationexercises.stepdefinitions;

import com.test.automationexercises.pages.AutomationMemberPage;
import com.test.automationexercises.pages.AutomationSignupPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class APILogin {
//    WebDriver driver= DriverHelper.getDriver();
//    AutomationMemberPage automationMemberPage=new AutomationMemberPage(driver);

    private Response response;
    @Given("User navigates to the API AutomationExercise")
    public void user_navigates_to_the_api_automation_exercise() {
        RestAssured.baseURI="https://automationexercise.com";
        RestAssured.basePath="api/verifyLogin";
    }
    @When("User provides email address {string} and password and clicks Login button for API")
    public void user_provides_email_address_and_password_and_clicks_login_button_for_api(String email) {
        response=
        RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \""+email+"\",\n" +
                        "    \"password\": \""+ ConfigReader.readProperty("automationsigninpassword") +"\"\n" +
                        "}")
                .when().post();
    }
    @Then("Status code is {int}")
    public void status_code_is(int int1) {
        int actualStatusCode=response.getStatusCode();
        Assert.assertEquals(int1,actualStatusCode);
    }
//    @Then("User validates Logged in as {string} is visible")
//    public void user_validates_logged_in_as_is_visible(String string) {
////        automationMemberPage.validateLogin(string);
//    }
}
