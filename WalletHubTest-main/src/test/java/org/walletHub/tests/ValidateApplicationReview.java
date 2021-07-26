package org.walletHub.tests;

import org.testng.annotations.Test;
import org.walletHub.Pages.ApplicationLoginPage;
import org.walletHub.Pages.HomePage;
import org.walletHub.Pages.LandingPage;
import org.walletHub.Pages.PostReviewPage;
import org.walletHub.Pages.TestCompanyProfilePage;
import org.walletHub.Pages.UserProfilePage;
import org.walletHub.commons.Settings;

public class ValidateApplicationReview {

	
	/**
	 * Test case to select 4 star rating and submitting the review comments
	 * @throws InterruptedException
	 */
	@Test
	public void validateUserIsAbleToPostTheReview() throws InterruptedException {
		LandingPage landingPage = new LandingPage();
		landingPage.navigateToAppURL();
		ApplicationLoginPage appLoginPage = landingPage.clickOnLoginLink();
		TestCompanyProfilePage cmpnyProfilePage = appLoginPage.loginToCompanyProfilePage();
		cmpnyProfilePage.moveToReviewSectionHeader();
		cmpnyProfilePage.ValidateStarLightsUp();
		PostReviewPage postReviewPage = cmpnyProfilePage.slectStar(4);
		postReviewPage.postReview(Settings.reviewComments , Settings.drpDown_reviewCmntsPage);
		
		/***
		 *  unable to validate if the msg is posted successfully or not , reason being from one id
		 *  it only allows to post one review comment 
		 */
		
		//postReviewPage.validatedPostScccsMsg(""); 
	}

	/**
	 * Test case to validate user comments on the Company profilePage
	 * @throws InterruptedException
	 */
	@Test
	public void validateReviewFeed() throws InterruptedException {

		LandingPage landingPage = new LandingPage();
		landingPage.navigateToAppURL();
		ApplicationLoginPage appLoginPage = landingPage.clickOnLoginLink();
		TestCompanyProfilePage cmpnyProfilePage = appLoginPage.loginToCompanyProfilePage();
		HomePage homePage = new HomePage();
		homePage.moveToUserProfileName();
		UserProfilePage userProfilePage = homePage.moveToProfileMenu("Profile");
		cmpnyProfilePage = userProfilePage.clickOnReviewComentsLink();
		cmpnyProfilePage.validateReviewFeedIsUpdated(Settings.reviewComments);
	}

}
