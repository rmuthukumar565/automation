package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import config.BaseTest;

public class NavigateMethods extends SelectElementByType implements BaseTest {
	private WebElement element = null;

	public void navigateTo(String url) {
		driver.get(url);
	}

	public void closeDriver() {
		driver.quit();
	}

	public void resizeBrowser(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	/** Method to maximize browser */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void closeNewWindow() {
		driver.close();

	}

	public void scrollToElement(By locator) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void hoverOverElement(By locator) {
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		action.moveToElement(element).perform();
	}

	public void switchFrameByNameorId(String nameorid) {
		driver.switchTo().frame(nameorid);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

}
