package com.registration.pages;

import org.openqa.selenium.WebDriver;

import com.data.pojo.User;

public class RegistrationPageUtil extends RegistrationPage {

	public RegistrationPageUtil(WebDriver driver, boolean openPageUrl){
		super(driver,openPageUrl);
	}
	
	public EmploymentPageUtil register(User user){
		enterFirstName(user.getFirstname());
		enterEmail(user.getEmail());
		enterNumber(user.getNumber());
		enterExpYear("7");
		enterNumber("9876512345");
		enterExpMonth("10");
		enterPasword("Swathi279$");
		clickSubmit();
		return new EmploymentPageUtil(this.driver,false);
	}
	
}
