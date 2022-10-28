Feature: Check email form functionality feature
  Scenario: 01. Load login page
    Given Main page is opened
    When A user clicks on Your account button
    Then Account page is opened

    Scenario Outline: 02. Check an error validation message
      Given Login page is opened
      When A user enters "<nonValidEmail>"
      Then "<errorMessage>" appears

      Examples:
      |nonValidEmail|errorMessage|
      |123          |Please ensure you have entered the correct email address|
      |@mail.ru     |Please ensure you have entered the correct email address|
      |23@          |Please ensure you have entered the correct email address|
      |123@mail     |Please ensure you have entered the correct email address|
