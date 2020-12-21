
Feature: Withdraw with data tables with objects


#one row is one object . accountNumber / routingNumber/balance dont count
  Scenario: Withdraw after opening account
    Given the user accounts are created
      | accountNumber | routingNumber | balance |
      | 234523453245  | 123456789     | 200     |
      | 114523453123  | 222456789     | 200     |
      | 884523453123  | 882456789     | 200     |
      | 111111111111  | 222222222     | 200    |
    When the users withdraw
      | accountNumber | withdrawAmount |
      | 234523453245  | 50             |
      | 114523453123  | 200            |
      | 884523453123  | 100            |
      | 111111111111  | 150            |

    Then the users have the following balances
      | accountNumber | balance |
      | 234523453245  | 150     |
      | 114523453123  | 0       |
      | 884523453123  | 100     |
      | 111111111111  | 50     |
