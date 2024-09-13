package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductCommonDescription 
{
	WebDriver ldriver;

	public ProductCommonDescription(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}
	
	
	
	//Indetify the common product descriptions 
	
	@FindBy(xpath ="//select[@name='group_1']") WebElement sizeDropDown;
	@FindBy(xpath ="//button[@name='Submit']") WebElement addToCart;
	
	
	
	@FindBy(xpath ="//a[@title='Proceed to checkout']") WebElement proceedToCheckout;
	@FindBy(xpath ="//button[@name='Submit']") WebElement ContinueShopping;
	
	
	@FindBy(xpath ="(//h2[normalize-space()='Product successfully added to your shopping cart'])[1]") WebElement validate;
	@FindBy(xpath ="//a[@title='View my shopping cart']") WebElement cartVisible;
	
	
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
	
	
	public String validateProductAddedToCart() throws InterruptedException
	{
		
		String txt  = validate.getText();
		Thread.sleep(30);
		return txt;
		//Assert.assertEquals(word,"Product successfully added to your shopping cart", "Did not added to the cart");
	
	}
	
	public void validateShoppingCart()
	{
		 cartVisible.isDisplayed();
	}
	
	
	

}


