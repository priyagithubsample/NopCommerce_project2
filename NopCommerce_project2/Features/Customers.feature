Feature: Customers

  Scenario: Add a new customer
    Given user launch chrome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then user can view Dashboard
    When user click on customers menu
    And click on customers menu item
    And click on Add new button
    Then user can view Add new customer page
    When user enter customer info
    And click on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close browser
    
@regression
  Scenario: Search customer by EmailID
    Given user launch chrome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then user can view Dashboard
    When user click on customers menu
    And click on customers menu item
    And Enter customer Email
    When click on search button
    Then user should found Email in the search table
    And close browser
