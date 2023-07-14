Feature: Testing General Page Functionalities
  Background:
    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
  Scenario: Happy Path Add Review About Product
    And User clicks Products button and verifies user navigates to a page containing 'All Products' in its title
    And User clicks View Product button of item seven from top and verifies header 'WRITE YOUR REVIEW' is visible
    When User enters name 'lalala1' email address 'emailaddress1@gmail.com' message 'This is a test' and click submit button
    Then User verifies success message 'Thank you for your review.'
  Scenario: Happy Path Add a Recommended Item to Cart
    And User scrolls to bottom of page and verifies that header 'RECOMMENDED ITEMS' is visible
    And User clicks Add To Cart button on the first product
    Then User clicks View Cart button and verifies that product is displayed in cart page then empty the cart
  Scenario: Happy Path Checking Address at Checkout
    When User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
    And User provides username 'lalala1' and email address 'emailaddress1@gmail.com' and clicks sign up button
    And User verifies 'ENTER ACCOUNT INFORMATION' message is visible
    And User provides title 'uniform-id_gender1', name 'lalala1', email, 'emailaddress1@gmail.com', password, date of birth '10', 'October', '2010'
    And User selects Sign up for our newsletter! and Receive special offers from our partners!
    And User provides 'Russ','Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','IL','Chicago','60000','1234567890'
    Then User click Create Account button and validates 'ACCOUNT CREATED!'
    And User clicks Continue Button and validates logged in as username 'lalala1'
    When User hovers over a product and click Add to cart and clicks View Cart button and verifies that the page has header reads 'Shopping Cart'
    And User verifies that the item is in the cart
    And User clicks Proceed to Checkout
    And User verifies Address Details contains 'Mr. Russ Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','Chicago',' IL',' 60000','1234567890'
    And User enters description 'test test test' in comment text area and click Place Order
    And User enters payment details: Name on Card 'Russ Arunin', Card Number '111111111111', CVC '123', Expiration date '12' and '2400'
    Then User clicks Pay and Confirm Order button and verifies success message 'Congratulations! Your order has been confirmed!'
  #    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
  Scenario: Happy Path Search Product, Add to Cart, and the Product remains in the Cart After Login
    And User clicks Products button and verifies user navigates to a page containing 'All Products' in its title
    When User enters text 'saree' in search input and click search button
    And User verifies that the header reads 'SEARCHED PRODUCTS' and that all products headers contains the word 'saree'
    And User adds all products to the cart and verifies that all added products are in the cart
    And User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
    And User provides email address 'emailaddress1@gmail.com' and password and clicks Login button
    Then User validates Logged in as 'lalala1' is visible
    Then User clicks cart button and confirms that all products name in cart contains the word 'saree'
    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
  Scenario: Happy Path Download Invoice after Buy
    When User hovers over a product and click Add to cart and clicks View Cart button and verifies that the page has header reads 'Shopping Cart'
    And User clicks Proceed To Checkout and clicks Register-Login button
    And User provides username 'lalala1' and email address 'emailaddress1@gmail.com' and clicks sign up button
    And User verifies 'ENTER ACCOUNT INFORMATION' message is visible
    And User provides title 'uniform-id_gender1', name 'lalala1', email, 'emailaddress1@gmail.com', password, date of birth '10', 'October', '2010'
    And User provides 'Russ','Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','IL','Chicago','60000','1234567890'
    And User click Create Account button and validates 'ACCOUNT CREATED!'
    And User clicks Continue Button and validates logged in as username 'lalala1'
    And User clicks Cart button and clicks Proceed To Checkout button
    And User verifies Address Details contains 'Mr. Russ Arunin','Hohoho','1234 N Heaven St','Apt 2','United States','Chicago',' IL',' 60000','1234567890'
    And User verifies 'Review Your Order' header is visible
    And User verifies that the order in cart matches what was added in the beginning
    And User enters description 'test test test' in comment text area and click Place Order
    And User enters payment details: Name on Card 'Russ Arunin', Card Number '111111111111', CVC '123', Expiration date '12' and '2400'
    Then User clicks Pay and Confirm Order button and verifies success message 'Congratulations! Your order has been confirmed!'
    And User clicks Download Invoice button and verifies invoice is downloaded successfully
    And User clicks continue
#    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
