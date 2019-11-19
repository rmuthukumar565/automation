package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import config.BaseTest;

public class ClickElementsMethods extends SelectElementByType implements BaseTest {

	private WebElement element = null;

	public void click(String accessType, String accessName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		element.click();
	}
	
	public void click(By locator) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.click();
	}

}
