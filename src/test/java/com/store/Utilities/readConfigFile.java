package com.store.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfigFile 
{
	Properties prop ;

	String path = "C:\\Users\\ritei\\eclipse-workspace\\E-comerce framework\\store\\Configuration\\config.properties";


	//Constructor
	public readConfigFile()
	{

		try 
		{
			prop = new Properties();


			FileInputStream file = new FileInputStream(path);

			prop.load(file);
		} 

		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}


	//Read url value from Config file
	public String getBaseUrl()
	{
		String urlValue= prop.getProperty("baseUrl");

		if(urlValue !=null)
		{
			return urlValue;
		}

		else
		{
			throw new RuntimeException("URL not specified in Config file");
		}
	}

	//Read browser value from Config file
	public String getBrowser()
	{
		String browserValue= prop.getProperty("browser");

		if(browserValue !=null)
		{
			return browserValue;
		}

		else
		{
			throw new RuntimeException("Browser not specified in Config file");
		}
	}


	public String verifyEmail()
	{
		String emailValue= prop.getProperty("email");
		String domain = "@gmail.com";
		int length = emailValue.length();
		int domainLength = domain.length();

		if(emailValue !=null && emailValue.contains("@gmail.com"))
		{
			for(int i =0 ; i< length; i++)
			{
				if(emailValue.charAt(i)=='@')
				{
					String wrd = emailValue.substring(i);
					if(wrd.length()==domainLength && length>domainLength)
					{
						return emailValue;
					}
				}
			}
			
		}

		else
		{
			throw new RuntimeException("Invalid Email id");
		}
		return emailValue;

	}

	public String verifyPassword()
	{
		String passwordValue= prop.getProperty("password");

		if(passwordValue !=null && passwordValue.length()>=5 )
		{
			return passwordValue;
		}

		else
		{
			throw new RuntimeException("Invalid Password");
		}
	}


	public String verifyNewLetterEmail()
	{
		String emailValue= prop.getProperty("newsLetterEmail");

		if(emailValue !=null && emailValue.contains("@gmail.com"))
		{
			return emailValue;
		}

		else
		{
			throw new RuntimeException("Invalid Email id");
		}

	}
}


