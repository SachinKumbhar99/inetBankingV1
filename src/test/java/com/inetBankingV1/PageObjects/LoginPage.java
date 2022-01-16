package com.inetBankingV1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement texttxtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement LoginButton;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement LogoutLink;
	
	
	
	public void setUsername(String uname)
	{
		texttxtUsername.sendKeys(uname);
	}
	
	
	public void setPassword(String Pwd)
	{
		textPassword.sendKeys(Pwd);
	}
	
	public void ClickSubmit()
	{
		LoginButton.click();
	}
	
	
	public void ClickLogoutButton()
	{
		LogoutLink.click();
	}
	
	
	
}
