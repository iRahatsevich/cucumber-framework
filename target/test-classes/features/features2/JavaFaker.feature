Feature: Java Faker practice

  Scenario: Customer info with java
    Given User generate last name and first name
    And User generate address info
    Then Customer info should be printed


  Scenario: Customer info with java faker
    Given User generate last name and first name with JF
    And User generate address info with JF
    Then Customer info should be printed