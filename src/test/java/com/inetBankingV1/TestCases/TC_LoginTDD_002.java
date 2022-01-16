package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.LoginPage;
import com.inetBankingV1.Utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginTDD_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void LoginTDD(String uname,String pwd) throws IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(uname);
		logger.info("Username entered");
		lp.setPassword(pwd);
		logger.info("Password entered");
		lp.ClickSubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver,"LoginTDD");
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.ClickLogoutButton();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	 
	
	public boolean isAlertPresent()      //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBankingV1/TestData/LoginData.xlsx";
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]= new String[rowcount][colcount];
		
		for(int i=1; i<=rowcount;i++)   //no of rows
		{
			for(int j=0; j<colcount;j++) //no of colums
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		
		return loginData;
		
	}
	
	
	

}
