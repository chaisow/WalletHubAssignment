package org.walletHub.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.base.BasePage;
import org.walletHub.browserFactory.BrowserFactory;
import org.walletHub.commons.Settings;
import org.walletHub.webElementExtension.BrowserControls;

public class FaceBookLandingPage extends BasePage {

	
	@FindBy(how = How.ID, using = "email")
	private WebElement txtBx_EmailId;
	
	@FindBy(how = How.ID, using = "pass")
	private WebElement txtBx_Passwrd;
	
	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	private WebElement btn_Login;
	
	@FindBy(how = How.XPATH, using = "//a[@title='English (UK)']")
	private WebElement btn_ChangeLangToEng;
	
	
	
	
	/**
	 * Open facebook login page
	 */
	public void openFaceBookLoginPage() {
		BrowserFactory.getWebDriver().get(Settings.fb_URL);
	}
	
	/***
	 * method to login into the account
	 */
	public FaceBookProfilePage loginIntoFbAccnt(String usrName , String psswrd) {
		BrowserControls.enterText(txtBx_EmailId, usrName);
		BrowserControls.enterText(txtBx_Passwrd, psswrd);
		BrowserControls.clickOnElement(btn_Login);
		return new FaceBookProfilePage();
	}
}
