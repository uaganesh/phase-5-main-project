package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class navigatebottom {
	WebDriver driver;
	
	@BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver", "D:\\phase5\\eclipseprograms\\AutomateFlipkart\\chromedriver\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("start-maximized");
		  driver = new ChromeDriver(options);
	  }
	
  @Test
  public void NavigateBottonTest() {
	  String url = "https://www.flipkart.com/";
	  driver.get(url);
	  WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	  sign_in_cross.click();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  //Scroll down till the bottom of the page
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Reporter.log("Navigated to the Bottom of the Page.");
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }

}
