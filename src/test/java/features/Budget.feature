Feature: Budget Module

  Background:
    Given the user has logged into the application

  Scenario: Access the budget page
    When the user navigates to the budget page
    Then the budget page should display correct information
