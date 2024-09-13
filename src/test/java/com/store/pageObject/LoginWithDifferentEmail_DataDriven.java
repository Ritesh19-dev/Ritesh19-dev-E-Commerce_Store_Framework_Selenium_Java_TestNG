package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithDifferentEmail_DataDriven 
{
	WebDriver ldriver;

	public LoginWithDifferentEmail_DataDriven(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath= "//a[@title='View my customer account']") WebElement username;
	
	public String verifyUserName()
	{
		String text =username.getText(); 
		return(text);
	}

}
