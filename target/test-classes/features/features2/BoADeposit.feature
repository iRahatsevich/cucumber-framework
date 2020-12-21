
Feature: Bank of America deposit


Background:
  #Given all accounts are reset
@smoke
  Scenario: Deposit within allowed limit
    Given the following user account is created
    #Data tables in feature file -> are used to pass parameterized collection of values
    #If your step has more than one or two values to pass then it's better to use data tables
      | accountNumber | routingNumber |
      | 234523453245  | 123456789     |
      | 234523453123  | 222456789     |



    #try to use dataTables for all the test written in chase
  #validate that multiple account can be created at the same time
  #validate that we can deposit amount to multiple accounts at the same time

  Scenario: Multiple Account Deposit test

    Given the following user account is created
      | accountNumber | routingNumber |balance |
      | 234523453245  | 123456789     | 200    |
      | 234523453123  | 222456789     | 200    |

    When the following deposits are made
      | accountNumber |deposit|
      | 234523453245  |500.00 |
      | 234523453123  |200.00 |

    Then accounts have the following balances
      | accountNumber |balance |
      | 234523453245  |700.00  |
      | 234523453123  |400.00  |



  Scenario: Multiple Account Deposit test 2
    Given the following user account is created
      | accountNumber | routingNumber |balance |
      | 234523453245  | 123456789     | 200    |
      | 114523453123  | 222456789     | 200    |
      | 884523453123  | 882456789     | 200    |

    When the following deposits are made
      | accountNumber |deposit|
      | 114523453123  |200.00 |
      | 234523453245  |500.00 |
      | 884523453123  |800.00 |


    Then accounts have the following balances
      | accountNumber |balance |
      | 114523453123  |400.00  |
      | 234523453245  |700.00  |
      | 884523453123  |1000.00 |