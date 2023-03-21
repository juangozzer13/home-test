Feature: Login feature

  @smoke
  Scenario: login successful
    Given User is on login page
    When User try to login with credentials: "johndoe19" "supersecret"
    Then User assert that welcome message containing username "johndoe19" is shown.

  @smoke
  Scenario Outline: login failure A and B
    Given User is on login page
    When User try to login with credentials: "<username>" "<password>"
    Then User assert error message is shown.
    Examples:
    |username |password    |
    |john doe |1234        |
    |         |            |