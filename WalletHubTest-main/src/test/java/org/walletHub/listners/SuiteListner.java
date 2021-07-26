package org.walletHub.listners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.walletHub.browserFactory.BrowserFactory;
import org.walletHub.envSetUp.EnviornmentSetUp;

/***
 * This class is responsible for taking care of Tear down / tear up methods
 * @author apoorvdwivedi
 *
 */
public class SuiteListner implements ISuiteListener {

	/***
	 * Method to set the environment variables before starting of the test suite
	 */
	public void onStart(ISuite suite) {
		EnviornmentSetUp envSetUp = new EnviornmentSetUp();
		envSetUp.setUp();
	}

	/***
	 * Test tear down method
	 */
	public void onFinish(ISuite suite) {

		BrowserFactory.getWebDriver().quit();

	}
}
