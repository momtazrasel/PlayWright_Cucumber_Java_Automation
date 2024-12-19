Feature: Finance Module

  Background:
    Given the user has logged into the application

  Scenario: Access the finance page
    When the user navigates to the finance page
    Then the finance page should display correct information
