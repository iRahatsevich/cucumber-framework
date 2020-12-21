package pages.digitalBank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DigitalBankLoginPage {

    private static final Logger LOG = LogManager.getLogger(DigitalBankLoginPage.class.getName());

    private WebDriver driver;

    public DigitalBankLoginPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "")
    public WebElement hotelTab;

    public void getName() {
        try {
            System.out.println(1/0);

        } catch (Exception e) {
            LOG.error("Give error on divide 1 to 0" , e);
        }
    }
}





