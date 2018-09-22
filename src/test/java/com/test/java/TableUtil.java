package com.test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TableUtil {
	
	
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","D:\\automation_p\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","D:\\automation_p\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver","D:\\automation_p\\IEDriverServer.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(false);
		
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://www.ebay.in/itm/253522736370?om_source=refurbmobile");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='section']/table[2]/tbody/tr"));
		
		for(WebElement element : list){
			List<WebElement> colums= element.findElements(By.xpath("//td"));
			for(WebElement column : colums){
				System.out.println(column.getText());
			}
		}
		
		driver.quit();
		
	}

}
