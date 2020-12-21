package utilities;

import gherkin.lexer.De;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import step_definitions.amazon.AmazonSearchSteps;

public class SeleniumUtils {

    private static final Logger LOG = LogManager.getLogger(SeleniumUtils.class.getName());


    /**
     * Method open url in browser
     *
     * @param url
     */


    public static void goTo(String url) {
        Driver.getDriver().get(url);

        LOG.info("Opened Amazon url: {}", url);

    }

    public static void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
        LOG.info("Send keys to element and text is {}", text);

    }


    public static void click(WebElement element){
        element.click();
        LOG.info("Successfully clicked on element.");
    }
}
