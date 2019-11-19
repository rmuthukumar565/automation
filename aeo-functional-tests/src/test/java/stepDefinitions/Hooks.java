package stepDefinitions;

import config.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks implements BaseTest {

	
	@After()
	public void beforeScenario(Scenario scenario) throws NumberFormatException, InterruptedException {
	   driver.manage().deleteAllCookies();
		
		
	}

}
