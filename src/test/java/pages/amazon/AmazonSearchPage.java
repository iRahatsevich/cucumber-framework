package pages.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonSearchPage {


    private static final Logger LOG = LogManager.getLogger(AmazonSearchPage.class.getName());
    private WebDriver driver;

    public AmazonSearchPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchField;

    @FindBy(id = "nav-search-submit-text")
    public WebElement searchButton;


    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElement> searchResulsTitles;

    @FindBy(xpath = "//li[@aria-label='Free Shipping by Amazon']//input")
    public WebElement freeShippingCheckbox;




}
