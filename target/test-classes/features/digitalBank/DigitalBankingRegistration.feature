@registration
Feature: Register to digital Bank application


  Scenario: As a user, I want to login to Bank application successfully
    Given User navigate to Digital Bank application login page
    And Verify title is "Digital Bank"
    When user enters username and password
      | username              | password  |
      | JohnDoe@testemail.com | Password1 |
#    When user login with credentials
#      | username              | password  |
#      | JohnDoe@testemail.com | Password1 |
    Then user successfully login to home page


#  Scenario Outline: As a user, I want to login to Bank application successfully
#    Given User navigate to Digital Bank application login page
#   And Verify title is <title>
#    When user enters username and password
#      | <username> | <password> |
#    Then user successfully login to home page
#
#    Examples:
#      | title        | username              | password  |
#      | Digital Bank | JohnDoe@testemail.com | Password1 |
#      | Manual Bank  | Devx@testemail.com    | Password2 |


  Scenario: Error message validation for invalid password
    Given User navigate to Digital Bank application login page
    And Verify title is "Digital Bank"
    When user enters username and password
      | username              | password  |
      | JohnDoe@testemail.com | wrongpass |
    Then user should see error message "Error Invalid credentials or access not granted."


  Scenario: Error message validation for invalid username
    Given User navigate to Digital Bank application login page
    And Verify title is "Digital Bank"
    When user enters username and password
      | username              | password  |
      | invalid@testemail.com | Password1 |
    Then user should see error message "Error Invalid credentials or access not granted."


  Scenario: Error message validation for invalid credentials
    Given User navigate to Digital Bank application login page
    And Verify title is "Digital Bank"
    When user enters username and password
      | username              | password    |
      | invalid@testemail.com | invalidPass |
    Then user should see error message "Error Invalid credentials or access not granted."

    #create scenario for registration
  #step login to register page
  #verify register page



  Scenario: as a user I want to register at Digital Bank application
    Given User navigate to Digital Bank application login page
    And User navigate to Digital Bank application register page
    And Verify title is "Digital Bank"
    When user creates account with following fields
      | title | firstName | lastName | gender | dob        | password   | address   | locality | region | postalCode | country |
      | Mr.   | John      | Smith    | M      | 12/12/1990 | 123456Pass | 1 lane dr | CHICAGO  | IL     | 60611      | USA     |
    Then user should see "Registration successful. Please Login." message
    And User should be able to login to the new account with title "Digital Bank"
# | title | firstName | lastName | gender | dob        | ssn         | email              | password   | address   | locality | region | postalCode | country | homePhone    | mobilePhone  | workPhone    |
#      | Mr.   | John      | Smith    | male   | 12/12/1990 | 444-44-5555 | john@testemail.com | 123456Pass | 1 lane dr | CHICAGO  | IL     | 60611      | USA     | 312-312-3121 | 777-333-8899 | 787-787-7788 |
#

  Scenario Outline: Error message validation for invalid <credentials>
    Given User navigate to Digital Bank application login page
    And Verify title is "Digital Bank"
    When user enters username and password
      | username   | password   |
      | <username> | <password> |
    Then user should see error message "Invalid credentials or access not granted."
    Examples:
      | credentials | username               | password      |
      | password    | JohnDoe@testemail.com  | wrongPassword |
      | username    | invalid@testemail.com  | Password1     |
      | credentials | invalidn@testemail.com | wrongPassword |