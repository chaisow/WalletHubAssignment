package org.walletHub.browserFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	
	
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	/** 
	 * This method takes browser name as input
	 * and initiates webdriver, currently this will  only initiates Chrome , but can be enhanced further
	 **/
	public static void initDriver(String browserName) {

		switch (browserName) {
		case "Chrome":
			initChromeDriver();
			break;
		default:
			break;
		}
	}

	/**
	 * This method initializes the chrome driver and assigns to the threadlocal variable
	 **/
	private static synchronized void initChromeDriver() {
		String dirPath = System.getProperty("user.dir");
		String driverPath = dirPath.concat("/Drivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(chromeOpt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		threadLocalDriver.set(driver);
	}

	/**
	 * This method returns thread local driver instance
	 **/
	public static WebDriver getWebDriver() {
		return threadLocalDriver.get();
	}

}
