package com.WebDevelopment.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.WebDevelopment.Helper.*;
import com.WebDevelopment.utilities.ReadConfig;

/**
 * Base Class for Initial setup Before starting Test.
 */

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public static WebDriver driver;
	public static JavaScriptExecute js;
	public static SelectHelper select;
	public static ActionHelper action;
	public static WebDriverWait wait;
	public static GetCalender date;

	/**
	 * 
	 * Setup method for initialize driver and common utilities.
	 * 
	 * @param br      {@link String} browser name.
	 * @param context {@link ITestContext}
	 */
	@Parameters("browser")
	@BeforeTest
	public void setup(String br) {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		js = new JavaScriptExecute(driver);
		action = new ActionHelper(driver);
		select = new SelectHelper();
		wait = new WebDriverWait(driver, 60);

		date = new GetCalender();
	}

	/**
	 * Close Browser After Completing the test.
	 */
	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

}
