package org.walletHub.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.base.BasePage;
import org.walletHub.commons.Settings;
import org.walletHub.webElementExtension.BrowserControls;

public class ApplicationLoginPage extends BasePage {

	@FindBy(how = How.ID, using = "email")
	private WebElement txtBx_Email;

	@FindBy(how = How.ID, using = "password")
	private WebElement txtBx_Password;

	@FindBy(how = How.XPATH, using = "//button[@class='btn blue center reg-tabs-bt touch-element-cl']")
	private WebElement btn_Login;

	/**
	 * Method to login into the application
	 * @return
	 */
	public TestCompanyProfilePage loginToCompanyProfilePage() {
		enterUserName(Settings.userName);
		enterPassword(Settings.password);
		clickOnLoginBtn();
		return new TestCompanyProfilePage();
	}

	/**
	 * Method to enter username
	 * @param userName
	 */
	private void enterUserName(String userName) {
		BrowserControls.enterText(txtBx_Email, userName);
	}

	/**
	 * Method to enter password
	 * @param userName
	 */
	private void enterPassword(String password) {
		BrowserControls.enterText(txtBx_Password, password);
	}

	/**
	 * Method to click on login button
	 * @param userName
	 */
	private void clickOnLoginBtn() {
		BrowserControls.clickOnElement(btn_Login);
	}

}
