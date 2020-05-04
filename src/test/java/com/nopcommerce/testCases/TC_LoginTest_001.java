package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
		
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		
		logger.info("URL is opened...");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		
		lp.clickLogin();
		logger.info("Login is clicked");
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login Passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		
	}
	
}
