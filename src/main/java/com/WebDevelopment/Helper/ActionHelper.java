package com.WebDevelopment.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Action Hepler for interaction with GUI.
 *
 */
public class ActionHelper {

	Actions action;

	/**
	 * Paramerterize constructor
	 * 
	 * @param driver {@link WebDriver}
	 */
	public ActionHelper(WebDriver driver) {

		action = new Actions(driver);
	}

	/**
	 * Drag And Drop The Element
	 * 
	 * @param source {@link WebElement}
	 * @param target {@link WebElement}
	 */
	public void DragAndDrop(WebElement source, WebElement target) {
		action.dragAndDrop(source, target);

	}
	
	
	public void moveToElementAndclick(WebElement target) {
		
		action.moveToElement(target).build().perform();
		action.click();
	}

}
