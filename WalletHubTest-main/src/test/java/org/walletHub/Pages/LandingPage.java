package org.walletHub.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.base.BasePage;
import org.walletHub.launchApp.LaunchApplication;
import org.walletHub.webElementExtension.BrowserControls;

public class LandingPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//span[@tabindex='0' and contains(text(),'Login')]")
	private WebElement lnk__Login;

	/***
	 * Navigate to application URL
	 */
	public void navigateToAppURL() {

		LaunchApplication launchApp = new LaunchApplication();
		launchApp.openUrl();
	}

	/***
	 * click on login link
	 * @return
	 */
	public ApplicationLoginPage clickOnLoginLink() {
		BrowserControls.clickOnElement(lnk__Login);
		return new ApplicationLoginPage();
	}

}
