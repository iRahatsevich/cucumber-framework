package step_definitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.digitalBank.DigitalBankLoginPage;

public class Test {

    private static final Logger LOG = LogManager.getLogger(Test.class.getName());

    //    private static final Logger LOG = LogManager.getLogger(Test.class); //same as line above
    //    private static final Logger LOG = LogManager.getLogger(); //will not add class name to the logger

    public static void main(String[] args) {

        LOG.info("it is our first log");
        LOG.error("i got error from such file");
        LOG.debug("i enter login website ");
        LOG.trace("this is main class");
        LOG.fatal("this is fatal msg");
        LOG.warn("be careful");

        String title = "home page";
        LOG.info("This is my title " + title);
        LOG.info("This is my title {}", title);

        int num = 5;
        LOG.info("this is my {} title {}", num, title);  //first {} will be added num , second {} will be title string

        DigitalBankLoginPage d = new DigitalBankLoginPage();
        d.getName(); // == new DigitalBankLoginPage().getName();
    }
}
