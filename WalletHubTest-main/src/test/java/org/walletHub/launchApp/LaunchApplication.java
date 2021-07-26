package org.walletHub.launchApp;

import org.walletHub.browserFactory.BrowserFactory;
import org.walletHub.commons.Settings;

public class LaunchApplication {

	/***
	 * Method to open application
	 */
	public void openUrl() {
		BrowserFactory.getWebDriver().get(Settings.URL);
	}
}
