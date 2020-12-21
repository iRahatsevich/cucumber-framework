package step_definitions;

import application.BankBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Driver;


/**
     * Hooks will run as long as its under the step_defs folder
     * hooks are used to perform the operations that are needed for the application to be ready
     * to execute the test. these operations are not related to business logic.
     * but these are more of a technical operations.
     *
     * ex: reset caches of application
     * ex:clear data in db that was populated by the previous test
     * ex: bring the browser back to the home after the test is done or before executing the test
     * to make sure your tests start from an expected page
     */

//Hooks can ONLY be in steps definitions
    public class Hooks {
        private static boolean isExecuted = false;
//runs before every single scenario in every feature file
    //runs before background

    private static Logger logger;

    @Before
    public void beforeHook(){
        logger = LogManager.getLogger();

        logger.traceEntry();
        logger.traceEntry("enter the application");
        logger.info("-----start running scenario --------");

        System.out.println("Running before hook");
        BankBase.accountStorage.clear();
    }

    //Runs after every single scenario in every feature file
    //will run after the scenario regardless of the result of the test. pass or fail.
    //so it's guaranteed to run
    @After
    public void afterHook(){

     //   logger.traceExit(); //no need for all 3 lines just 1 is fine
        logger.traceExit("exit the application");
      //  logger.info("-----stop running scenario-------");

        System.out.println("Running after");
    }


    //will run only before scenarios that have @smoke tag
    @Before("@smoke")
    public void beforeSmoke(){
        System.out.println("before smoke");

    }

    //will run only before scenarios that have @smoke tag
    @After
    public void tearDriver() {

        Driver.closeDriver();
    }


    //Junit and testNG have beforeClass and beforeSuite
    //cucumber doesnt have that option
    //so we need to hack that gap
    @Before
    public void onceBeforeAllTests(){
        if(!isExecuted){
            System.out.println("setting up environment before running regression");
            isExecuted = true;
        }
    }



}