package com.store.testCases;

import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.MyProfile;
import com.store.pageObject.accountRegistration;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;

public class TC_Check_All_Optins_In_My_Profile_Page extends BaseClass
{
	@Test
	public void checkOptionsInProfile() throws InterruptedException
	{


		logger.info("\n********************TEST CASE CHECK ALL OPTIONS IN PROFILE PAGE STARTED*********************");

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
		mp.UserOrderHistory();
		logger.info("Clicked on User Order History And Details");
		logger.info("Entered on User Order History And Details Page");


		driver. navigate(). back();
		logger.info("Naviagted to Profile Page");


		mp.UserCreditSlip();
		logger.info("Clicked on MY Credit Slip Option");
		logger.info("Entered on MY Credit Slip Page Page");


		driver. navigate(). back();
		logger.info("Naviagted to Profile Page");

		mp.MyAddress();
		logger.info("Clicked on User Current Adddress Option");
		logger.info("Entered on User Current Adddress Page");


		driver. navigate(). back();
		logger.info("Naviagted to Profile Page");


		mp.UserPersonalInfo();logger.info("Clicked on User Personal Information Option");
		logger.info("Entered on User Personal Information Page");


		driver. navigate(). back();
		logger.info("Naviagted to Profile Page");


		logger.info("*****TC_Check_All_Optins_In_My_Profile_Page Passed*****");


		logger.info("\n********************TEST CASE CHECK ALL OPTIONS IN PROFILE PAGE ENDS*********************");

	}
}
