Feature: Checkout feature
  Background:
    Given User is on login page
    When User try to login with credentials: "johndoe19" "supersecret"
    Then User assert that welcome message containing username "johndoe19" is shown.

  @smoke
  Scenario: Checkout Form Order Success
    Given User is on checkout page
    And User Complete all the fields "John Doe" "johndoe@test.com" "123456789" "Evergreen 123" "January" "Springfield" "2025" "1234" "12345"
    And User verify that if "Shipping address same as billing" checkbox is not checkmarked then checkmark it.
    When User submit the form
    Then User assert that the order confirmation number is not empty.

  @smoke
  Scenario: Checkout Form Alert
    Given User is on checkout page
    And User Complete all the fields "John Doe" "johndoe@test.com" "123456789" "Evergreen 123" "January" "Springfield" "2025" "1234" "12345"
    And User verify that if "Shipping address same as billing" checkbox is checkmarked then uncheckmark it.
    And User submit the form
    And User verify that the alert message is shown.
    When User confirm the alert
    Then User assert that alert is gone.

  @smoke
  Scenario: Cart Total Test
    When User is on checkout page
    Then User assert that the cart total shown is correct for the item prices added.