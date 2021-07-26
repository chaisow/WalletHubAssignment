package org.walletHub.webElementExtension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/***
 * This class has all the browser control wrapper methods
 * @author apoorvdwivedi
 *
 */
public class BrowserControls {

	public static void clickOnElement(WebElement element) {

		element.click();
	}

	public static void enterText(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}

	public static void enterTextOnly(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void moveMouseAndClickOn(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public static void moveMouseOn(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void scrollInView(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public static String getTextValue(WebElement element) {
		return element.getText();
	}

}
