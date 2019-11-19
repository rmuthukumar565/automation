package stepDefinitions;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				 "pretty", "html:target/cucumberHtmlReport",
			     "html:target/cucumberHtmlReport",     //  for html result
				 "pretty:target/cucumber-json-report.json"   // for json result
			     },
			features = "classpath:features/PlaceOrder_SignedInUser.feature",
			glue = {"stepDefinitions"}
 )
public class TestRunner {

}
