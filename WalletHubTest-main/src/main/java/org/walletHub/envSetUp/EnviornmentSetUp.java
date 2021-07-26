package org.walletHub.envSetUp;

import org.walletHub.browserFactory.BrowserFactory;
import org.walletHub.commons.Settings;

public class EnviornmentSetUp {

	/**
	 * Method to set up  env variables
	 */
	
	public void setUp() {

		ConfigReader.setConfigSettings();  // sets the env variables
		ConfigReader.setTestData();        // sets the test env variables
		BrowserFactory.initDriver(Settings.browserName);  // initializes driver
		BrowserFactory.getWebDriver().get(Settings.URL);  // open application url
	}

}
