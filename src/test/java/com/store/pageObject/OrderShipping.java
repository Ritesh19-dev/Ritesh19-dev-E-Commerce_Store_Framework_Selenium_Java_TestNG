package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShipping 
{
	WebDriver ldriver;
	
	public OrderShipping(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}
	
	//Identify the WebElement
	
	@FindBy(xpath ="//input[@type= 'checkbox']") WebElement btn;
	@FindBy(xpath ="//button[@class= 'button btn btn-default standard-checkout button-medium']") WebElement proceedToCheckOutButton;

	
	public void ClickOnTermsAndConditionCheckBox()
	{
		btn.click();
	}
	
	public void ClickOnProceedToCheckOutButton()
	{
		proceedToCheckOutButton.click();
	}
}
