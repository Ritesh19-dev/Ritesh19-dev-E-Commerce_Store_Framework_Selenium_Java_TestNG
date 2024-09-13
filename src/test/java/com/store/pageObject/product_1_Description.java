package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class product_1_Description 
{
	WebDriver ldriver;

	public product_1_Description(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}

	//Identify the WebElement

	@FindBy(xpath ="//select[@name='group_1']") WebElement sizeDropDown;
	@FindBy(xpath ="(//a[@id='color_8'])[1]") WebElement dressColorWhite;
	@FindBy(xpath ="(//a[@id='color_11'][1]") WebElement dressColorBlack;

	@FindBy(xpath ="//i[@class='icon-plus']") WebElement dressQuantity;
	@FindBy(xpath ="//button[@name='Submit']") WebElement addToCart;
	@FindBy(xpath ="//a[@title='Proceed to checkout']") WebElement proceedToCheckout;
	@FindBy(xpath ="//button[@name='Submit']") WebElement ContinueShopping;


	public void selectColourOfProduct(String color) throws InterruptedException
	{
		Thread.sleep(20);
		if(color == "White")
		{
			dressColorWhite.click();
		}
		if(color == "Black")
		{
			dressColorBlack.click();
		}


	}

	public void selectDressQuantity(String quantity) throws InterruptedException
	{

		Thread.sleep(20);
		dressQuantity.clear();
		dressQuantity.sendKeys(quantity);


		/*if(quantity >=1)
		{
			for(int j=1;j<=quantity;j++)
			{
				dressQuantity.click();
			}
		}*/


	}


	public void selectSizeOfProduct(String size) throws InterruptedException
	{
		Thread.sleep(20);
		sizeDropDown.click();

		Select dd = new Select(sizeDropDown);
		dd.selectByVisibleText(size);

	}


	public void moveProductToCart() throws InterruptedException
	{
		Thread.sleep(20);
		addToCart.click();

	}

	public void clickOnProccedButton()
	{
		proceedToCheckout.click();
	}
	public void clickOnContinueShopping()
	{
		ContinueShopping.click();
	}

}
