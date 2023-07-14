#Feature: Testing Miscellaneous Functionalities
#  Background:
#    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
#  Scenario: Happy Path Contact form
#    And User clicks Contact Us button and verifies 'GET IN TOUCH' header
#    When User enters name 'hahaha',email 'hahaha@gmail.com',subject 'test test' and message 'This is a test'
#    And User uploads file 'C:\Users\rutha\OneDrive\Pictures\Screenshots\Screenshot_20221223_090711.png' and clicks submit button
##    Then User clicks ok button and Verifies success message 'Success! Your details have been submitted successfully.' is visible then clicks Home button
#    Then User clicks ok button and Verifies success message 'Success! Your details have been submitted successfully.' is visible then clicks Home button and enters second time upload file 'C:\Users\rutha\OneDrive\Pictures\Screenshots\Screenshot_20221223_090711.png'
#  Scenario: Happy Path All Products and Product details
#    And User clicks Products button and verifies user navigates to a page containing 'All Products' in its title
##   And User verifies that product list is visible
#    When User clicks View Product button of first product and user navigates to a page containing 'Product Details' in its title
#    Then User Verifies that the following details are visible: product name??? How, 'Category', price 'Rs.', 'Availability', 'Condition', 'Brand'
#  Scenario: Happy Path Search Products
#    And User clicks Products button and verifies user navigates to a page containing 'All Products' in its title
#    When User enters product name 'jeans' in search input and click search button
#    Then User Verifies header 'SEARCHED PRODUCTS' is visible
#    And User verifies that all the product name contains text 'jeans' related to search