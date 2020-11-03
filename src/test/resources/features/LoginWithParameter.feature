Feature: Login with parameters

  @librarianParam
  Scenario: Login as librarian 12
    Given  User is on the login page
    When user enter username "librarian12@library"
    And user enter password "AOYKYTMJ"
    And click the sign in button
    And there should be 1598 users
    Then dashboard should be displayed
   #number can be whatever you have there

  @studentParam
  Scenario: Login as student 30
    Given  User is on the login page
    When user enter username "student30@library"
    And user enter password "IaT9YI0I"
    And click the sign in button
    Then books should be displayed
