package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile 
{
	WebDriver ldriver;


	//Constructor
	public MyProfile(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//Search bar WebElement

	@FindBy(id ="search_query_top") WebElement search;
	@FindBy(xpath = "//button[@name='submit_search']")WebElement clicksearch;


	//Identify Sign Out WebElements 
	@FindBy(xpath ="//a[@title='Log me out']") WebElement logout;


	// Identify WebElements 
	@FindBy(xpath ="//a[@title='Add my first address']") WebElement MyAdd;
	@FindBy(xpath ="//a[@title='Orders']") WebElement orderHistory;
	@FindBy(xpath = "//a[@title='Credit slips']") WebElement CreditSlip;
	@FindBy(linkText = "Addresses") WebElement currentAdddress;
	@FindBy(xpath = "//a[@title='Addresses']") WebElement Add;
	@FindBy(xpath = "//a[@title='Information']") WebElement PersonalInfo;


	public void AddUserAddress() throws InterruptedException
	{
		MyAdd.click();
		Thread.sleep(20);
	}

	public void UserOrderHistory() throws InterruptedException
	{
		orderHistory.click();
		Thread.sleep(20);
	}

	public void UserCreditSlip() throws InterruptedException
	{
		CreditSlip.click();
		Thread.sleep(20);
	}

	public void UserCurrentAdddress() throws InterruptedException
	{
		currentAdddress.click();
		Thread.sleep(20);
	}
	public void UserPersonalInfo()
	{
		PersonalInfo.click();
	}
	public void MyAddress()
	{
		Add.click();
	}



	// Search bar method

	public void ClickSearchBar(String productName) throws InterruptedException
	{
		search.click();
		search.sendKeys(productName);

		clicksearch.click();
		Thread.sleep(30);

	}


	//Sign out WebElement

	public void ClickSignOut() throws InterruptedException
	{
		logout.click();
		Thread.sleep(20);

	}

}
