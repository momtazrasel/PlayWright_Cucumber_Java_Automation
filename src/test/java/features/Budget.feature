Feature: Budget Module

  Background:
    Given the user navigates to the login page
    When the user enters valid credentials
    And clicks on the login button
    Then the user should be redirected to the dashboard

  Scenario: Access the budget page
    When the user navigates to the budget page
    Then the budget page should display correct information

#  Scenario: Perform a budget-related action
#    When the user performs a budget-related action
#    Then the system should process the action successfully
