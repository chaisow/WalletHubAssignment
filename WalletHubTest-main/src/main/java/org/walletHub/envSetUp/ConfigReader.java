package org.walletHub.envSetUp;

import org.walletHub.commons.Settings;

public class ConfigReader {

	/**
	 * This method sets the setting configuration by reading properties file
	 **/
	public static void setConfigSettings() {
		Settings.configProp = Settings.appUtil.propFileReader(Settings.propFilePath);
		Settings.testConfigProp = Settings.appUtil.propFileReader(Settings.testDataFile);
		Settings.browserName = Settings.configProp.getProperty("browserName");
		Settings.URL = Settings.configProp.getProperty("appUrl");
		Settings.userName = Settings.configProp.getProperty("userName");
		Settings.password = Settings.configProp.getProperty("password");
		Settings.fb_URL = Settings.configProp.getProperty("fb_URL");
		Settings.fb_UserName = Settings.configProp.getProperty("fb_UserName");
		Settings.fb_Password = Settings.configProp.getProperty("fb_Password");
		
	}

	/***
	 * Set testing data
	 */
	public static void setTestData() {
		Settings.drpDown_reviewCmntsPage = Settings.testConfigProp.getProperty("drpDown_reviewCmntsPage");
		Settings.reviewComments = Settings.testConfigProp.getProperty("reviewComments");
		Settings.fb_Post = Settings.testConfigProp.getProperty("fbPost");
	}
}
