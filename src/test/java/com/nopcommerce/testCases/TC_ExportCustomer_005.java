package com.nopcommerce.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomersPage;

public class TC_ExportCustomer_005 extends BaseClass{
	
	@Test
	public void exportCustomer() throws InterruptedException
	{

		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is provided");
		
		lp.setPassword(password);
		logger.info("Password is provided");
		
		lp.clickLogin();
		logger.info("Login is clicked");
		
		SearchCustomersPage searchcust=new SearchCustomersPage(driver);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		searchcust.onClickbtnDropDown();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[1]/div/div/ul/li[1]/button")).click();
		
		Thread.sleep(10000);
		
	}

}
