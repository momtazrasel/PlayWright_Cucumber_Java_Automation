Feature: Login Functionality

  As a user of the application
  I want to log into the application
  So that I can access my dashboard

  Scenario: Successful login to the application
    Given the user navigates to the login page
    When the user enters valid credentials
    And clicks on the login button
    Then the user should be redirected to the dashboard

  Scenario: Login with invalid credentials
    Given the user navigates to the login page
    When the user enters invalid credentials
    And clicks on the login button
    Then an error message should be displayed

  Scenario: Login with blank credentials
    Given the user navigates to the login page
    When the user leaves the username and password fields blank
    And clicks on the login button
    Then a validation message should be displayed
