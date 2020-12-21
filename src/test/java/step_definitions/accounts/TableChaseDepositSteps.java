package step_definitions.accounts;

import application.BankBase;
import application.Chase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


import java.util.List;
import java.util.Map;

public class TableChaseDepositSteps {
BankBase chase ;
    @Given("^The following user account is created$")
    public void the_following_user_account_is_created(List<Map<String, Long>> accountAndRoutingNumbers) throws Exception {
       

        chase = new Chase(111111111111L,999999999L);
        System.out.println(accountAndRoutingNumbers);

    }
        @When("^User deposits \\$(\\d+.\\d+) to the account$")
        public void user_deposits_$_to_the_account(double amount)  {
            // Write code here that turns the phrase above into concrete actions

        }



}
