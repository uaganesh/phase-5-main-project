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

public class Verifyimageload {
	WebDriver driver;
  @Test
  public void ImageLoadTest() throws InterruptedException {
	  driver.get("https://www.flipkart.com/search?q=iphone+13&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_2_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_2_na_na_na&as-pos=1&as-type=RECENT&suggestionId=iphone+13%7CMobiles&requestId=3d5b7aab-04c8-4c8e-a7d0-eec3d742a906&as-searchtext=ip");
	  WebElement img = driver.findElement(By.xpath("//div[@class='CXW8mj']"));     
      if (img.isDisplayed()) 
      {
          System.out.println("Image is not present before scrolling"); 
          Reporter.log("Image is not present before scrolling");
      }
    	  Thread.sleep(1000);
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  js.executeScript("window.scrollBy(0,500)", "");
          WebElement img1 = driver.findElement(By.xpath("//div[@class='CXW8mj']")); 
          if(img1.isDisplayed()) {
        	  System.out.println("Image is present after scrolling"); 
        	  Reporter.log("Image is present after scrolling");
          }
          
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
