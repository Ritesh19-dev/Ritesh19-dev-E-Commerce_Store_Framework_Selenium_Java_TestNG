package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_5_Description {
	WebDriver ldriver;

	public Product_5_Description(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify the WeBElements for the product 5
		@FindBy(xpath = "(//a[@id='color_15'])[1]")WebElement dressColorGreen;
		@FindBy(xpath = "(//a[@id='color_16'])[1]")WebElement dressColorYellow;

		public void selectColourOfProduct(String color)
		{
			if(color == "Green")
			{
				dressColorGreen.click();
			}

			if(color == "Yellow")
			{
				dressColorYellow.click();
			}
		}


}
