package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddress
{
	
	WebDriver ldriver;
		
		public OrderAddress(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver,this );
		}
		
		
		
		//Identify the WebElement
		@FindBy(xpath ="//input[@id='addressesAreEquals']") WebElement tickCheckBox;

		@FindBy(xpath ="//button[@class= 'button btn btn-default button-medium']") WebElement proceedToCheckOutButton;


		public void ClickOnCheckBox()
		{
			tickCheckBox.click();
		}
		
		public void ClickOnProceedToCheckOutButton()
		{
			proceedToCheckOutButton.click();
		}
}
