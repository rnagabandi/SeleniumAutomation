package com.test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class ChromeTests {
	
	public static void main(String[] args) throws InterruptedException {
		
		//WebDriver  driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver","D:\\automation_p\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","D:\\automation_p\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver","D:\\automation_p\\IEDriverServer.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(false);
		
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://amazon.in");
		
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("honor 7c mobiles");
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		
		List<WebElement> list =	driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li"));
		
		for(WebElement element: list){
			System.out.println("Text is :: " + element.findElement(By.xpath("//div[@class='a-row a-spacing-mini']/div[1]/a")).getText());		
		}
		
		
		Thread.sleep(1000);
		
		driver.quit();
	}

}
