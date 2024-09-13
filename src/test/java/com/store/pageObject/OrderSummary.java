package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary 
{
	
	WebDriver ldriver;
		
		public OrderSummary(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this );
		}
		
		
		
		//Identify the WebElement
		@FindBy(xpath ="//a[@class='button btn btn-default standard-checkout button-medium']") WebElement proceedToCheckOutButton;
		@FindBy(xpath ="//a[@title='Continue shopping']") WebElement continueShoppingButton;
		
		
		
		public void ClickOnProceedToCheckOutButton()
		{
			proceedToCheckOutButton.click();
		}
		
		public void ClickOnContinueShoppingButton()
		{
			continueShoppingButton.click();
		}

}
