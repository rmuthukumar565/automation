package methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import config.BaseTest;

public class InputMethods extends SelectElementByType implements BaseTest {
	
	private WebElement dropdown =null;
	private Select selectList=null;
	
	
	public void enterText(String accessType,String text,String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).sendKeys(text);
	}
	
	public void enterText(By locator,String text)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).sendKeys(text);
	}
	
	
	public void clearText(String accessType, String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).clear();
	}
	
	
	public void selectelementfromdropdownbytype (Select select_list, String bytype, String option)
	{
		System.out.println("**"+bytype+"++"+option);
		if(bytype.equals("selectByIndex"))
		{
			int index = Integer.parseInt(option);
			select_list.selectByIndex(index-1);
		}
		else if (bytype.equals("value"))
			select_list.selectByValue(option);
		else if (bytype.equals("text"))
			select_list.selectByVisibleText(option);
	}
	
	
	public void selectOptionFromDropdown(String accessType, String by, String option, String accessName)
	{
		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		selectelementfromdropdownbytype(selectList,by,option);
	}
	
	
	public void unselectAllOptionFromMultiselectDropdown(String accessType, String accessName)
	{
		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		selectList.deselectAll();
	}
	
	
	public void checkCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if (!checkbox.isSelected())
			checkbox.click();
	}
	
	
	public void uncheckCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if (checkbox.isSelected())
			checkbox.click();
	}
	
	public void toggleCheckbox(String accessType, String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName))).click();
	}
	
	
	public void selectRadioButton(String accessType, String accessName)
	{
		WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if(!radioButton.isSelected())
			radioButton.click();
	}
	
	
	public void selectOptionFromRadioButtonGroup(String accessType, String by, String option, String accessName)
	{
		List<WebElement> radioButtonGroup = driver.findElements(getelementbytype(accessType, accessName));
		String getoption = null;
		
		for(WebElement temp : radioButtonGroup)
		{
			if(by.equals("value"))
			{
				System.out.println("+++"+temp.getAttribute("value"));
				getoption = temp.getAttribute("value");
			}
			else
			{
				System.out.println("***"+temp.getText());
				getoption = temp.getText();
			}
			System.out.println("Element : "+getoption);
			if(getoption.equals(option) && !temp.isSelected())
				temp.click();
		}
		
	}

}
