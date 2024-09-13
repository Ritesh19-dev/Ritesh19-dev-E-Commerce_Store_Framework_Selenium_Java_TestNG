package com.store.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.store.Utilities.readConfigFile;
import com.store.pageObject.indexPage;

import junit.framework.Assert;

public class TC_SubscribeToNewsLetter extends BaseClass

{
	@Test
	public void TestCaseNewsLetter() throws InterruptedException,IOException
	{
		logger.info("\n********************TEST CASE VERIFY NEWS LETTER STARTED*********************");

		readConfigFile read = new readConfigFile();
		String mail = read.verifyNewLetterEmail();

		indexPage pg = new indexPage(driver);
		pg.registerForNewsLetter(mail);
		logger.info("Entered the email address");

		pg.clickOnSubscribeButton();
		logger.info("Clicked on subscribed Button");


		String text = pg.VerfiyTextForNewsLetter();

		if(text.equals("Newsletter : You have successfully subscribed to this newsletter."))
		{
			logger.info("Successfully Subscribed to NewLetter");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info(" Invalid email address. ");
			captureScreenShot(driver, "TC_SubscribeToNewsLetter");

			Assert.assertTrue(false);
		}
		
			

		logger.info("\n********************TEST CASE VERIFY NEWS LETTER ENDS*********************");


	}

}
