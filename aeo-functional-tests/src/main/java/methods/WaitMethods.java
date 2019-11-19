package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.BaseTest;

public class WaitMethods extends SelectElementByType implements BaseTest {

	public void waitForElementToDisplay(By locator,String duration)
	{
		WebDriverWait wait = (new WebDriverWait(driver,Integer.parseInt(duration)*1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void wait(String time) throws NumberFormatException, InterruptedException
	{
		Thread.sleep(Integer.parseInt(time)*1000);
		
	}
}
