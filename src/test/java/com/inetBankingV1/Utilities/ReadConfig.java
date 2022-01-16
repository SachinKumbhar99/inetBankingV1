package com.inetBankingV1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	
	public String GetApplicationURL()
	{
		String url=pro.getProperty("BaseURL");
		return url;
	}
	
	
	public String GetUsername()
	{
		String username=pro.getProperty("UserID");
		return username;
	}
	
	public String GetPassword()
	{
		String password=pro.getProperty("Password");
		return password;
	}
	
	
	public String GetChromepath()
	{
		String cromepath=pro.getProperty("chromepath");
		return cromepath;
	}
	
	public String GetEdgepath()
	{
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
	}
	

	public String GetFFpath()
	{
		String ffpath=pro.getProperty("firefoxPath");
		return ffpath;
	}
	
	
	
}
