package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPayementMethod 
{
	WebDriver ldriver;

	public orderPayementMethod(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}

	//Identify the WebElement

	@FindBy(xpath ="//a[@class= 'bankwire']") WebElement bankPayment;
	@FindBy(xpath ="//a[@class= 'cheque']") WebElement chequePayment;


	public void PaymentByBank()
	{
		bankPayment.click();
	}

	public void PaymentByCheque()
	{
		bankPayment.click();
	}
}

