Feature: Testing Product manipulation Functionalities
  Background:
    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
  Scenario: Happy Path Removing Product from Cart
    And User hovers over the sixth product from the top and clicks Add to cart then clicks continue button
    And User clicks cart button and verifies that User arrives at page whose header reads, 'Shopping Cart'
    Then User clicks x button and verifies that User arrives at a page whose header contains text,'Cart is empty!'
  Scenario: Happy Path Product Category Navigation
    And User verifies that text category 'CATEGORY' is visible on left side bar
    When User clicks Women category and clicks Tops as the sub-category
    Then User verifies that the page header reads 'WOMEN - TOPS PRODUCTS' and all items headers contain the word 'top'
    And User clicks TSHIRTS sub-category link of MEN category
    And User verifies that all items headers contain the word 'tshirt' or 't-shirt' or 't shirt'
  Scenario: Happy Path Product Brand Navigation
    And User clicks Products button
    And User verifies that text, brands 'BRANDS' is visible on left side bar
    When User clicks the second brand from the top and verifies that the header of the next page contains the chosen name
    Then User clicks the fourth brand from the top and verifies that the header of the next page contains the chosen name