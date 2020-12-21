package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestTwo {
    private static final Logger LOG = LogManager.getLogger(TestTwo.class.getName());

    //    private static final Logger LOG = LogManager.getLogger(Test.class); //same as line above
    //    private static final Logger LOG = LogManager.getLogger(); //will not add class name to the logger

    public static void main(String[] args) {

        LOG.info("it is our first log");
        LOG.error("i got error from such file");
        LOG.debug("i enter login website ");
        LOG.trace("this is main class");
        LOG.fatal("this is fatal msg");
        LOG.warn("be careful");
    }
}