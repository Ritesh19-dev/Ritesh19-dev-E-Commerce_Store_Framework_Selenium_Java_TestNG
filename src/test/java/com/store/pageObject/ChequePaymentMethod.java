package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChequePaymentMethod 
{
	WebDriver ldriver;

	public ChequePaymentMethod(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}

	//Identify the WebElement
	@FindBy(xpath ="//button[@class='button btn btn-default button-medium']") WebElement cnfchequePayment;
	@FindBy(xpath ="//p[@class='alert alert-success']") WebElement successAlert;
	@FindBy(xpath ="//a[@title='Log me out']") WebElement logout;
	
	public void ConfirmChequePayment()
	{
		cnfchequePayment.click();
	}
	
	public String getOrderSuccessMessage()
	{
		return(successAlert.getText());
	}
	
	public void SignOut()
	{
		logout.click();
	}
	
	
}
