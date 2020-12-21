package step_definitions.accounts;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.Random;

public class JavaFSteps {

    String firstName = null;
    String lastName = null;
    Faker faker = new Faker();


    public String generateString() {
        Random rnd = new Random();
        String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int index = rnd.nextInt(data.length());
            sb.append(data.charAt(index));
        }


        return sb.toString();
    }


    @Given("^User generate last name and first name$")
    public void user_generate_last_name_and_first_name() throws Throwable {

      firstName = generateString();
      lastName = generateString();

    }

    @Given("^User generate address info$")
    public void user_generate_address_info() throws Throwable {

    }

    @Then("^Customer info should be printed$")
    public void customer_info_should_be_printed() throws Throwable {
        System.out.println(firstName +" is the first name and last name is "+ lastName);



    }

    @Given("^User generate last name and first name with JF$")
    public void user_generate_last_name_and_first_name_with_JF() throws Throwable {

        firstName = faker.name().firstName();

lastName = faker.name().lastName();

    }

    @Given("^User generate address info with JF$")
    public void user_generate_address_info_with_JF() throws Throwable {

        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().city());
        System.out.println(faker.address().country());
        System.out.println();
        System.out.println(faker.chuckNorris().fact());


    }


}
