package com.store.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.MyProfile;
import com.store.pageObject.ReferProductToFriend;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;
import com.store.pageObject.productTshirt;



public class TC_ReferProduct_1_ToFriend extends BaseClass
{
	@Test

	public void referProduct_1() throws InterruptedException, IOException 
	{


		logger.info("\n********************TEST CASE REFER PRODUCT 1 TO FRIEND STARTED*********************");


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





		MyProfile mp = new MyProfile(driver);
		mp.ClickSearchBar("T-Shirt");


		productTshirt pt = new productTshirt(driver);
		pt.selectProduct_1(); 
		logger.info("Product 1 selected");


		ReferProductToFriend rpf = new ReferProductToFriend(driver);
		rpf.ClickOnShareToFriend();
		logger.info("Clicked on SEND TO A FRIEND");


		rpf.ProvideFriendName("ADMIN ADMIN");
		logger.info("Friend Name provided");


		rpf.ProvideFriendEmail("admin@gmail.com");
		logger.info("Friend Email Provided");


		rpf.ClickOnSendBUtton();
		logger.info("Clicked on Send Button");



		String cnf = rpf.verifySendToEmail();

		if(cnf.equals("Your e-mail has been sent successfully"))
		{
			rpf.clickOnOkButton();
			logger.info("Successfully refer to friend");
			Assert.assertTrue(true);

		}
		else
		{
			logger.info(" failed refer to a friend");
			captureScreenShot(driver,"TC_ReferProduct_1_ToFriend");
			Assert.assertTrue(false);
		}

		logger.info("\n********************TEST CASE REFER PRODUCT 1 TO FRIEND ENDS*********************");
	}


}
