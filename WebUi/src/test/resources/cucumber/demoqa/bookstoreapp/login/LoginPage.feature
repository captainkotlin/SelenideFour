Feature: LoginPage

  Background:
    Given url = "https://demoqa.com/login"

  Scenario: Login with correct user and password
    Given user = "captainkotlin" and password = "Captain1@"
    When Login button pressed
    Then user succesfully logged in