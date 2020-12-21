package step_definitions.digitalBank;


import com.github.javafaker.Faker;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domains.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DigitalBankRegistrationSteps {
    String actualTitle;

    WebDriver driver = Driver.getDriver();
    private final String LOGIN_PAGE_URL = "http://dbankdemo.com/login";
    private final String HOME_PAGE_URL = "http://dbankdemo.com/home";

    private String username;
    private String password;

    private static final Logger LOG = LogManager.getLogger(DigitalBankRegistrationSteps.class.getName());

    @Given("^User navigate to Digital Bank application login page$")
    public void user_navigate_to_Digital_Bank_application_login_page() throws Throwable {
        LOG.debug("use url {}", LOGIN_PAGE_URL);
        driver.get(LOGIN_PAGE_URL);
        LOG.info("Login page is opened");

        try {
            LOG.debug("assert that actual url is as expected");
            Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(LOGIN_PAGE_URL);
            LOG.info("assertion for url has passed");
        } catch (Exception e) {
            LOG.error("error is here");
            throw e;
        }


        String title = driver.getTitle();
        if (title.equals("Home page")) {
            LOG.error("");
        }
        //compare w yurii code
    }


    @Given("^Verify title is \"([^\"]*)\"$")
    public void verify_title_is(String expectedTitle) throws Throwable {
        Thread.sleep(3000);
        Assertions.assertThat(driver.getTitle()).isEqualTo(expectedTitle);
        LOG.info("title {} is correct", expectedTitle);
    }

    @When("^user enters username and password$")
    public void user_enters_username_and_password(DataTable dataTable) throws Throwable {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        driver.findElement(By.id("username")).sendKeys(credentials.get(0).get("username"));

        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys(credentials.get("username"));

        driver.findElement(By.id("password")).sendKeys(credentials.get(0).get("password"));
        driver.findElement(By.id("submit")).click();


        //dataTable as list
        //List<String> dataTable)


        //List<List<String>>
        //          row     column
        //dataTable.get(0).get(0)

        //if one roa Map<String, String> dataTable
        //dataTable.getKey(username)
        //dataTable.getKey(password)


        //if multiple row we can use List<Map<String, String>>
        //          row
        //dataTable.get(0).getKey(username)
        //dataTable.get(0).getKey(password)


    }

    @Then("^user successfully login to home page$")
    public void user_successfully_login_to_home_page() throws Throwable {

        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(HOME_PAGE_URL);
        WebElement welcomeLink = driver.findElement(By.xpath("//li[contains(text(),'Welcome')]"));
        Assertions.assertThat(welcomeLink.getText()).contains("Welcome");

    }


    @Then("^user should see error message \"([^\"]*)\"$")
    public void user_should_see_error_message(String errorMsg) throws Throwable {
        WebElement error = driver.findElement(By.xpath("//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']"));
        System.out.println(error.getText());
        Assertions.assertThat(error.getText().contains("Error Invalid credentials or access not granted."));
//        Assert.assertEquals(errorMsg, error.getText());

    }

    @Given("^User navigate to Digital Bank application register page$")
    public void user_navigate_to_Digital_Bank_application_register_page() throws Throwable {
        System.out.println("Login register page");


        WebElement signUpButton = driver.findElement(By.xpath("//a[contains(text() , 'Sign Up Here')]"));
        signUpButton.click();

        WebElement titleWord = driver.findElement(By.xpath("//strong[text()='Title']"));

        Assert.assertTrue(titleWord.isDisplayed());

    }

    @When("^user creates account with following fields$")
    public void user_creates_account_with_following_fields(DataTable dataTable) throws Throwable {

//
//
//
//        WebElement firstname = driver.findElement(By.id("#firstName"));
//

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        List<Users> userList = dataTable.asList(Users.class);

        WebElement selectTitle = driver.findElement(By.id("title"));
        Select dropdown = new Select(selectTitle);
        dropdown.selectByValue(userList.get(0).getTitle());

        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys(userList.get(0).getFirstName());

        WebElement lastname = driver.findElement(By.id("lastName"));
        lastname.sendKeys(userList.get(0).getLastName());


        Faker fake = new Faker();
        String emailFaker = fake.internet().emailAddress();
        String SSN = fake.regexify("[0-8]\\d{2}-\\d{2}-\\d{4}");
        String homePhoneFaker = fake.regexify("\\([0-8]\\d{2}\\)\\d{3}-\\d{4}");
        String mobilePhoneFaker = fake.regexify("\\([0-8]\\d{2}\\)\\d{3}-\\d{4}");
        String workPhoneFaker = fake.regexify("\\([0-8]\\d{2}\\)\\d{3}-\\d{4}");

        username = emailFaker;
        password = userList.get(0).getPassword();

        List<WebElement> gender = driver.findElements(By.id("gender"));

        for (WebElement element : gender) {

            if (element.getAttribute("value").equalsIgnoreCase(userList.get(0).getGender())) {

                element.click();
            }
        }


        WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
        dob.sendKeys(userList.get(0).getDob());

        WebElement ssn = driver.findElement(By.xpath("//input[@id='ssn']"));
        //  ssn.sendKeys(userList.get(0).getSSN());
        ssn.sendKeys(SSN);

        WebElement email = driver.findElement(By.xpath("//input[@id='emailAddress']"));
//        email.sendKeys(userList.get(0).getEmail());
        email.sendKeys(emailFaker);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(userList.get(0).getPassword());

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        confirmPassword.sendKeys(userList.get(0).getPassword());

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement address = driver.findElement(By.cssSelector("#address"));
        address.sendKeys(userList.get(0).getAddress());

        WebElement locality = driver.findElement(By.cssSelector("#locality"));
        locality.sendKeys(userList.get(0).getLocality());

        WebElement region = driver.findElement(By.cssSelector("#region"));
        region.sendKeys(userList.get(0).getRegion());


        WebElement postcode = driver.findElement(By.cssSelector("#postalCode"));
        postcode.sendKeys(userList.get(0).getPostalCode());

        WebElement country = driver.findElement(By.cssSelector("#country"));
        country.sendKeys(userList.get(0).getCountry());

        WebElement homePhone = driver.findElement(By.id("homePhone"));
        homePhone.sendKeys(homePhoneFaker);

        WebElement mobilePhone = driver.findElement(By.id("mobilePhone"));
        mobilePhone.sendKeys(mobilePhoneFaker);

        WebElement workPhone = driver.findElement(By.id("workPhone"));
        workPhone.sendKeys(workPhoneFaker);

        WebElement agreeButton = driver.findElement(By.cssSelector("#agree-terms"));
        agreeButton.click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("^user should see \"([^\"]*)\" message$")
    public void user_should_see_message(String expectedMsg) throws Throwable {
        WebElement registrationMessage = driver.findElement(By.xpath("//span[text()='Registration Successful. Please Login.']"));

        // Assert.assertTrue(registrationMessage.getText().contains(expectedMsg));
        Assert.assertEquals("Registration Successful. Please Login.", registrationMessage.getText());
    }

    @Then("^User should be able to login to the new account with title \"([^\"]*)\"$")
    public void user_should_be_able_to_login_to_the_new_account_with_title(String title) throws Throwable {
        WebElement userNameElement = driver.findElement(By.id("username"));
        userNameElement.clear();

        userNameElement.sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        Assertions.assertThat(driver.getTitle()).isEqualTo(title);
    }

}


