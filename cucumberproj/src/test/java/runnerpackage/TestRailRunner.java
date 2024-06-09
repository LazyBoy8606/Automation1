package runnerpackage;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/runnerpackage/", tags = {"@tag2"},
		glue = {"stepdef","runnerpackage"},
		plugin= {"pretty","html:target/cucumber-html"})


public class TestRailRunner {
	

}
