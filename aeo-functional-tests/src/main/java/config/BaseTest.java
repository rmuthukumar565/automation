package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import methods.AssertionMethods;
import methods.ClickElementsMethods;
import methods.InputMethods;
import methods.NavigateMethods;
import methods.WaitMethods;

public interface BaseTest {
	public static WebDriver driver = EnvConfig.CreateWebDriver(EnvConfig.getBrowserName());
	public static WebDriverWait wait = new WebDriverWait(driver, 30);
	
	ClickElementsMethods clickElementsMethods = new ClickElementsMethods();
	AssertionMethods assertionMethods = new AssertionMethods();
	InputMethods inputMethods = new InputMethods();
	NavigateMethods navigateMethods = new NavigateMethods();
	WaitMethods waitMethods = new WaitMethods();
}
