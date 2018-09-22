package com.registration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage {
	
	public WebDriver driver;
	
	public static String browser;
	
	public BasePage(WebDriver driver){
		
		if (driver==null) {
			
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","D:\\automation_p\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setAcceptInsecureCerts(false);
				this.driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","D:\\automation_p\\geckodriver.exe");
				this.driver = new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver","D:\\automation_p\\IEDriverServer.exe");
				this.driver = new InternetExplorerDriver();				
			}
			this.driver.manage().window().maximize();
			driver=this.driver;
		}else{
			this.driver = driver;
		}
		
	}

}
