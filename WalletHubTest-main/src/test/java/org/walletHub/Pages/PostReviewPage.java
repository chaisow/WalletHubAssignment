package org.walletHub.Pages;

import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.walletHub.base.BasePage;
import org.walletHub.browserFactory.BrowserFactory;
import org.walletHub.webElementExtension.BrowserControls;

public class PostReviewPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='dropdown second']")
	private WebElement dropDown_reviewCompany;

	@FindBy(how = How.XPATH, using = "//div[@class='android']/textarea")
	private WebElement txtBx_reviewComnts;

	@FindBy(how = How.XPATH, using = "//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']")
	private WebElement btn_Submit;

	@FindBy(how = How.XPATH, using = "//div[@class='rvc-header']/h4")
	private WebElement txt_SuccessMsgHeading;

	/**
	 * Method to post the review
	 * 
	 * @param reviewTxt
	 * @param drpDwnName
	 */
	public void postReview(String reviewTxt, String drpDwnName) {

		writeReview(reviewTxt);
		selectDropDownValue(drpDwnName);
		clickSubmtBtn();
	}

	/***
	 * Select drop down value on review comments page
	 * 
	 * @param drpDwnName
	 */
	private void selectDropDownValue(String drpDwnName) {

		BrowserControls.clickOnElement(dropDown_reviewCompany);
		WebElement drpDwnElement = getDropDownValue(drpDwnName);
		BrowserControls.moveMouseAndClickOn(BrowserFactory.getWebDriver(), drpDwnElement);
	}

	/***
	 * Method to get the webelement matching the value provided
	 * 
	 * @param drpDwnValue
	 * @return
	 */
	private WebElement getDropDownValue(String drpDwnValue) {

		List<WebElement> drpDwnElements = BrowserFactory.getWebDriver()
				.findElements(By.xpath("//div[@class='dropdown second opened']//li"));

		WebElement elemenet = BrowserFactory.getWebDriver()
				.findElement(By.xpath("//ng-dropdown[@class='wrev-drp']/div"));

		WebDriverWait wait = new WebDriverWait(BrowserFactory.getWebDriver(), 10);
		wait.until(ExpectedConditions.attributeContains(elemenet, "class", "dropdown second opened"));

		List<WebElement> collect = drpDwnElements.stream()
				.filter(webElement -> webElement.getText().equalsIgnoreCase(drpDwnValue)).collect(Collectors.toList());

		assertTrue(collect.size() > 0, "No element found maching for the text : " + drpDwnValue);

		return collect.get(0);
	}

	/***
	 * Method to write the review
	 * String
	 * @param reviewTxt
	 */
	private void writeReview(String reviewTxt) {
		BrowserControls.enterText(txtBx_reviewComnts, reviewTxt);
	}

	/***
	 * Click on submit button
	 */
	private void clickSubmtBtn() {
		BrowserControls.clickOnElement(btn_Submit);
	}

	/***
	 * Method to validate review had been posted successfully
	 * @param expectedValue
	 */
	public void validatedPostScccsMsg(String expectedValue) {

		String actualValue = BrowserControls.getTextValue(btn_Submit);
		System.out.println(actualValue);
		assertTrue(actualValue.equalsIgnoreCase(expectedValue), "Comment is not posted successfully");

	}
}
