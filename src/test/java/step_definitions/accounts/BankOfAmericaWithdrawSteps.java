package step_definitions.accounts;

import application.BankBase;
import application.BankOfAmerica;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domains.AccountDataHolder;
import domains.BalanceCheckContainer;
import domains.WithdrawDataContainer;

import org.junit.Assert;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * use List<Object> of objects for dataTable
 */
public class BankOfAmericaWithdrawSteps {


    List<BankBase> banks = new ArrayList<>();

    @Given("^the user accounts are created$")
    public void the_user_accounts_are_created(List<AccountDataHolder> accountDataHolderList) throws Throwable {

        for (AccountDataHolder account : accountDataHolderList) {
            banks.add(new BankOfAmerica(account.getAccountNumber(), account.getRoutingNumber()));
        }
        System.out.println();

    }

    // System.out.println(accountDataHolderList.get(1).getRoutingNumber());
    // System.out.println(accountDataHolderList.get(2).getAccountNumber());

/*
        bankOfAmerica1 = new BankOfAmerica(accountDataHolderList.get(0).getAccountNumber(), accountDataHolderList.get(0).getRoutingNumber());
        Assert.assertEquals(accountDataHolderList.get(0).getBalance(), bankOfAmerica1.getBalance(), 0.0);

        bankOfAmerica2 = new BankOfAmerica(accountDataHolderList.get(1).getAccountNumber(), accountDataHolderList.get(1).getRoutingNumber());
        Assert.assertEquals(accountDataHolderList.get(1).getBalance(), bankOfAmerica2.getBalance(), 0.0);

        bankOfAmerica3 = new BankOfAmerica(accountDataHolderList.get(2).getAccountNumber(), accountDataHolderList.get(2).getRoutingNumber());
        Assert.assertEquals(accountDataHolderList.get(2).getBalance(), bankOfAmerica3.getBalance(), 0.0);

 */


    //H/W implement Datatable with List of object. and execute withdraw for a specific account.
    @When("^the users withdraw$")
    public void the_users_withdraw(List<WithdrawDataContainer> withdrawDataContainersList) throws Throwable {

        for (BankBase bank : banks) {
            for (WithdrawDataContainer oneWithdraw : withdrawDataContainersList) {
                if (bank.getAccountNumber() == oneWithdraw.getAccountNumber()) {
                    bank.withDraw(oneWithdraw.getWithdrawAmount());
                }
            }
            System.out.println();
        }
    }

    @Then("^the users have the following balances$")
    public void the_users_have_the_following_balances(List<BalanceCheckContainer> balanceCheckContainerList) throws Throwable {


        for (BankBase bank : banks) {
            for (BalanceCheckContainer oneWithdraw : balanceCheckContainerList) {
                if (bank.getAccountNumber() == oneWithdraw.getAccountNumber()) {
                    double actual = bank.getBalance();
                    double expected = oneWithdraw.getBalance();
                    Assert.assertEquals(expected, actual, 0.0);
                }
            }

        }
    }
}