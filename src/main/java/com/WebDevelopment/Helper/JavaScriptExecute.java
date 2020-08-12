package com.WebDevelopment.Helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * JavaScript Executor for Interaction with DOM Elements.
 * 
 */
public class JavaScriptExecute {

	JavascriptExecutor js;
	
/**
 * Parameterize constructor
 * 
 * @param driver {@link ChromeDriver}
 */
	public JavaScriptExecute(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	
	/**
	 * Click on WebElement 
	 * 
	 * @param ele {@link WebElement}
	 */
	public void click(WebElement ele) {

		js.executeScript("arguments[0].click()", ele);

	}
	
	/**
	 * Send the value for text 
	 * 
	 * @param str {@link String}
	 * @param ele  {@link WebElement}
	 */
	public void sendKeys(String str ,WebElement ele) {

	//	js.executeScript("arguments[0].value=.click()", ele);
		js.executeScript("arguments[0].value='"+ str +"';", ele);
	}
}
