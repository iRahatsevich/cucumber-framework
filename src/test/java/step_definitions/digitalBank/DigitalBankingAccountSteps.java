package step_definitions.digitalBank;

import cucumber.api.DataTable;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class DigitalBankingAccountSteps {

    WebDriver driver = Driver.getDriver();

    @Then("^Verify that Home button is displayed$")
    public void verify_that_Home_button_is_displayed() throws Throwable {

        WebElement homeButton = driver.findElement(By.xpath("//a[@href='/home']"));

        Assert.assertTrue(homeButton.isDisplayed());


    }

    @Then("^Verify that \"([^\"]*)\".* is displayed$")
    public void verify_that_button_is_displayed(String word) throws Throwable {


        WebElement accountBalanceSummary = driver.findElement(By.xpath("//*[contains(text() , '" + word + "')]"));
        //  Assert.assertTrue(accountBalanceSummary.isDisplayed());
        Thread.sleep(10000);
        Assert.assertEquals(word, accountBalanceSummary.getText());

        //   System.out.println(accountBalanceSummary.getText());
    }


    @Then("^Verify that under \"([^\"]*)\" we have options$")
    public void verify_that_under_we_have_options(String mainButton, List<String> options) throws Throwable {

//        List<String> dataTableList = options.asList(String.class);
//        WebElement checking = driver.findElement(By.xpath("//a[@href='#'][text()='"+mainButton+"']"));
//
//        Thread.sleep(3000);
//        Assert.assertTrue("verifying checking option", dataTableList.get(0).equals(checking.getText()));
//
//        WebElement savings = driver.findElement(By.xpath("//a[@id='savings-menu'][text()='Savings']"));
//        Assert.assertTrue("savings option", dataTableList.get(1).equalsIgnoreCase(savings.getText()));
//
//        WebElement transactions = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Transactions']"));
//        Assert.assertTrue("transaction option", dataTableList.get(2).equalsIgnoreCase(transactions.getText()));
//
//        WebElement transfer = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Transfer']"));
        // Assert.assertTrue("transfer button", dataTableList.get(0).equals(transfer.getText()));

        WebElement headButton = driver.findElement(By.xpath("//a[text()='" + mainButton + "']"));
//        driver.findElement(By.xpath("//a[text()='Savings']"));
        headButton.click();
        List<WebElement> listOptionButtons = driver.findElements
                (By.xpath("//a[text()='" + mainButton + "']/following-sibling::" +
                        "ul[@class='sub-menu children dropdown-menu show']//a"));
        for (int i = 0; i < listOptionButtons.size(); i++) {
            Assert.assertTrue(options.contains(listOptionButtons.get(i).getText()));
        }
    }


    @When("^User clicks on Checking button$")
    public void user_clicks_on_Checking_button() throws Throwable {
        Thread.sleep(3000);

        WebElement checkingButton = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and text()='Checking']"));
        Thread.sleep(3000);
        checkingButton.click();

    }

    @When("^User clicks on New Checking button$")
    public void user_clicks_on_New_Checking_button() throws Throwable {

        WebElement newCheckingButton = driver.findElement(By.xpath("//a[@href='/account/checking-add']"));
        newCheckingButton.click();
    }

//    @When("^User clicks on \"([^\"]*)\" button$")
//    public void user_clicks_on_button(String arg1) throws Throwable {
//
//    }

    @When("^User clicks on Submit button$")
    public void user_clicks_on_Submit_button() throws Throwable {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and contains(text(), 'Submit')]"));
        submitButton.click();

    }


    @When("^Verify that New Checking Account text is displayed$")
    public void verify_that_New_Checking_Account_text_is_displayed() throws Throwable {

    }


    @When("^Verify that radio buttons are unchecked$")
    public void verify_that_radio_buttons_are_unchecked() throws Throwable {

    }

    @When("^Verify that input field accepts alphanumeric and special characters$")
    public void verify_that_input_field_accepts_alphanumeric_and_special_characters() throws Throwable {

    }

    @When("^Verify that input field accepts numeric whole or decimal values$")
    public void verify_that_input_field_accepts_numeric_whole_or_decimal_values() throws Throwable {

    }

    @When("^Verify that \"([^\"]*)\" we have options$")
    public void verify_that_we_have_options(String arg1) throws Throwable {

    }

    @When("^User should get error message \"([^\"]*)\"$")
    public void user_should_get_error_message(String msg) throws Throwable {

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Failed: Validation error message mismatch", msg, driver.switchTo().activeElement().getAttribute("validationMessage"));

    }

    @When("^User clicks on \"([^\"]*)\" radio button$")
    public void user_clicks_on_radio_button(String radioButton) throws Throwable {
        WebElement standardCheckingRadioButton = driver.findElement(By.xpath("//input[@id='" + radioButton + "']"));

        standardCheckingRadioButton.click();
    }

    @When("^User enters .* \"([^\"]*)\"$")
    public void user_enters_name(String arg1) throws Throwable {

    }


}
