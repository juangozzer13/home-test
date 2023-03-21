Feature: Search Feature
  Background:
    Given User is on login page
    When User try to login with credentials: "johndoe19" "supersecret"
    Then User assert that welcome message containing username "johndoe19" is shown.

  @smoke
  Scenario: Search Success
    Given User is on search page
    When User search "automation" in search bar
    Then User assert that "Found one result for" plus "automation".

  @smoke
  Scenario: Search Empty
    Given User is on search page
    When User leave search box empty and submit the search
    Then User assert that "Please provide a search word." message is shown.