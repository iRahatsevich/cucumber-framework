package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


//runner classes are needed in order to execute batch of feature files.
//ex: Regression

//runner classes can be implemented Junit Runner or TestNG runner




@RunWith(Cucumber.class)
@CucumberOptions(
        //folder of feature files to be considered(scanned) for run
        plugin= {"json:target/cucumber.json"},
        features = {"classpath:features"}, // classpath --> target > test-class > features // path to the features folder . also can write it as -> {"src/test/resources/features"}
        //specify the package of steps defs
        glue = {"step_definitions"}, // glue is a path to our step defs / step defs is what we use to implement feature file
        //json is responsible for creating(generating) junit reports in json format


        tags = {"@regression"},
        format ={"pretty", "html:target/reports"},
        //when set true it will generate step def snippet. dry run is not used much
        dryRun = false // usually is false(then run as it should be)/ if its true and new steps dont have step defs it will generate it and will not run the code
        //is there anyway i can run only specific features ?
        //ex: smoke or regression
       // tags = {"@regression", "~@ignore"} //it goes to only feature files. if you put on top of feature file it will be applicable to all scenarios in feature file
        //or you can add to separate scenarios
        //~ --> means exclude @ignore --> this can be any word
//you can have multiple tags for one feature file
        //they will be next to each other @regression @smoke


)
public class RegressionRunner {



}
