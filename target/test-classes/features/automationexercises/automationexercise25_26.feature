Feature: Testing Scrolling Up and Down
  Background:
    Given User navigates to the AutomationExercise and validate the title 'Automation Exercise'
  Scenario: Happy Path Automate Scroll Down and Arrow Scroll Up
    And User Scrolls down page to bottom ans verifies header 'SUBSCRIPTION' is visible
    When User clicks the arrow at bottom right side to move upward
    Then User verifies that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
   Scenario: Happy Path Automate Scroll Down and Scroll Up
    And User Scrolls down page to bottom ans verifies header 'SUBSCRIPTION' is visible
    When User scroll up to the top of the page
    Then User verifies that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
