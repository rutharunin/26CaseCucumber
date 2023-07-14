#Feature: Testing Registration and Login Logout functionalities.
#  @smoke
#  Scenario Outline: Happy Path of Registration
#    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
#    When User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
#    And User provides username '<username>' and email address '<email>' and clicks sign up button
#    And User verifies 'ENTER ACCOUNT INFORMATION' message is visible
#    And User provides title '<gender>', password, date of birth '<day>','<month>','<year>'
#    And User selects Sign up for our newsletter! and Receive special offers from our partners!
#    And User provides '<name>','<lastname>','<company>','<address1>','<address2>','<country>','<state>','<city>','<zip>','<phone>'
#    Then User click Create Account button and validates 'ACCOUNT CREATED!'
#    And User clicks Continue Button and validates logged in as username '<username>'
#    And User clicks Logout button and validates signup and login messages 'New User Signup!' 'Login to your account' visible
#    Examples:
#      | username  | email                   | gender | day | month   | year | name | lastname | company | address1         | address2 | country       | state | city           | zip   | phone      |
#      | lalala1   | emailaddress1@gmail.com | Mr     | 10  | October | 2010 | Ruth | Smith    | Hohoho  | 1234 N Heaven St | House 2  | United States | IL    | Chicago        | 60000 | 1234567890 |
#      | labambam1 | emailaddress2@gmail.com | Mrs    | 6   | June    | 2005 | Russ | Arunin   | Hahaha  | 4321 S Hell St   | House 3  | Singapore     | IL    | Singapore City | 10000 | 0987654321 |
#  @smoke
#  Scenario: Happy Path Login
#    Given User navigates to the API AutomationExercise
#    When User provides email address 'emailaddress1@gmail.com' and password and clicks Login button for API
#    Then Status code is 200
##    Then User validates Logged in as 'labambam1' is visible
##    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
#  Scenario: Unhappy Path Login
#    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
#    When User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
#    And User provides incorrect email address 'email@gmail.com' and password and clicks login button
#    Then User Verifies login error 'Your email or password is incorrect!' is visible
#  Scenario: Unhappy Path Registration with Existing Email
#    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
#    When User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
#    And User provides username 'lalala2' and existing email address 'emailaddress1@gmail.com' and clicks sign up button
#    Then User Verifies sign-in error with 'Email Address already exist!' is visible
#  Scenario: (Login) Logout and Delete Account
#    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
#    When User clicks signUp Login button and validates signup and login messages 'New User Signup!' 'Login to your account' is visible
#    And User provides email address 'emailaddress1@gmail.com' and password and clicks Login button
#    And User validates Logged in as 'lalala1' is visible
#    And User clicks Logout button and validates signup and login messages 'New User Signup!' 'Login to your account' visible
#    And User provides email address 'emailaddress1@gmail.com' and password and clicks Login button
#    Then User validates Logged in as 'lalala1' is visible
#    And User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible