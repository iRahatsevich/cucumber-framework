package runners;


//chose 10 scenarios among all features to be included in the smoke test
//implement smoke test runner



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //folder of feature files to be considered(scanned) for run
        features = {"classpath:features"}, // classpath --> target > test-class > features
        //specify the package of steps defs
        glue = {"step_definitions"}, // glue is a path to our step defs / step defs is what we use to implement feature file
        //json is responsible for creating(generating) junit reports in json format
        plugin = {"json:target/cucumber.json" , "pretty", "html:target/reports"},
        //format ={"pretty", "html:target/reports"}, format is old version. in new version (6.6.0) is plugin


        //when set true it will generate step def snippet. dry run is not used much
        dryRun = false // usually is false(then run as it should be)/ if its true and new steps dont have step defs it will generate it and will not run the code
        //is there anyway i can run only specific features ?
        //ex: smoke or regression
        // tags = {"@smoke", "~@ignore"} //it goes to only feature files. if you put on top of feature file it will be applicable to all scenarios in feature file
        //or you can add to separate scenarios
        //~ --> means exclude @ignore --> this can be any word
//you can have multiple tags for one feature file
        //they will be next to each other @regression @smoke

)
        public class SmokeRunner {
}
