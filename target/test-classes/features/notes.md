what is feature file ? 
Feature file is a cucumber file. BDD(behavior - driven development)
 -> we write extensive scenarios for testing behavior of  feature. (Feature == Functionality)
 
 scenarios are written  in Gherking language which is pure english wordings.
 How is it helpful? 
 anyone can understand(BA, PO , Dev ...) can review and approve the scenarios 
 
 we are planning to build the application according to the written scenarios.
 
 new hired team members -> easy yo get up to speed with the application flow. Functionality flow.
 

 Scenarios should be implemented with step definitions(glue code).
 If a step doesnt have an implementation we can run the scenario and cucumber plugin of intelliJ will
 generate missing steps with snippets.
 
 
 
 VERY IMPORTANT RULE: 
 tests should be completely 
 independant from each other. 
 one test should not cause failure for another.