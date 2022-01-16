package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void LoginTest() throws IOException 
	{

		LoginPage lp= new LoginPage(driver);
		lp.setUsername(UserID);
		logger.info("User ID entered");
		lp.setPassword(Password);
		logger.info("Password entered");
		lp.ClickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Passed ");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
	}
	
	
}
