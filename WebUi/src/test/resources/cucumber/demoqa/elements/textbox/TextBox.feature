Feature: TestBox

  Background:
    Given url = "https://demoqa.com/text-box"

  Scenario: Fill with valid values and submit
    When requested fullName = "Tony Stark", email = "tonystark@gmail.com", currentAddr = "Ukraine", permanentAddress = "USA"
    And submit button pressed
    Then output div is correctly set