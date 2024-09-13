package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class accountRegistration 
{
	WebDriver ldriver;
	
	public accountRegistration(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identify WebElement
	@FindBy(id = "id_gender1") WebElement title_Mr;
	@FindBy(id= "id_gender2") WebElement title_Mrs;
	
	
	// Registration WebElements
	@FindBy(id="customer_firstname") WebElement firstName;
	@FindBy(id= "customer_lastname") WebElement lastName;
	@FindBy(id= "passwd") WebElement Password;
	@FindBy(id="newsletter") WebElement newsletterCheckBox;
	@FindBy(id= "submitAccount") WebElement Register;
	
	
	@FindBy(xpath= "//a[@title='View my customer account']") WebElement username;
	
	
	
	
	//perform action on WebElement
	
	public void clickGenderMr() throws InterruptedException
	{
		title_Mr.click();	
		Thread.sleep(30);
	}
	
	public void clickGenderMrs()
	{
		title_Mrs.click();	
	}
	
	public void enterFirstName(String fName) throws InterruptedException
	{
		firstName.sendKeys(fName);	
		Thread.sleep(30);
	}
	
	public void enterLastName(String lName) throws InterruptedException
	{
		lastName.sendKeys(lName);	
		Thread.sleep(30);
	}

	public void createPassword(String pass)
	{
		Password.sendKeys(pass);	
	}
	
	
	public void clickOnNewLetterCheckBox() throws InterruptedException 
	{
		newsletterCheckBox.click();	
		Thread.sleep(30);
		
	}
	
	
	public void clickonRegister()
	{
		Register.click();	
	}
	
	public void verifyAccountCreated(String name)
	{
		String text =username.getText(); 
		
		Assert.assertEquals("Ritesh Kumar", text);
	}

	
}
