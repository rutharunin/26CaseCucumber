package com.test.automationexercises.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class AutomationHook {
    WebDriver driver= DriverHelper.getDriver();
    @Before
    public void setup(){
        driver.get(ConfigReader.readProperty("automationexerciseUrl"));
    }
//    @After
//    public void tearDown(){
//    SCREEN SHOT
//        driver.quit();
//    }
}