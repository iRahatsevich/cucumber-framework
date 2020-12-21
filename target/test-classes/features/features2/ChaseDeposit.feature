Feature: Chase bank account can withdraw money up to 1000

   # Background can be put before the first scenario within feature file.
  # What is background?
  # feature files can serve as a living documentation.
  # -->
  # --> keep documention as easy as possible to comprehend. \
  #Background runs before every scenario in the Feature file.
  #Purpose of background is to simplify scenarios by removing preconditions

  Background:
    And User account with accountNumer 234523453245 and routing number 123456789 is opened


  Scenario: Deposit amount within allowed range.
    #Precondition -> some setup that needs to happen for this scenario to execute
    #use in past tense
    #Action - execution of the functionality that being testing
    #Present tense
    When User deposits $1000.00
    #should be, should have
    Then User should have $1000 in account


  Scenario: Deposit within allowed range close to upper boundary
    When User deposits $9000.12
    Then User should have $9000.12 in account


  Scenario: Deposit amount is negative
    When User deposits $-1000.40
    Then User should have $0.0 in account


  Scenario: Deposit negative amount -1
    When User deposits $-1.33
    Then User should have $0.0 in account


  Scenario: Deposit above the max limit
    When User deposits $12000.22
    Then User should have $0.0 in account


  Scenario: Deposit 0
    When User deposits $0.0
    Then User should have $0.0 in account


  Scenario: Deposit the max
    When User deposits $10000.00
    Then User should have $10000.00 in account

  @ignore
  Scenario: Deposit multiple times within the range
    When User deposits $6000.33
    And User deposits $1000.44
    Then User should have $7000.77 in account


  Scenario: Deposit multiple times within the range approach 2
    When User deposits $6000.00
    Then User should have $6000.00 in account
    When User deposits $1000.00
    Then User should have $7000.00 in account



