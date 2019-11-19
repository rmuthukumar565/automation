package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import config.BaseTest;

public class AssertionMethods extends SelectElementByType implements BaseTest {

	private WebElement element=null;
	
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getElementText(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getText();
		
	}
	
	public void checkElementText(String accessType,String actualValue,String accessName,boolean testCase) throws TestCaseFailed
	{
		String elementText = getElementText(accessType, accessName);
		
		if (testCase)
		{
			if (!elementText.equals(actualValue))
				throw new TestCaseFailed("Text Not Matched");
		}
		else
		{
			if (elementText.equals(actualValue))
				throw new TestCaseFailed("Text Matched");
		}
	}
	
	public boolean isElementEnabled(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.isEnabled();
	}
	
	public String getElementAttribute(String accessType,String accessName,String attributeName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getAttribute(attributeName);
	}
	
	public boolean isElementDisplayed(String accessType,String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.isDisplayed();
	}
	
	public void isCheckboxChecked(String accessType,String accessName,boolean shouldBeChecked) throws TestCaseFailed
	{
		WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if((!checkbox.isSelected()) && shouldBeChecked)
			throw new TestCaseFailed("Checkbox is not checked");
		else if(checkbox.isSelected() && !shouldBeChecked)
			throw new TestCaseFailed("Checkbox is checked");
	}
	
	public void isRadioButtonSelected(String accessType,String accessName,boolean shouldBeSelected) throws TestCaseFailed
	{
		WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if((!radioButton.isSelected()) && shouldBeSelected)
			throw new TestCaseFailed("Radio Button not selected");
		else if(radioButton.isSelected() && !shouldBeSelected)
			throw new TestCaseFailed("Radio Button is selected");
	}
	
	public String getAlertText()
	{
		return driver.switchTo().alert().getText();
	}
	
	public void isOptionFromDropdownSelected(String accessType,String by,String option,String accessName,boolean shouldBeSelected) throws TestCaseFailed
	{
		Select selectList=null;
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		
		String actualValue=null;
		if(by.equals("text"))
			actualValue = selectList.getFirstSelectedOption().getText();
		else
			actualValue = selectList.getFirstSelectedOption().getAttribute("value");
		
		if((!actualValue.equals(option))&&(shouldBeSelected))
			throw new TestCaseFailed("Option Not Selected From Dropwdown");
		else if ((actualValue.equals(option))&&(!shouldBeSelected))
			throw new TestCaseFailed("Option Selected From Dropwdown");
	}
	
	public String getElementTextByLoc(By locator)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element.getText();
		
	}
	
	
	
}
