package com.store.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.ChequePaymentMethod;
import com.store.pageObject.MyProfile;
import com.store.pageObject.OrderAddress;
import com.store.pageObject.OrderShipping;
import com.store.pageObject.OrderSummary;
import com.store.pageObject.ProductCommonDescription;
import com.store.pageObject.Product_5_Description;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;
import com.store.pageObject.orderPayementMethod;
import com.store.pageObject.productTshirt;

public class TC_BuyProduct_5 extends BaseClass
{
	@Test
	
	public void buyProduct_5() throws InterruptedException, IOException
	{
		
		logger.info("\n********************TEST CASE BUY PRODUCT 5 STARTED*********************");
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
		pt.selectProduct_5(); 
		logger.info("Product 5 selected");


		Product_5_Description pd3 = new Product_5_Description(driver);
		pd3.selectColourOfProduct("Green");
		logger.info("Green Colored option");


		ProductCommonDescription pcd = new ProductCommonDescription(driver);
		pcd.selectSizeOfProduct("M");
		logger.info("M Size got selected");
		
		pcd.moveProductToCart();
		logger.info("Added to cart");
		
		
		pcd.clickOnProccedButton();
		logger.info("Clicked on Proceed to pay Button");

		OrderSummary os = new OrderSummary(driver);
		os.ClickOnProceedToCheckOutButton();
		logger.info("Clicked on Proceed to Check Out Button");

		OrderAddress oa = new OrderAddress(driver);
		oa.ClickOnCheckBox();
		oa.ClickOnProceedToCheckOutButton();
		logger.info("Clicked on Proceed to Check Out Button");


		OrderShipping orderShip = new OrderShipping(driver);
		orderShip.ClickOnTermsAndConditionCheckBox();
		orderShip.ClickOnProceedToCheckOutButton();
		logger.info("Clicked on Proceed to Check Out Button");
		

		orderPayementMethod opm = new orderPayementMethod(driver);
		opm.PaymentByCheque();
		logger.info("Clicked on Payment By Cheque");

		ChequePaymentMethod cpm = new ChequePaymentMethod(driver);
		cpm.ConfirmChequePayment();
		
		logger.info("Clicked on Confirm Order");
		
		String msg = cpm.getOrderSuccessMessage();
		if(msg.equals("Your order on My Shop is complete."))
		{
			logger.info("*****TC_BuyProduct_5 Passed*****");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("******TC_BuyProduct_5 failed******");
			captureScreenShot(driver,"TC_BuyProduct_5");
			Assert.assertTrue(false);
		}
		
		cpm.SignOut();
		logger.info("Clicked on Sign Out");
		
		
		String IndexText= pg.getIndexPageText();
		if(IndexText.equals("Sign in"))
		{
			logger.info("Suggessfully Logged Out");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.info("Logged Out Failed");
			captureScreenShot(driver,"TC_BuyProduct_5");
			Assert.assertTrue(false);
			
		}
		
		logger.info("\n********************TEST CASE BUY PRODUCT 5 ENDS*********************");

	}

}

