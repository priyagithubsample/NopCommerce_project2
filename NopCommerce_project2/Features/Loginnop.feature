Feature: login

  Scenario: Verify that user successfully login with valid credentials
    Given user launch chrome browser
    When user opens URL
    And user enters email and password
    And click on login button
    Then page tittle should be "Dashboard / nopCommerce administration"
    When user click on log out button
    Then page tittle should be "Your store. Login"
    And close browser
