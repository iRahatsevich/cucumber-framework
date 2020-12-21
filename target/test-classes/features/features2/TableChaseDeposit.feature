Feature: Deposit amount to the account

  Background:
    #iven all accounts are reset
    And The following user account is created
    |accountNumber|routingNumber|
    |123456789123 | 123456789   |

  Scenario: Deposit within allowed range of Chase
    When User deposits $1000.00 to the account
    Then User should have $1000.00 in account