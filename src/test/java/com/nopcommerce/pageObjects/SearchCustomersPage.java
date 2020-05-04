package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomersPage {
	
	public WebDriver ldriver;
	
	public SearchCustomersPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By txtSearchEmail=By.id("SearchEmail");
	By txtSearchFirstName=By.id("SearchFirstName");
	By txtSearchLastName=By.id("SearchLastName");
	By btnSearch=By.id("search-customers");
	
	By btnDropDown=By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[1]/div/div/button[2]");
	
	public void onClickbtnDropDown()
	{
		ldriver.findElement(btnDropDown).click();
	}
	
	public void setSearchEmail(String searchEmail)
	{
		ldriver.findElement(txtSearchEmail).sendKeys(searchEmail);
	}
	
	public void setSearchFirstName(String searchFirstName)
	{
		ldriver.findElement(txtSearchFirstName).sendKeys(searchFirstName);
	}

	public void setSearchLastName(String searchLastName)
	{
		ldriver.findElement(txtSearchLastName).sendKeys(searchLastName);
	}
	
	public void clickOnSearchButton()
	{
		ldriver.findElement(btnSearch).click();
	}

}
