package step_definitions.accounts;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioOutlineSteps {
    @Given("^user with \"([^\"]*)\" and password \"([^\"]*)\" is registered$")
    public void user_with_and_password_is_registered(String username, String password) throws Throwable {
        System.out.println("username " + username + " password " + password);

    }

    @When("^user with \"([^\"]*)\" and \"([^\"]*)\" logs in$")
    public void user_with_and_logs_in(String username, String password) throws Throwable {
        System.out.println("username " +username + " password  "+ password);
    }

    @Then("^user should see the \"([^\"]*)\"$")
    public void user_should_see_the(String message) throws Throwable {
        System.out.println("massaga" + message);
        System.out.println();
    }

}
