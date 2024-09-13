package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bankPayementMethod 
{
	WebDriver ldriver;

	public bankPayementMethod(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}

	//Identify the WebElement
	@FindBy(xpath ="//button[@class='button btn btn-default button-medium']") WebElement cnfbankPayment;


	public void ConfirmBankPayment()
	{
		cnfbankPayment.click();
	}

}
