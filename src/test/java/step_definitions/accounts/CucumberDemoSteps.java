package step_definitions.accounts;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberDemoSteps {

    @Given("^User is logged in to chase account$")
    public void user_is_logged_in_to_chase_account() throws Throwable {
        System.out.println("user is logged in to chase");
    }

    @Then("^John Doe should have (\\d+) deposited$")
    public void john_Doe_should_have_deposited(int arg1) throws Throwable {
        System.out.println("john_Doe_should_have_deposited");
    }

    @Then("^John Doe should not have (\\d+) deposited$")
    public void john_Doe_should_not_have_deposited(int arg1) throws Throwable {
        System.out.println("John DOe should not have anything deposited.");
    }

    @Given("^User has (\\d+) in the account$")
    public void user_has_in_the_account(int arg1) throws Throwable {
        System.out.println("Given Step User has some dollars in the account");
    }

    @When("^User deposits -(\\d+) to John Doe$") // --> this is regex inside parenthesis
    public void user_deposits_to_John_Doe(int arg1) throws Throwable {
        System.out.println("User deposits negative value");
    }

    @Then("^User should have (\\d+)$")
    public void user_should_have(int arg1) throws Throwable {
        System.out.println("User should have some money");
    }

    @Then("^John Doe Should not any deposits$")
    public void john_Doe_Should_not_any_deposits() throws Throwable {
        System.out.println("John Doe Should not any any deposits step");
    }

    @When("^User deposits \\$(\\d+) to John Doe$")
    public void user_deposits_$_to_John_Doe(int arg1)  {
        System.out.println("User deposits some dollars to John Doe");
    }
}