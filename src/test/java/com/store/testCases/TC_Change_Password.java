package com.store.testCases;

import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.MyProfile;
import com.store.pageObject.Personal_Information_Page;
import com.store.pageObject.accountRegistration;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;

public class TC_Change_Password extends BaseClass
{
	@Test
	
	public void changePassword() throws InterruptedException
	{
		logger.info("\n********************TEST CASE CHANGE PASSWORD STARTED*********************");
		
		indexPage pg = new indexPage(driver);
		pg.clickSignIn();
		
		logger.info("Clicked on Sign in");
		
		readConfigFile  readConfig = new readConfigFile();
		String emailAdd = readConfig.verifyEmail();
		String pssd = readConfig.verifyPassword();
		
		
		myAccount login_pg = new myAccount(driver);		
		login_pg.enterEmailAddress(emailAdd);
		logger.info("UserEmail Entered");
		
		login_pg.enterPassword(pssd);
		logger.info("UserPassword Entered");
		
		login_pg.clickOnSignInButton();
		logger.info("Clicked on Login Button");
		
		
		accountRegistration reg = new accountRegistration(driver);
		reg.verifyAccountCreated("Ritesh Kumar");
		
		
		MyProfile mp = new MyProfile(driver);
		mp.UserPersonalInfo();
		
		Personal_Information_Page pi = new Personal_Information_Page(driver);
		pi.CurrentPassword(pssd);
		logger.info("Old Pasword entered");
		
		pi.NewPassword("Ritesh@123");
		logger.info("New Pasword entered");
		
		pi.CnfNewPassword("Ritesh@123");
		logger.info("New Password Confirmed");
		
		
		pi.ClickOnSave();
		logger.info("Clicked on Save Button");
		
		logger.info("*****TC_Change_Password Passed*****");
		
		
		logger.info("\n********************TEST CASE CHANGE PASSWORD ENDS*********************");
		
	}

}
