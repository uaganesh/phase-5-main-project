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

public class CheckScroll {
	
	WebDriver driver;
	  @Test
	  public void scrollBarTest() throws InterruptedException {
		  driver.get("https://www.flipkart.com/");
		  WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		  sign_in_cross.click();
		  driver.findElement(By.xpath("//div[@class='CXW8mj']")).click();
		  Thread.sleep(1000);
		  JavascriptExecutor javascript = (JavascriptExecutor) driver;
		  //Check If horizontal scroll Is present or not.
		  Boolean b1 = (Boolean) javascript.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
		  //Check If vertical scroll Is present or not.
		  Boolean b2 = (Boolean) javascript.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
		  if (b1 == true && b2 == true) {
		   System.out.println("Horizontal and vertical Scrollbar is present on page.");
		  } else if (b1 == false && b2 == true) {
		   System.out.println("Horizontal Scrollbar not present on page.");
		   System.out.println("Vertical Scrollbar is present on page.");
		   Reporter.log("Horizontal Scrollbar not present on page,Vertical Scrollbar is present on page.");
		  }else if (b1 == true && b2 == false) {
		   System.out.println("Horizontal Scrollbar Is present on page.");
		   System.out.println("Vertical Scrollbar not present on page.");
		  }else if (b1 == false && b2 == false) {
		   System.out.println("Horizontal and Vertical Scrollbar not present on page.");   
		  }
		  System.out.println("<----------x--------x--------->");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver", "D:\\phase5\\eclipseprograms\\AutomateFlipkart\\chromedriver\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("start-maximized");
		  driver = new ChromeDriver(options);
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }


}
