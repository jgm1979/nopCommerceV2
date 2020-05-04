package com.nopcommerce.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomersPage;

public class TC_SearchCustomer_004 extends BaseClass{
	
	@Test
	public void searchCustomer() throws InterruptedException
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
				
		for(int i=1;i<=3;i++)
		{
			
			driver.findElement(By.id("SearchEmail")).clear();
			driver.findElement(By.id("SearchFirstName")).clear();
			driver.findElement(By.id("SearchLastName")).clear();
			
			if(i==1)
			{
				searchcust.setSearchEmail("@nopCommerce.com");
				logger.info("Searching by email...");
			}
			else if(i==2) {
				
				searchcust.setSearchFirstName("Brenda");
				logger.info("Searching by First name...");
			}
			else if(i==3) {
				
				searchcust.setSearchLastName("Pan");
				logger.info("Searching by Last name...");
			}
			
			searchcust.clickOnSearchButton();
			Thread.sleep(3000);
		}
		
		logger.info("All searches by email, Firstname and lastname completed!!");
			
	}

}
