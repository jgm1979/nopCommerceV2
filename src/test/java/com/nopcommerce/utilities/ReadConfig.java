package com.nopcommerce.utilities;

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
			System.out.println("Exceptin is " + e.getMessage());
		}
	}
	
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUseremail()
	{
		String username = pro.getProperty("useremail");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxpath()
	{
		String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getIEpath()
	{
		String IEPath = pro.getProperty("iepath");
		return IEPath;
	}

}
