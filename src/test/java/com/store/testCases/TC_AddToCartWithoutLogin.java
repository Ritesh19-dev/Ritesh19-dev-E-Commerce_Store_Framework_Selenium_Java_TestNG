package com.store.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.ChequePaymentMethod;
import com.store.pageObject.OrderAddress;
import com.store.pageObject.OrderShipping;
import com.store.pageObject.OrderSummary;
import com.store.pageObject.ProductCommonDescription;
import com.store.pageObject.Product_3_Description;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;
import com.store.pageObject.orderPayementMethod;
import com.store.pageObject.productTshirt;

public class TC_AddToCartWithoutLogin extends BaseClass
{
	
	@Test
	
	public void addProductToCartWithoutLogin() throws InterruptedException, IOException
	{
		logger.info("\n********************TEST CASE ADD TO CART WITHOUT LOGIN STARTED*********************");


		indexPage pg = new indexPage(driver);
		pg.clickOnTshirtMenu();
		logger.info("Clicked T-Shirt Menu");
		
		pg.clickOnSpecialProduct();
		logger.info("Clicked On All Special Product button ");


		productTshirt pt = new productTshirt(driver);
		pt.selectProduct_6();
		logger.info("Product 6 selected");

		Product_3_Description pd3 = new Product_3_Description(driver);
		pd3.selectColourOfProduct("Blue");
		logger.info("Blue Colored option");


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
			logger.info("*****TC_AddToCartWithoutLogin*****");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("******TC_AddToCartWithoutLogin******");
			captureScreenShot(driver,"TC_AddToCartWithoutLogin");
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
			captureScreenShot(driver,"TC_AddToCartWithoutLogin");
			Assert.assertTrue(false);

		}

		logger.info("\n********************TEST CASE ADD TO CART WITHOUT LOGIN ENDS*********************");

	}
}

