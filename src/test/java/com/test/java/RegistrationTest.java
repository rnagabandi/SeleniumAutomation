package com.test.java;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UselessFileDetector;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.data.pojo.User;
import com.registration.pages.BasePage;
import com.registration.pages.EmploymentPageUtil;
import com.registration.pages.RegistrationPageUtil;

public class RegistrationTest {

	@DataProvider(name="registrationData" , parallel = true)
	public Object[][] getData(){
		
		Object[][] data = new Object[5][1];
		
		for (int i = 0; i < 5; i++) {
			User user = new User();
			user.setFirstname("aaaa");
			user.setEmail("aa"+i+System.currentTimeMillis()+"@gmail.com");
			user.setNumber("1234509876");
			user.setPassword("Lasya1279#");
			
			data[i][0] = user;
		}
		
		
		return data;
		
	}
	
	@Test(dataProvider="registrationData")
	public void registerTest(User user){
		RegistrationPageUtil registration = new RegistrationPageUtil(null,true);
		EmploymentPageUtil employment = registration.register(user);
		if (employment.driver != null) {
			employment.driver.quit();
		}
	}
	
	@Parameters({"browser"})
	@BeforeSuite
	public void initializeProp(String browser){
		BasePage.browser = browser;
	}
	
	//@Test(dataProvider="registrationData" , threadPoolSize=5)
	private void testRegistration(User user) throws Exception{
		System.out.println(BasePage.browser);
		System.setProperty("webdriver.chrome.driver","D:\\automation_p\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","D:\\automation_p\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver","D:\\automation_p\\IEDriverServer.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(false);
		
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://my.naukri.com/account/register/basicdetails");
		
		driver.findElement(By.xpath("//button[@value='exp']")).click();
		
		driver.findElement(By.id("fname")).sendKeys(user.getFirstname());
		driver.findElement(By.id("email")).sendKeys(user.getEmail());
		driver.findElement(By.name("password")).sendKeys(user.getPassword());
		driver.findElement(By.name("number")).sendKeys(user.getNumber());
		driver.findElement(By.xpath("//input[@name='expYear']")).sendKeys("7");
		driver.findElement(By.name("expMonth")).sendKeys("10");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(1000);
		
		driver.quit();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\automation_p\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","D:\\automation_p\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver","D:\\automation_p\\IEDriverServer.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(false);
		
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://my.naukri.com/account/register/basicdetails");
		
		driver.findElement(By.xpath("//button[@value='exp']")).click();
		
		driver.findElement(By.id("fname")).sendKeys("abc");
		driver.findElement(By.id("email")).sendKeys("abc"+System.currentTimeMillis()+"@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Lasya1279#");
		driver.findElement(By.name("number")).sendKeys("9898989809");
		driver.findElement(By.xpath("//input[@name='expYear']")).sendKeys("7");
		driver.findElement(By.name("expMonth")).sendKeys("10");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(100000);
		
		driver.quit();
		
	}
	
	
}
