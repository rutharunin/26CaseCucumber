Feature: Testing Shopping Cart Functionalities
  Background:
    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
  Scenario: Happy Path Adding Product into Cart
    And User clicks Products button
    When User hovers over first product and clicks Add to cart and clicks Continue Shopping button
    And User hovers over second product and clicks Add to cart
    Then User clicks View Cart button and verifies both products are added to Cart
    And User verifies their prices, quantity and total price
    And User deletes products from the cart
# Case 13 Ad popup causes a huge problem. Refresh makes it go back, but if ad does not pop, it will go to a page without webElement
  Scenario: Happy Path adding Product quantity
    When User clicks View Product for any product on home page and verifies the page title contains 'Product Details'
    And User increases quantity to '4' and clicks Add to cart button
    Then User clicks View Cart button and verifies product is displayed with quantity of '4'
    And User clears shopping cart
#    This sometimes passes the other doesn't. I tried Thread.sleep(500) and wait to no avail.
  Scenario: Happy Path Placing Order: Register While Checkout
    When User hovers over a product and click Add to cart and clicks View Cart button and verifies that the page has header reads 'Shopping Cart'
    And User clicks Proceed To Checkout and clicks Register-Login button
    And User provides username 'lalala1' and email address 'emailaddress1@gmail.com' and clicks sign up button
    And User verifies 'ENTER ACCOUNT INFORMATION' message is visible
    And User provides title 'Mr', password, date of birth '10','January','1999'
    And User provides 'Russ','Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','IL','Chicago','60000','1234567890'
    And User click Create Account button and validates 'ACCOUNT CREATED!'
    And User clicks Continue Button and validates logged in as username 'lalala1'
    And User clicks Cart button and clicks Proceed To Checkout button
    And User verifies 'Review Your Order' header is visible
    And User verifies Address Details contains 'Mr. Russ Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','Chicago',' IL',' 60000','1234567890'
    And User enters description 'test test test' in comment text area and click Place Order
    And User enters payment details: Name on Card 'Russ Arunin', Card Number '111111111111', CVC '123', Expiration date '12' and '2400'
    Then User clicks Pay and Confirm Order button and verifies success message 'Congratulations! Your order has been confirmed!'
    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
  Scenario: Happy Path Placing Order: Register before Checkout
    And User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
    And User provides username 'lalala1' and email address 'emailaddress1@gmail.com' and clicks sign up button
    And User verifies 'ENTER ACCOUNT INFORMATION' message is visible
    And User provides title 'Mr', password, date of birth '18','April','2000'
    And User provides 'Russ','Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','IL','Chicago','60000','1234567890'
    And User click Create Account button and validates 'ACCOUNT CREATED!'
    And User clicks Continue Button and validates logged in as username 'lalala1'
    When User hovers over a product and click Add to cart and clicks View Cart button and verifies that the page has header reads 'Shopping Cart'
    And User verifies that the item is in the cart
    And User clicks Proceed to Checkout
    And User verifies Address Details contains 'Mr. Russ Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','Chicago',' IL',' 60000','1234567890'
    And User enters description 'test test test' in comment text area and click Place Order
    And User enters payment details: Name on Card 'Russ Arunin', Card Number '111111111111', CVC '123', Expiration date '12' and '2400'
    Then User clicks Pay and Confirm Order button and verifies success message 'Congratulations! Your order has been confirmed!'
#    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
  Scenario: Happy Path Placing Order: Login before Checkout
    When User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
    And User provides email address 'emailaddress1@gmail.com' and password and clicks Login button
    Then User validates Logged in as 'lalala1' is visible
    When User hovers over a product and click Add to cart and clicks View Cart button and verifies that the page has header reads 'Shopping Cart'
    And User verifies that the item is in the cart
    And User clicks Proceed to Checkout
    And User verifies Address Details contains 'Mr. Russ Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','Chicago',' IL',' 60000','1234567890'
    And User enters description 'test test test' in comment text area and click Place Order
    And User enters payment details: Name on Card 'Russ Arunin', Card Number '111111111111', CVC '123', Expiration date '12' and '2400'
    Then User clicks Pay and Confirm Order button and verifies success message 'Congratulations! Your order has been confirmed!'
    And User clicks continue
#    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible