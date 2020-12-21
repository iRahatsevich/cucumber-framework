$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/amazon/AmazonSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Amazon Search",
  "description": "\r\nVerify all search amazon functionalities",
  "id": "amazon-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 24,
  "name": "Verification of search results with \"Free shipping\" checkbox checked",
  "description": "",
  "id": "amazon-search;verification-of-search-results-with-\"free-shipping\"-checkbox-checked",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@search_one"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "go to amazon.com",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "enter search term \"Selenium book\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "click Search button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "verify free shipping checkbox is not selected",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "check free shipping checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "verify top five results are still the same",
  "keyword": "Then "
});
formatter.match({
  "location": "AmazonSearchSteps.go_to_amazon_com()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Selenium book",
      "offset": 19
    }
  ],
  "location": "AmazonSearchSteps.enter_search_term(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AmazonSearchSteps.click_Search_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AmazonSearchSteps.verify_free_shipping_checkbox_is_not_selected()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AmazonSearchSteps.check_free_shipping_checkbox()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});