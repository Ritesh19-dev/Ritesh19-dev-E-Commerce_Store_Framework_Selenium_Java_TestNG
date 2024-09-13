package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferProductToFriend 
{
		WebDriver ldriver;
		
		public ReferProductToFriend(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this );
		}
		
		@FindBy(xpath = "//a[@id='send_friend_button']") WebElement share;
		@FindBy(xpath = "//input[@id='friend_name']") WebElement frndName;
		@FindBy(xpath = "//input[@id='friend_email']") WebElement frndEmail;
		@FindBy(xpath = "//button[@id='sendEmail']") WebElement sendButton;
		@FindBy(xpath = "//p[normalize-space()='Your e-mail has been sent successfully']") WebElement verify;
		@FindBy(xpath= "//input[@value='OK']") WebElement okbutton;

		
		
		
		public void ClickOnShareToFriend()
		{
			share.click();
		}
		
		public void ProvideFriendName(String Name)
		{
			 frndName.sendKeys(Name); 
		}
		
		public void ProvideFriendEmail(String email)
		{
			frndEmail.sendKeys(email);;
		}
		
		public void ClickOnSendBUtton()
		{
			sendButton.click();
		}
		
		public String verifySendToEmail()
		{
			String txt = verify.getText();
			return txt;
		}
		public void clickOnOkButton()
		{
			okbutton.click();
		}
		
		
		

}
