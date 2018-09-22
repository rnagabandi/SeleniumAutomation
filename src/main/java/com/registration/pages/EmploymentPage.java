package com.registration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EmploymentPage extends BasePage{
	
	public EmploymentPage(WebDriver driver,boolean openPageUrl){
		super(driver);
		if (openPageUrl) {
			this.driver.get("");
		}
		Assert.assertTrue(this.driver.getPageSource().contains("Resume Manager"));
	}

}
