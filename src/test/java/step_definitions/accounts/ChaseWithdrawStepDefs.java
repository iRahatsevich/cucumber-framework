package step_definitions.accounts;

import application.BankBase;
import cucumber.api.java.en.Then;


public class ChaseWithdrawStepDefs {


    @Then("^all accounts are reset$")
    public void all_accounts_are_reset() {
        //cache -> clear the cache of app
        BankBase.accountStorage.clear();
    }
}
