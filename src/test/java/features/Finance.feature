Feature: Finance Module

  Background:
    Given the user navigates to the login page
    When the user enters valid credentials
    And clicks on the login button
    Then the user should be redirected to the dashboard

  Scenario: Access the finance page
    When the user navigates to the finance page
    Then the finance page should display correct information

  Scenario: Perform a finance-related action
    When the user performs a finance-related action
    Then the system should process the action successfully
