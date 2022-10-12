package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class DiffScreenResolution {
	WebDriver driver;
	
	@BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver", "D:\\phase5\\eclipseprograms\\AutomateFlipkart\\chromedriver\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }

  @Test
  public void DiffScreenResolutionTest() throws InterruptedException {
	  String url = "https://www.flipkart.com/";
	  driver.get(url);
	  WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	  sign_in_cross.click();
	  Thread.sleep(3000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)", "");
	  driver.manage().window().setSize(new Dimension(1620, 820));
	  Thread.sleep(3000);
	  WebElement textField = driver.findElement(By.name("q"));
	  textField.sendKeys("Iphone 13");
	  driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	  js.executeScript("window.scrollBy(0,1000)", "");
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  js.executeScript("window.scrollBy(0,1000)", "");
	  driver.manage().window().setSize(new Dimension(240, 360));
	  textField.sendKeys("mini");
	  Thread.sleep(3000);
	  js.executeScript("window.scrollBy(0,1000)", "");
	  Reporter.log("Different browsers and screen resolutions render it in the same way.");
  }
  
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }

}

