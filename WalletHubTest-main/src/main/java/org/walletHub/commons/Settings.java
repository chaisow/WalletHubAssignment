package org.walletHub.commons;

import java.util.Properties;

import org.walletHub.utility.AppUtilities;

public class Settings {

	public static Properties configProp;

	public static Properties testConfigProp;

	public static AppUtilities appUtil = new AppUtilities();

	public static String browserName;

	public static String propFilePath = "AppConfig.properties";

	public static String URL;

	public static String userName;

	public static String password;

	public static String testDataFile = "TestData.properties";

	public static String reviewComments;

	public static String drpDown_reviewCmntsPage;
	
	public static String fb_URL;
	
	public static String fb_UserName;
	
	public static String fb_Password;
	
	public static String fb_Post;

}
