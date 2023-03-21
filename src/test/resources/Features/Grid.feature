Feature: Grid feature
  Background:
    Given User is on login page
    When User try to login with credentials: "johndoe19" "supersecret"
    Then User assert that welcome message containing username "johndoe19" is shown.

  @smoke
  Scenario: Cart Total Test
    Given User is on grid page
    Then User assert that in position 7 the product shown is "Super Pepperoni"
    And User assert that the price shown is "$10"

  @smoke
  Scenario: Grid All Items Test
    When User is on grid page
    Then User assert that all the items have a non-empty title, price, image and a button.