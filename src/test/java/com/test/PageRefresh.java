package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class PageRefresh {
	WebDriver driver;
  @Test
  public void PageRefreshTest() {
	  driver.get("https://www.flipkart.com/search?q=iphone+13&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_3_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_3_na_na_na&as-pos=1&as-type=RECENT&suggestionId=iphone+13%7CMobiles&requestId=ee111f6f-1edd-495d-9c8a-eec51bb9a9d5&as-searchtext=iph");
	  long startTime = System.currentTimeMillis();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)", "");
	  new WebDriverWait(driver, Duration.ofMinutes(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='CXW8mj']")));
	  long endTime = System.currentTimeMillis();
	  long totalTime = endTime - startTime;
	  System.out.println("Total Content Load Time while Scrolling: " + totalTime + " milliseconds");
	  Reporter.log("Total Content Load Time while Scrolling: " + totalTime + " milliseconds");
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
