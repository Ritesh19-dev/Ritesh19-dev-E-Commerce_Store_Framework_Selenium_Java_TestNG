package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Personal_Information_Page 
{
	WebDriver ldriver;


	//Constructor
	public Personal_Information_Page(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	//Identify Sign Out WebElements
	@FindBy(xpath ="//input[@id='old_passwd']") WebElement currntpass;
	@FindBy(xpath ="//input[@id='passwd']") WebElement newpass;
	@FindBy(xpath ="//input[@id='confirmation']") WebElement cnfNewpass;
	@FindBy(xpath ="//button[@name='submitIdentity']") WebElement save;
	
	
	//Type old/current password
	public void CurrentPassword(String currentPass) throws InterruptedException
	{
		currntpass.sendKeys(currentPass);
		Thread.sleep(20);
	}
	
	//Create a new password
	public void NewPassword(String newPwd) throws InterruptedException
	{
		newpass.sendKeys(newPwd);
		Thread.sleep(20);
	}
	
	//Confirm new Passsword
	public void CnfNewPassword(String CnfnewPwd) throws InterruptedException
	{
		cnfNewpass.sendKeys(CnfnewPwd);
		Thread.sleep(20);
	}
	
	
	//clicked on save button
	public void ClickOnSave() throws InterruptedException
	{
		save.click();
		Thread.sleep(20);
	}
	
}
