package org.walletHub.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.base.BasePage;
import org.walletHub.browserFactory.BrowserFactory;
import org.walletHub.webElementExtension.BrowserControls;

public class TestCompanyProfilePage extends BasePage {

	private WebElement starElement;
	private String lightStarXpath;

	@FindBy(how = How.XPATH, using = "//div[@class='rv review-action ng-enter-element']")
	private WebElement reviewSectionHeader;

	@FindBy(how = How.XPATH, using = "//div[@class='rv review-action ng-enter-element']//div[@class='rating-box-wrapper'] /*[local-name()='svg']/*[local-name()='g']")
	private List<WebElement> list_AllStars;

	@FindBy(how = How.XPATH, using = "//h3[@class='rsba-h3 bold-font']")
	private WebElement txt_reviewHeading;

	@FindBy(how = How.XPATH, using = "//article[@class='rvtab-citem rvtab-item-user ng-enter-element']/div[@class='rvtab-ci-content with-links text-select rvtac-ci-cexp']")
	private WebElement txt_selfReviewComnts;

	/***
	 * Move to the review feeds section
	 * 
	 * @throws InterruptedException
	 */
	public void moveToReviewSectionHeader() throws InterruptedException {
		Thread.sleep(5000);
		BrowserControls.scrollInView(BrowserFactory.getWebDriver(), reviewSectionHeader);
	}

	/***
	 * Validate stars are ligting up , for every star count lighting up
	 */
	public void ValidateStarLightsUp() {
		WebDriver driver = BrowserFactory.getWebDriver();
		int starCount = getNoOfReviewStars();
		for (int i = 1; i <= starCount; i++) {
			lightStarXpath = getStarElementXpath(i) + "/*[local-name()='path']";
			starElement = driver.findElement(By.xpath(getStarElementXpath(i)));
			int retryCount = 0;
			BrowserControls.moveMouseOn(driver, starElement);
			while (retryCount < 5 && getLightedStarPathCount() < 2) {
				BrowserControls.moveMouseOn(driver, txt_reviewHeading);
				moveMouseOnStars();
				retryCount++;
			}
			assertTrue(getLightedStarPathCount() > 1, "Stars are not lighting up for star number " + i);
		}
	}

	/***
	 * Xpath of the Star based on the number is provided
	 * 
	 * @param starNumb
	 * @return
	 */
	private String getStarElementXpath(int starNumb) {
		String tempXpath = "//div[@class='rv review-action ng-enter-element']//div[@class='rating-box-wrapper']/*[local-name()='svg']";
		String index = "[" + starNumb + "]";
		String starXpath = tempXpath + index + "/*[local-name()='g']";
		return starXpath;
	}

	/***
	 * move mouse on all the stars
	 */
	private void moveMouseOnStars() {
		BrowserControls.moveMouseOn(BrowserFactory.getWebDriver(), starElement);
	}

	/***
	 * get the xpath of the lighted star
	 * 
	 * @return
	 */
	private int getLightedStarPathCount() {
		List<WebElement> elements = BrowserFactory.getWebDriver().findElements(By.xpath(lightStarXpath));
		return elements.size();
	}

	/**
	 * return number of stars present
	 * 
	 * @return
	 */
	private int getNoOfReviewStars() {
		return list_AllStars.size();
	}

	/***
	 * select star on the basis of interger value
	 * 
	 * @param starNumb
	 * @return
	 */
	public PostReviewPage slectStar(int starNumb) {
		WebElement starToBeSelected = BrowserFactory.getWebDriver()
				.findElement(By.xpath(getStarElementXpath(starNumb)));
		starToBeSelected.click();
		return new PostReviewPage();
	}

	/***
	 * validates review feed is updated
	 * 
	 * @param expectedResult
	 */
	public void validateReviewFeedIsUpdated(String expectedResult) {
		String actutalResult = BrowserControls.getTextValue(txt_selfReviewComnts);
		assertTrue(expectedResult.equalsIgnoreCase(actutalResult), "review feed is not updated");
	}
}
