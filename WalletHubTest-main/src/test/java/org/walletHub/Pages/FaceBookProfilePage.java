package org.walletHub.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.base.BasePage;
import org.walletHub.webElementExtension.BrowserControls;

public class FaceBookProfilePage extends BasePage {

	@FindBy(how = How.XPATH , using = "//div[@class='m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b']/span")
	private WebElement txtBx_Post;
	
	@FindBy(how = How.XPATH , using = "//div[@class='_1mf _1mj']")
	private WebElement txtBx_PostInForm;
	
	@FindBy(how = How.XPATH , using = "//div[@aria-label='Post']")
	private WebElement btn_Post;
	
	
	
	/**
	 * This method posts the fb status
	 * @param txt
	 */
	public void makeAPost(String txt) {
		BrowserControls.clickOnElement(txtBx_Post);
	    BrowserControls.clickOnElement(txtBx_PostInForm);
	    BrowserControls.enterTextOnly(txtBx_PostInForm, txt);
	    BrowserControls.clickOnElement(btn_Post);
	}
}
