package org.walletHub.tests;

import org.testng.annotations.Test;
import org.walletHub.Pages.FaceBookLandingPage;
import org.walletHub.Pages.FaceBookProfilePage;
import org.walletHub.commons.Settings;

public class ValidateFaceBookPost {

	
	
	/**
	 * Test case to post fb status
	 * @throws InterruptedException
	 */
	@Test
	public void validateUserIsAbleToPostOnFb() throws InterruptedException {
		
		FaceBookLandingPage fbLandingPage= new FaceBookLandingPage();
		fbLandingPage.openFaceBookLoginPage();
		FaceBookProfilePage fbProfilePage = fbLandingPage.loginIntoFbAccnt(Settings.fb_UserName,Settings.fb_Password);
		fbProfilePage.makeAPost(Settings.fb_Post);
	}
	
	
}
