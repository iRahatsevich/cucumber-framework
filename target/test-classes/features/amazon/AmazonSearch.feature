Feature: Amazon Search

  Verify all search amazon functionalities


  Scenario: Amazon search result verification
    Given go to amazon.com
    And enter search term "Selenium book"
    And click Search button
    Then verify that result "Selenium Testing Tools Cookbook" is displayed in the results
    And clear the search field
    When enter search term "Java OCA book"
    And click Search button
    Then verify that result "Selenium Testing Tools Cookbook" is not displayed in the results

  Scenario: Verification of at least three search results contain keyword
    Given go to amazon.com
    And enter search term "Selenium book"
    And click Search button
    Then verify at least three results contain term "Selenium"


  @search_one
  Scenario: Verification of search results with "Free shipping" checkbox checked
    Given go to amazon.com
    And enter search term "Selenium book"
    And click Search button
    Then verify free shipping checkbox is not selected
    And check free shipping checkbox
    Then verify top five results are still the same

