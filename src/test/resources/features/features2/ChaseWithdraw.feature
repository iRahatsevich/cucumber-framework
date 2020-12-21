Feature: Chase bank account can withdraw money op to 1000


  Background:
   # Given all accounts are reset


  Scenario: Withdraw within the limit
    Given User account with accountNumber 123456789123 and routing number 123456789 is opened

    And User deposits $1000.00
    When User withdraws $1000.00
    Then User should have $0.0 in account


  Scenario: Withdraw over the limit
    Given User account with accountNumber 123456789123 and routing number 123456789 is opened

    And User deposits $1000.00
    When User withdraws $1500.00
    Then User should have $1000.0 in account


  Scenario: Withdraw with insufficient funds balance
    Given User account with accountNumber 123456789123 and routing number 123456789 is opened

    When User withdraws $10.00
    Then User should have $0.0 in account

  Scenario: Withdraw with 0 balance
    Given User account with accountNumber 123456789123 and routing number 123456789 is opened

    And User deposits $-1000.00
    When User withdraws $10.00
    Then User should have $0.0 in account

