package runners;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"}, // path to the features folder . also can write it as -> {"src/test/resources/features"}
        glue = {"step_definitions"},
        plugin = {"json:target/cucumber.json" , "pretty", "html:target/reports"},
       // format ={},
        dryRun = true,

        tags= {"@search_one"}

)
public class CukesRunner {
}
