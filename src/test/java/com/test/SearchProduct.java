package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchProduct {
	WebDriver driver = null;
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\phase5\\eclipseprograms\\AutomateFlipkart\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		driver.findElement(By.cssSelector("._2KpZ6l._2doB4z")).click();
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("pixel 4a");
		searchBox.submit();
		Reporter.log("Product Have Been Searched Successfully");
	}
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
