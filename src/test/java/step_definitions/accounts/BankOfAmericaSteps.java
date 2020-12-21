package step_definitions.accounts;

import application.BankBase;
import application.BankOfAmerica;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;





    /*
    modify Step def class so that each step can handle any number of rows.
    ex: you can create any number of accounts
    you can deposit to exact account regardless of the position in the the dataTables in feature file
    you can validate that exact account number has the given balance

    hint: you need to loop through the list param
     */






//        System.out.println(dataTable.topCells());
//
//        //gives all rows starting from the given row
//        System.out.println(dataTable.cells(0));
//
//        List<String> dataTableToList = dataTable.asList(String.class); -> one of the approaches but not very helpful as its 1dimentional arrayList and indexes go from left -> right
//        System.out.println(dataTableToList);
//

//        List<List<String>> dataTableToLists = dataTable.asLists(String.class);
//        System.out.println(dataTableToLists);
//        System.out.println(dataTableToLists.get(2).get(1)); ->hardcoding , not that good
//
//approach2:
//        List<Map<String, Long>> dataTableToMap = dataTable.asMaps(String.class, Long.class);
//        System.out.println(dataTableToMap);
//
//        System.out.println(dataTableToMap.get(2).get("accountNumber"));




public class BankOfAmericaSteps {

    List<BankBase> banks = new ArrayList<>();

    @Given("^the following user account is created$")
    public void the_following_user_account_is_created(List<Map<String, Long>> accountAndRoutingNums) throws Exception {

        for (Map<String, Long> row : accountAndRoutingNums) {
            banks.add(new BankOfAmerica(row.get("accountNumber"), row.get("routingNumber")));
        }


        // bankOfAmerica = new BankOfAmerica(accountAndRoutingNums.get(0).get("accountNumber"), accountAndRoutingNums.get(0).get("routingNumber"));
        //bankOfAmerica2 = new BankOfAmerica(accountAndRoutingNums.get(1).get("accountNumber"), accountAndRoutingNums.get(1).get("routingNumber"));

    }


    @When("^the following deposits are made$")
    public void the_following_deposits_are_made(List<Map<String, String>> depositList) throws Throwable {

        //loop through banks created in the first step
        for (BankBase bank : banks) {

            //for each bank loop through the data table
            for (Map<String, String> deposit : depositList) {
                //compare each row's account number
                if (bank.getAccountNumber() == Long.parseLong(deposit.get("accountNumber"))) {
                    //deposit to the bank that has matching account number
                    bank.deposit(Double.parseDouble(deposit.get("deposit")));
                }
            }
        }
    }
    //System.out.println(depositList.get(0).get("deposit"));
    // bankOfAmerica.deposit(Double.parseDouble( depositList.get(0).get("deposit")));
    //bankOfAmerica2.deposit(Double.parseDouble( depositList.get(1).get("deposit")));


    @Then("^accounts have the following balances$")
    public void accounts_have_the_following_balances(List<Map<String, String>> balanceList) throws Throwable {

        for (BankBase bank : banks) {
            for (Map<String, String> balanceMap : balanceList) {
                if (bank.getAccountNumber() == Long.parseLong(balanceMap.get("accountNumber"))) {
                    double actualBalance = bank.getBalance();
                    double expectedBalance = Double.parseDouble(balanceMap.get("balance"));
                    Assert.assertEquals("balance", expectedBalance, actualBalance,0.0);
                }
            }
        }
    }
}





            /* String actualBalance;
      String expectedBalance;

      for(Map<String, String> b : balanceList){
          actualBalance = b.get("balance");

*/


       /*
        double actualBalance = bankOfAmerica.getBalance();
        double expectedBalance = Double.parseDouble(balanceList.get(0).get("balance"));
        Assert.assertEquals("balance ", expectedBalance, actualBalance,0.00);
        double actualBalance2 = bankOfAmerica2.getBalance();
        double expectedBalance2 = Double.parseDouble(balanceList.get(1).get("balance"));
        Assert.assertEquals("balance ", expectedBalance2, actualBalance2,0.00);
   */
   // }}