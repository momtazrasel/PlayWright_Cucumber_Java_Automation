Feature: Login to the system
  Scenario: Perform login
    Given User opens the browser
    When User logs in with "admin" and "password123"
    Then User is on the home page
