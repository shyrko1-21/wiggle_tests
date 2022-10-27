Feature: Main feature
  Scenario: Verify basket functionality
    Given Main page is opened
    When A user scrolls down to a category
    And Clicks on the Shop now button
    Then Products page is opened
    When A user scrolls down to an item
    And Clicks on a item
    Then Item page is opened
    When A user selects a size
    And Clicks on Add to basket button
    Then Basket pop-up page appears
    When A user clicks on View full basket link
    Then Basket page is opened
    And Quantity is not changed
    When A user clicks on the Continue to checkout button
    Then Login page is opened
    When A user clicks on the Forgotten password button
    Then Forgotten password page is opened