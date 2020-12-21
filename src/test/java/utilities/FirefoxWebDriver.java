package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class FirefoxWebDriver {

    public static WebDriver loadFirefoxWebDriver(){

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
//there are only 7 / 8 options for firefox but they are mostly used for profile in firefox
        options.setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless"))); // built in firefox options class
        //options.addArguments("-headless"); // also possible , but need to be checked before using

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        return driver;

    }
}



