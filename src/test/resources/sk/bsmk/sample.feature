Feature: Sample feature

  Scenario: Hello message with is received
    When I have rest template
    And My name is world
    Then I receive hello message with my name