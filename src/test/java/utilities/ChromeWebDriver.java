package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeWebDriver {

    //same as ChromeDriver() - creates an object of default Chrome browser
    public static WebDriver loadChromeWebDriver(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximize"); // will maximize the browser
        options.addArguments("--disable-extensions"); // extensions -> plugins you downloaded for your browser
        options.addArguments("--window-size=1920,1080"); // size of window. this one is standard

        if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))){
            options.addArguments("--headless"); // also can use method .setHeadless()
        }

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        //normally no page load timeout is neede here because it may fail your test

        return driver;
    }


}



