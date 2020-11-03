Feature: Borrow book
  As a student should be able to borrow a book from "Library" application

  @borrowBook
  Scenario: User should be able to borrow books

    Given User is on the login page
    When User logs in as a student
    And User should sort by "Borrowed By"
    Then User should able borrow book

