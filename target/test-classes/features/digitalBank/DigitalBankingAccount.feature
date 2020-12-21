@homepage
Feature: home page

  as a user I want to edit/add/manage Bank Account Payment Profile


  Background: Login
    Given User navigate to Digital Bank application login page
    And Verify title is "Digital Bank"
    When user enters username and password
      | username              | password  |
      | JohnDoe@testemail.com | Password1 |


  Scenario: As a user I want to be able to view all details in my account home page
    Then Verify title is "Digital Bank"
    And Verify that Home button is displayed
    And Verify that "Account Balance Summary" text is displayed
    And Verify that "Deposit vs. Withdraw (Last 3 Months)" text is displayed
    And Verify that "Withdraw By Category (Last 3 Months)" text is displayed
    And Verify that "Deposit By Category (Last 3 Months)" text is displayed
    And Verify that under "Banking Accounts" we have options
      | Checking | Savings | Transactions |

    And Verify that under "Credit Accounts" we have options
      | Digital Credit |

    And Verify that under "Transfer/Payments" we have options
      | Transfer |
    And Verify that under "3rd Party Transfers" we have options
      | VISA direct |
    And Verify that "Welcome John" text is displayed


  Scenario:   As a User, I want have the ability to create a new Checking bank account so that my payment can be processed from my preferred account.
    And User clicks on Checking button
    And Verify that under "Checking" we have options
      | View Checking | New Checking |


  Scenario: As a user I want to navigate to the New Checking Account
    And User clicks on Checking button
    And User clicks on New Checking button
    And Verify that "New Checking Account" text is displayed
    And Verify that under "Select Checking Account Type" we have options
      | Standard Checking | Interest Checking |
    And Verify that radio buttons are unchecked
    And Verify that under "Select Account Ownership" we have options
      | Individual | Joint |
    And Verify that radio buttons are unchecked
    And Verify that "Account Name" text is displayed
    And Verify that input field accepts alphanumeric and special characters
    And Verify that "Initial Deposit Amount" text is displayed
    And Verify that input field accepts numeric whole or decimal values
    And Verify that "ex. Minimum opening deposit is $25.00" we have options
    And Verify that "Submit" button is displayed
    And Verify that "Reset" button is displayed


  Scenario: As a user I get error message when submit empty fields
    And User clicks on Checking button
    And User clicks on New Checking button
    And Verify that "New Checking Account" text is displayed
    And User clicks on Submit button
    And User should get error message "Please select one of these options"


  Scenario: As a user I get error message when submit empty fields on Select Account Ownership
    And User clicks on Checking button
    And User clicks on New Checking button
    And Verify that "New Checking Account" text is displayed
    And User clicks on "Standard Checking" radio button
    And User clicks on Submit button
    And User should get error message "Please select one of these options"


  Scenario: As a user I get error message when submit empty fields on Account Name
    And User clicks on Checking button
    And User clicks on New Checking button
    And Verify that "New Checking Account" text is displayed
    And User clicks on "Standard Checking" radio button
    And User clicks on "Individual" radio button
    And User clicks on Submit button
    And User should get error message "Please fill out this field."


  Scenario: As a user I get error message when submit empty fields on Initial Deposit Amount
    And User clicks on Checking button
    And User clicks on New Checking button
    And Verify that "New Checking Account" text is displayed
    And User clicks on "Standard Checking" radio button
    And User clicks on "Individual" radio button
    And User enters name "John"
    And User clicks on Submit button
    And User should get error message "Please fill out this field."


