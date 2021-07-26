package org.walletHub.base;

import org.openqa.selenium.support.PageFactory;
import org.walletHub.browserFactory.BrowserFactory;

public abstract class BasePage {

	
	public BasePage() {
		
		PageFactory.initElements(BrowserFactory.getWebDriver(), this);
	}
	
	
}
