Feature: feature is one functionality.
  here we would write the feature name to be tested
  we create one feature file per feature(functionality)
  #Cucumber comments

  Scenario: we give a scenario name(Deposit within allowed range)
    #Given steps are used for preconditions
    Given User is logged in to chase account
    #When Action
    When  User deposits $1000 to John Doe
    #Then Validation
    Then John Doe should have 1000 deposited

  Scenario: Deposit above threshold limit
    Given User is logged in to chase account
    When User deposits $1000000 to John Doe
    Then John Doe should not have 100000 deposited

  Scenario: Deposit negative value
    #Precondition
    Given User is logged in to chase account
    And   User has 300 in the account
    #Action
    When  User deposits -10 to John Doe
    #Validation
    Then  User should have 300
    And   John Doe Should not any deposits
