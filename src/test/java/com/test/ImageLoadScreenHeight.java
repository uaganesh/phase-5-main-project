package com.test;

import org.testng.annotations.Test;
import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImageLoadScreenHeight {
	
	WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver", "D:\\phase5\\eclipseprograms\\AutomateFlipkart\\chromedriver\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("start-maximized");
		  driver = new ChromeDriver(options);
	  }
	
	  @Test
	  public void ImageLoadScreenHeightTest() throws InterruptedException {
		  driver.get("https://www.flipkart.com/");
		  WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		  sign_in_cross.click();
		  java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  int width = (int) screenSize.getWidth();
		  int height = (int) screenSize.getHeight();
		  System.out.println("Resoultion of the device :  Screen  width "+ width+" Screen Height "+height );
		  int widthimg=driver.findElement(By.xpath("//img[@class='kJjFO0 _3DIhEh']")).getSize().getWidth();
	      int heightimg=driver.findElement(By.xpath("//img[@class='kJjFO0 _3DIhEh']")).getSize().getHeight();
	      System.out.println("Resoultion of the image :  Image  width "+ widthimg+" Image Height "+heightimg );
		  WebElement img = driver.findElement(By.xpath("//div[@class='_3ywSr_']"));     
		  if(img.isDisplayed()){
			  if (heightimg<height)
	      		{
	          		System.out.println("Images are loaded and visible till the screen height only"); 
	          		Reporter.log("Images are loaded and visible till the screen height only");
	      		}
		  }
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.close();
	  }


}
