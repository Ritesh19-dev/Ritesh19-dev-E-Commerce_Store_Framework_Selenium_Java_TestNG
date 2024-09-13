package com.store.testCases;

import org.testng.annotations.Test;

import com.store.pageObject.AddUserAddressDetails;
import com.store.pageObject.MyProfile;
import com.store.pageObject.accountRegistration;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;

public class TC_myAccountPageTest extends BaseClass
{
	

	@Test 
	public void createAccountAndLogin() throws InterruptedException
	{


		indexPage pg = new indexPage(driver);
		pg.clickSignIn();
		logger.info("Clicked on Sign in");


		myAccount acc_pg = new myAccount(driver);

		Thread.sleep(30);
		acc_pg.createEmailAddress("wertm@gmail.com");
		logger.info("Email Id verified and registered");
		
		acc_pg.clickSubmitCreate();
		logger.info("Clicked Submit Button");
		Thread.sleep(30);




		accountRegistration acc_reg = new accountRegistration(driver);
		acc_reg.clickGenderMr();
		acc_reg.clickGenderMrs();
		acc_reg.enterFirstName("Sumiit");
		acc_reg.enterLastName("Meshraam");
		acc_reg.createPassword("Sumiit@123");
		acc_reg.clickOnNewLetterCheckBox();
		acc_reg.clickonRegister();
		acc_reg.verifyAccountCreated("Sumiit + Mesharaam");
		
		

	}
	
	
	
	
	//login
	@Test (priority=2)
	public void SignIn() throws InterruptedException
	{
		//indexPage pg = new indexPage(driver);
		//pg.clickSignIn();
		
		myAccount login_pg = new myAccount(driver);
		
		login_pg.enterEmailAddress("ritesh.kumar@gmail.com");
		login_pg.enterPassword("Ritesh@123");
		login_pg.clickOnSignInButton();
		logger.info("Clicked on Log in Button");
		
		accountRegistration reg = new accountRegistration(driver);
		
		reg.verifyAccountCreated("Ritesh Kumar");
		
		
		
			
	}
	
	
	@Test (priority = 3)
	
	public void userProfile() throws InterruptedException
	{

		
		MyProfile mp = new MyProfile(driver);
		mp.AddUserAddress();
		
		
		AddUserAddressDetails ac = new AddUserAddressDetails(driver);
		ac.enterCompanyName("XYZ");
		ac.enterUserAdd("IT Tech Space");
		ac.enterCityName("Kolkata");
		ac.enterStateName("Alabama");
		ac.enterMobileNumber("1234567890");
		ac.clickOnSaveButton();
		
		
	}
	
}


