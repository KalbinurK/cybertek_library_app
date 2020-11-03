Feature: Show records functionality

  @wip
  Scenario: verify default values in users page
    Given User is on the login page
    And User logs in as a librarian
    When User click on "Users" link
    Then show records default value should be 10
    And show records should have following options:
  | 5   |
  | 10  |
  | 15  |
  | 50  |
  | 100 |
  | 200 |
  | 500 |