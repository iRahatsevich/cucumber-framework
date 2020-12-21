package step_definitions.amazon;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.amazon.AmazonSearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearchSteps {

    WebDriver driver = Driver.getDriver();

    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();

    List<WebElement> topFiveResults;

    private static final Logger LOG = LogManager.getLogger(AmazonSearchSteps.class.getName());


    @Given("^go to amazon\\.com$")
    public void go_to_amazon_com() throws Throwable {
        SeleniumUtils.goTo(ConfigReader.getProperty("url"));

    }

    @When("^enter search term \"([^\"]*)\"$")
    public void enter_search_term(String searchTerm) throws Throwable {

        SeleniumUtils.sendKeys(amazonSearchPage.searchField, searchTerm); // same as below , this one is created in case somithing changes we need to modify just in one place
        // amazonSearchPage.searchField.sendKeys(searchTerm);
    }

    @When("^click Search button$")
    public void click_Search_button() throws Throwable {

        SeleniumUtils.click(amazonSearchPage.searchButton);
    }

    @Then("^verify that result \"([^\"]*)\" is displayed in the results$")
    public void verify_that_result_is_displayed_in_the_results(String expectedTitle) throws Throwable {

        for (WebElement title : amazonSearchPage.searchResulsTitles) {
            if (title.getText().contains(expectedTitle)) {
                Assert.assertTrue(title.getText().contains(expectedTitle));
                LOG.info("The title {} is displayed", expectedTitle);
                break;
            }
        }
    }

    @Then("^clear the search field$")
    public void clear_the_search_field() throws Throwable {
        amazonSearchPage.searchField.clear();
        LOG.info("Webelement is cleared");
    }


    @Then("^verify that result \"([^\"]*)\" is not displayed in the results$")
    public void verify_that_result_is_not_displayed_in_the_results(String expectedTitle) throws Throwable {

        for (WebElement title : amazonSearchPage.searchResulsTitles) {
            LOG.info(title.getText());
            Assert.assertFalse(title.getText().contains(expectedTitle));
            LOG.info("Element with title {} is not displayed", expectedTitle);
        }

    }

    @Then("^verify at least three results contain term \"([^\"]*)\"$")
    public void verify_at_least_three_results_contain_term(String expectedKeyword) throws Throwable {
        List<WebElement> listWithExpectedKeyword = new ArrayList<>();

        for (WebElement title : amazonSearchPage.searchResulsTitles) {
            if (title.getText().contains(expectedKeyword)) {
                listWithExpectedKeyword.add(title);
                LOG.info("List of elements which contain keyword: {} -> {}", expectedKeyword, title.getText());
            }
        }
        Assert.assertTrue(listWithExpectedKeyword.size() > 3);


    }

    @Then("^verify free shipping checkbox is not selected$")
    public void verify_free_shipping_checkbox_is_not_selected() throws Throwable {

        Assert.assertFalse(amazonSearchPage.freeShippingCheckbox.isSelected());

    }

    @Then("^check free shipping checkbox$")
    public void check_free_shipping_checkbox() throws Throwable {

        amazonSearchPage.freeShippingCheckbox.click();
    }

    @Then("^verify top five results are still the same$")
    public void verify_top_five_results_are_still_the_same() throws Throwable {

        topFiveResults = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (WebElement title : amazonSearchPage.searchResulsTitles) {
                topFiveResults.add(title);
            }

        }

    }
}






