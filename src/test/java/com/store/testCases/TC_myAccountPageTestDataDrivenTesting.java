package com.store.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.Utilities.ReadExcelFile;
import com.store.pageObject.LoginWithDifferentEmail_DataDriven;
import com.store.pageObject.MyProfile;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;

public class TC_myAccountPageTestDataDrivenTesting extends BaseClass
{

	//login
	@Test (dataProvider = "LoginDataProvider")
	public void SignIn(String userEmail, String userPassword, String ExcpectedUserName) throws InterruptedException, IOException
	{
		logger.info("\n********************TEST CASE DATA DRIVEN TEST STARTED*********************");

		indexPage pg = new indexPage(driver);
		pg.clickSignIn();
		logger.info("Clicked on Sign in");

		myAccount login_pg = new myAccount(driver);

		login_pg.enterEmailAddress(userEmail);
		logger.info("UserEmail Entered");


		login_pg.enterPassword(userPassword);
		logger.info("UserPassword Entered");


		login_pg.clickOnSignInButton();
		logger.info("Clicked on Login Button");



		LoginWithDifferentEmail_DataDriven lwd = new LoginWithDifferentEmail_DataDriven(driver);

		String expUserName=lwd.verifyUserName();
		if(expUserName.equals(expUserName))
		{
			logger.info("User Name matched");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("User Name not matched");
			captureScreenShot(driver,"TC_myAccountPageTestDataDrivenTesting");
			Assert.assertTrue(false);
		}


		MyProfile mp = new MyProfile(driver);
		mp.ClickSignOut();
		logger.info("Clicked on Sign Out");


		logger.info("\n********************TEST CASE DATA DRIVEN TEST ENDS*********************");


	}


	@DataProvider(name ="LoginDataProvider")

	public String[][] LoginDataProvider()
	{
		System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\storeData.xlsx";

		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");


		String data[][] = new String [ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}

		return data;
	}

}


