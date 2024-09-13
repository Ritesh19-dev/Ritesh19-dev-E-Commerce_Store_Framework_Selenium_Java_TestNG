package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount 
{
	WebDriver ldriver;
	
	
	//Constructor
	public myAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify WebElement
	
	@FindBy(id = "email_create") WebElement CreateEmailAddress;
	@FindBy(id= "SubmitCreate") WebElement createAccButton;
	
	
	// login WebElements
	@FindBy(id="email") WebElement email;
	@FindBy(id= "passwd") WebElement password;
	@FindBy(id= "SubmitLogin") WebElement submitLogin;
	
	
	//perform action on WebElement 
	
	public void createEmailAddress(String emailAdd)
	{
		CreateEmailAddress.sendKeys(emailAdd);
		
	}
	
	public void clickSubmitCreate()
	{
		createAccButton.click();
	}
	
	public void enterEmailAddress(String emailAdd)
	{
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) throws InterruptedException
	{
		password.sendKeys(pwd);
		Thread.sleep(20);
	}
	
	public void clickOnSignInButton() throws InterruptedException
	{
		submitLogin.click();
		Thread.sleep(20);
	}

}
