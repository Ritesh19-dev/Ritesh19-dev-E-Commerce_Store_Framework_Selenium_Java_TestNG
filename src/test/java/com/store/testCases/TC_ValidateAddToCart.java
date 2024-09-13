package com.store.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.MyProfile;
import com.store.pageObject.ProductCommonDescription;
import com.store.pageObject.Product_3_Description;
import com.store.pageObject.indexPage;
import com.store.pageObject.myAccount;
import com.store.pageObject.productTshirt;

public class TC_ValidateAddToCart extends BaseClass
{
	
	@Test
	
	public void validateCart() throws InterruptedException, IOException
	{
		logger.info("\n********************TEST CASE VALIDATE ADD TO CART STARTED*********************");
		
		indexPage pg = new indexPage(driver);
		pg.clickSignIn();
		
		readConfigFile  readConfig = new readConfigFile();
		String emailAdd = readConfig.verifyEmail();
		String pssd = readConfig.verifyPassword();
		


		myAccount login_pg = new myAccount(driver);		
		login_pg.enterEmailAddress(emailAdd);
		login_pg.enterPassword(pssd);
		login_pg.clickOnSignInButton();
		logger.info("Clicked on sign in link");



		MyProfile mp = new MyProfile(driver);
		mp.ClickSearchBar("T-Shirt");
		logger.info("Search for T-Shirt");
		
		
		productTshirt pt = new productTshirt(driver);
		pt.selectProduct_6(); 
		
		logger.info("Product number 6 selected");
		
		
		
		Product_3_Description pd3 = new Product_3_Description(driver);
		pd3.selectColourOfProduct("Blue");
		logger.info("Selected Blue colored Tshirt");


		ProductCommonDescription pcd = new ProductCommonDescription(driver);
		pcd.selectSizeOfProduct("M");
		
		logger.info("Selected Size M");
		
		pcd.validateShoppingCart();
		String word = pcd.validateProductAddedToCart();
		
		if(word.equals("Product successfully added to your shopping cart Text Visible"))
		{
			Assert.assertTrue(true);
		}
				
		else
		{
			logger.info("Product successfully added to your shopping cart Confirmation Text Not Visible");
			captureScreenShot(driver,"ValidateAddToCart");
			Assert.assertTrue(false);
		}
		
		logger.info("\n********************TEST CASE VALIDATE ADD TO CART ENDS*********************");
		
	}

}
