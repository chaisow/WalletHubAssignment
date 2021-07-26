package org.walletHub.Pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.base.BasePage;
import org.walletHub.browserFactory.BrowserFactory;
import org.walletHub.webElementExtension.BrowserControls;

public class HomePage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='brgm-button brgm-user brgm-list-box']/span")
	private WebElement userProfileName;

	/***
	 * Move to user profile name
	 */
	public void moveToUserProfileName() {

		BrowserControls.moveMouseOn(BrowserFactory.getWebDriver(), userProfileName);
	}

	/***
	 * Move to profile menu item name 
	 * @param menuItemName
	 * @return
	 */
	public UserProfilePage moveToProfileMenu(String menuItemName) {

		List<WebElement> profileMenuItems = BrowserFactory.getWebDriver()
				.findElements(By.xpath("//div[@class='brgm-button brgm-user brgm-list-box']/div/a"));

		List<WebElement> menuItem = profileMenuItems.stream()
				.filter(webElement -> webElement.getText().equalsIgnoreCase(menuItemName)).collect(Collectors.toList());
		BrowserControls.clickOnElement(menuItem.get(0));
		return new UserProfilePage();
	}

}
