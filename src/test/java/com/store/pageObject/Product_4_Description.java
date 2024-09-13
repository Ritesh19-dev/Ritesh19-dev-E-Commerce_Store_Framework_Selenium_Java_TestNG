package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_4_Description 
{
	WebDriver ldriver;

	public Product_4_Description(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify the WeBElements for the product 4
	@FindBy(xpath = "//a[@id='color_8'][1]")WebElement dressColorWhite;
	@FindBy(xpath = "//a[@id='color_16'][1]")WebElement dressColorYellow;
	
	
	
	public void selectColourOfProduct(String color)
	{
		if(color == "White")
		{
			dressColorWhite.click();
		}
		
		if(color == "Yellow")
		{
			dressColorYellow.click();
		}
	}

}
