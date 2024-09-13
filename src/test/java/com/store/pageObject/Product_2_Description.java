package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_2_Description 
{
	WebDriver ldriver;

	public Product_2_Description(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}


	//Identify the WeBElements for the product 
	@FindBy(xpath = "(//a[@id='color_13'])[1]")WebElement dressColorOrange;
	@FindBy(xpath = "(//a[@id='color_14'])[1]")WebElement dressColorBlue;
	@FindBy(xpath ="//span[@id='availability_value']") WebElement outOFStock;
	
	
	public void selectColourOfProduct(String color)
	{
		if(color == "White")
		{
			dressColorOrange.click();
		}
		else if(color == "Blue")
		{
			dressColorBlue.click();
		}
	}
	
	
	public String CheckOutOfStock()
	{
		 String ofs = outOFStock.getText();
		 return (ofs);
	}
	
	
	
}
