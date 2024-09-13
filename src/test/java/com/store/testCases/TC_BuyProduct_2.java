package com.store.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.MyProfile;
import com.store.pageObject.ProductCommonDescription;
import com.store.pageObject.Product_2_Description;
import com.store.pageObject.accountRegistration;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;
import com.store.pageObject.productTshirt;

public class TC_BuyProduct_2 extends BaseClass
{
@Test
	
	
	public void buyProduct_2() throws InterruptedException, IOException
	{
		
		logger.info("\n********************TEST CASE BUY PRODUCT 2 STARTED*********************");
		
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
		mp.ClickSearchBar("T-Shirt");
		
		
		productTshirt pt = new productTshirt(driver);
		pt.selectProduct_2();
		logger.info("Product 2 selected");
		
		
		ProductCommonDescription pcd = new ProductCommonDescription(driver);
		pcd.selectSizeOfProduct("S");
		logger.info("S Size got selected");
		Thread.sleep(30);
		
		
		Product_2_Description pd = new Product_2_Description(driver);
		pd.selectColourOfProduct("Orange");
		logger.info("White Colored option");
		Thread.sleep(30);
		
		String txt = pd.CheckOutOfStock();
		if(txt.equals("This product is no longer in stock"))
		{
			logger.info("PRODUCT IS OUT OF STOCK");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("PRODUCT IS IN STOCK");
			captureScreenShot(driver,"TC_BuyProduct_2");
			Assert.assertTrue(false);
		}
		logger.info("\n********************TEST CASE BUY PRODUCT 2 ENDS*********************");
	}

}
