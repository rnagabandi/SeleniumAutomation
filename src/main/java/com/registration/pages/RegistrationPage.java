package com.registration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage extends BasePage{
	
	private final String PAGE_URL= "https://my.naukri.com/account/register/basicdetails";
	By firstName = By.id("fname");
	By email = By.id("email");
	By password = By.name("password");
	By number = By.name("number");
	By expYear = By.xpath("//input[@name='expYear']");
	By expMonth = By.name("expMonth");
	By submit = By.xpath("//button[@type='submit']");
	By pageTitle = By.xpath("//p[@class='title']");
	
	public RegistrationPage(WebDriver driver , boolean openPageUrl){
		super(driver);
		if (openPageUrl) {
			this.driver.get(PAGE_URL);
			this.driver.findElement(By.xpath("//button[@value='exp']")).click();
		}
		Assert.assertEquals(this.driver.findElement(pageTitle).getText(),"");
	}
	
	public void enterFirstName(String name){
		this.driver.findElement(this.firstName).sendKeys(name);
	}
	
	public void enterEmail(String email){
		this.driver.findElement(this.email).sendKeys(email);
	}
	
	public void enterPasword(String password){
		this.driver.findElement(this.password).sendKeys(password);
	}
	
	public void enterNumber(String number){
		this.driver.findElement(this.number).sendKeys(number);
	}
	
	public void enterExpYear(String exp){
		this.driver.findElement(this.expYear).sendKeys(exp);
	}
	
	public void enterExpMonth(String exp){
		this.driver.findElement(this.expMonth).sendKeys(exp);
	}
	
	public void clickSubmit(){
		this.driver.findElement(this.submit).click();
	}

}
