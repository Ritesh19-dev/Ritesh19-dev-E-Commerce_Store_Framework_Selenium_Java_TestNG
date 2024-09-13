package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_6_Description 
{
	WebDriver ldriver;

	public Product_6_Description(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify the WeBElements for the product 6
			@FindBy(xpath = "(//a[@id='color_13'])[1]")WebElement dressColorOrange;
			@FindBy(xpath = "(//a[@id='color_14'])[1]")WebElement dressColorBlue;
			@FindBy(xpath = "(//a[@id='color_11'])[1]")WebElement dressColorBlack;
			@FindBy(xpath = "(//a[@id='color_16'])[1]")WebElement dressColorYellow;

			public void selectColourOfProduct(String color)
			{
				if(color == "Orange")
				{
					dressColorOrange.click();
				}

				else if(color == "Blue")
				{
					dressColorBlue.click();
				}
				
				else if(color == "Black")
				{
					dressColorBlack.click();
				}
				
				else
				{
					dressColorYellow.click();
				}
			}
	
	

}
