package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage 
{
	WebDriver ldriver;

	public indexPage(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}
	
	// identify web elements 
	
	@FindBy(linkText = "Sign in") WebElement signin;
	@FindBy(xpath= "//input[@id ='newsletter-input']") WebElement newLetter;
	@FindBy(xpath= "//p[@class='alert alert-success']") WebElement newLetterText;
	@FindBy(xpath= "//button[@name='submitNewsletter']") WebElement button;
	@FindBy(xpath= "//a[@title='All specials']") WebElement specialProduct;
	
	
	
	@FindBy(xpath= "(//a[@title='T-shirts'])[2]") WebElement tshirtMenu;
	
	//perform action on WebElement
	public void clickSignIn()
	{
		signin.click();
	}
	
	public String getIndexPageText()
	{
		return(signin.getText());
	}
	
	public void registerForNewsLetter(String email)
	{
		newLetter.sendKeys(email);
	}
	
	public void clickOnSubscribeButton()
	{
		button.click();
	}
	
	public String VerfiyTextForNewsLetter()
	{
		return(newLetterText.getText());
	}
	
	public void clickOnTshirtMenu()
	{
		tshirtMenu.click();
	}
	public void clickOnSpecialProduct()
	{
		specialProduct.click();
	}
	
	
	
	

}
