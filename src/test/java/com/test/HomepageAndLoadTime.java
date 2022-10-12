package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomepageAndLoadTime {
	
	WebDriver driver = null;
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\phase5\\eclipseprograms\\AutomateFlipkart\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void homepageAndLoadTimeTest() {
		long start = System.currentTimeMillis();
		driver.get("https://www.flipkart.com/");
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime+ " milliseconds");
		Reporter.log("Total Time for page load - "+totalTime+ " milliseconds <br>");	
		Reporter.log("Chrome Invoked and navigated to home page");
		}
}
