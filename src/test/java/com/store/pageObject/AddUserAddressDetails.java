package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserAddressDetails 
{
	WebDriver ldriver;
	
	public AddUserAddressDetails(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// Identify the Web Elements of Address fields
	
	@FindBy(id = "company") WebElement companyName;
	@FindBy(id = "address1") WebElement userAdd;
	@FindBy(id = "city") WebElement cityName;
	@FindBy(id = "id_state") WebElement stateName;
	
	@FindBy(id = "postcode") WebElement zipCode;
	@FindBy(id = "phone_mobile") WebElement mobileNumber;
	@FindBy(id = "submitAddress") WebElement clickSave;
	
	
	public void enterCompanyName(String cname) throws InterruptedException
	{
		companyName.sendKeys(cname);
		Thread.sleep(30);
	}
	
	public void enterUserAdd(String uAdd) throws InterruptedException
	{
		userAdd.sendKeys(uAdd);
		Thread.sleep(30);
	}
	
	public void enterCityName(String cName) throws InterruptedException
	{
		cityName.sendKeys(cName);
		Thread.sleep(30);
	}
	
	public void enterStateName(String sName) throws InterruptedException
	{
		stateName.click();
		Select sb = new Select(stateName);
		sb.selectByVisibleText(sName);
		//stateName.sendKeys(sName);
	}
	
	public void enterzipCode(String zCode) throws InterruptedException
	{
		zipCode.sendKeys(zCode);
		Thread.sleep(20);
	}
	
	public void enterMobileNumber(String MNumber) throws InterruptedException
	{
		mobileNumber.sendKeys(MNumber);
		Thread.sleep(20);
	}
	
	public void clickOnSaveButton()
	{
		clickSave.click();
	}


}
