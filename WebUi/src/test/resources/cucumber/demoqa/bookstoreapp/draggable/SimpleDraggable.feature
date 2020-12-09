Feature: SimpleDraggable

  Background:
    Given url = "https://demoqa.com/dragabble"

  Scenario:
    When drag by x = 50 and y = 50 is performed
    Then element changed coordinates accordingly