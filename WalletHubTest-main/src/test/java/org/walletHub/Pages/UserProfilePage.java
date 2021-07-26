package org.walletHub.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.base.BasePage;

public class UserProfilePage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='pr-rec-texts-container']/a")
	private WebElement link_reviewComents;

	
	/***
	 * Method to click on review provided by the user from user profile page
	 * @return
	 */
	public TestCompanyProfilePage clickOnReviewComentsLink() {
		link_reviewComents.click();
		return new TestCompanyProfilePage();
	}
}
