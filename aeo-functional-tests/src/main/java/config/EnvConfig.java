package config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class EnvConfig {
	static WebDriver driver = null;
	static String browserName = null;

	public static String getBrowserName() {
		browserName = System.getProperty("browser");

		if (browserName == null)
			browserName = "ch";
		return browserName;
	}

	public static WebDriver CreateWebDriver(String browser) {
		System.out.println("Browser: " + browser);

		switch (browser.toLowerCase()) {
		case "ff":
		case "firefox":
			System.out.println("Firefox is selected");
			// ProfilesIni allProfiles = new ProfilesIni();
			// FirefoxProfile profile = allProfiles.getProfile("selenium");
			driver = new FirefoxDriver();
			break;

		case "ch":
		case "chrome":
			System.out.println("Google chrome is selected");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +File.separator+"src"
					+ File.separator + "test" + File.separator + "resources" + File.separator + "driver"+File.separator +"chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "ie":
		case "internetexplorer":
			System.out.println("Internet Explorer is selected");
			driver = new InternetExplorerDriver();
			break;

		case "safari":
			System.out.println("Safari is selected");
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Invalid browser name " + browser);
			System.exit(0);
			break;
		}// switch

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}
}
