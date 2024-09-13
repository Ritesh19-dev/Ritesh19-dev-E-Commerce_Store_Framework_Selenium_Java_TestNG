package com.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productTshirt 

{
	WebDriver ldriver;
	
	public productTshirt(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}
	
	
	//Location products
	
	@FindBy(xpath ="(//a[@class='products-block-image content_img clearfix'])[1]")  WebElement product_1;
	@FindBy(xpath ="(//a[@class='products-block-image content_img clearfix'])[2]") WebElement product_2;
	@FindBy(xpath ="(//a[@class='products-block-image content_img clearfix'])[3]") WebElement product_3;
	@FindBy(xpath ="(//a[@class='products-block-image content_img clearfix'])[4]") WebElement product_4;
	@FindBy(xpath ="(//a[@class='products-block-image content_img clearfix'])[5]") WebElement product_5;
	@FindBy(xpath ="(//a[@class='products-block-image content_img clearfix'])[6]") WebElement product_6;


	
	
	
	//Action performed on WebPage's WebElement
	
	public void selectProduct_1() throws InterruptedException
	{
		product_1.click();

	}
	
	public void selectProduct_2()
	{
		product_2.click();
	}
	
	public void selectProduct_3()
	{
		product_3.click();
	}
	
	public void selectProduct_4()
	{
		product_4.click();
	}
	
	public void selectProduct_5()
	{
		product_5.click();
	}
	
	public void selectProduct_6()
	{
		product_6.click();
	}
	
	

}
