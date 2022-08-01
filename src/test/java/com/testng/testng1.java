package com.testng;

import org.testng.annotations.Test;

import com.utility.LibraryFunctions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testng1 extends LibraryFunctions {
  @Test(priority=-1)
  public void validateamazonpageloading() {
	  System.out.println("This is test1");
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  String title=driver.getTitle();
	  System.out.println("title "+title);
	  Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
  }
  @Test(priority=0)
  public void validatesearch() {
	  System.out.println("This is test to validate search");
	  driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
	  driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptops");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  String title=driver.getTitle();
	  Assert.assertEquals(title,"Amazon.in : Laptops");
  }
 @Test(priority=1)
  public void filterByBrand() {
	  System.out.println("This test is to validate by brand");
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[contains(text(),'HP')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
	 
	  //driver.findElement(By.xpath("//span[contains(text(),'Dell')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
	  //driver.findElement(By.xpath("//span[contains(text(),'Apple')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
  }
  @Test(priority=2)
  public void filterByBrand1() {
	  System.out.println("This test is to validate by brand");
	  driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	  //driver.findElement(By.xpath("//span[contains(text(),'HP')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Dell')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
	  //driver.findElement(By.xpath("//span[contains(text(),'Apple')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
  }
  @Test(priority=3)
  public void filterByBrand2() {
	  System.out.println("This test is to validate by brand");
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  //driver.findElement(By.xpath("//span[contains(text(),'HP')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
	  //driver.findElement(By.xpath("//span[contains(text(),'Dell')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Samsung')]//preceding-sibling::div[contains(@class,'a-checkbox')]//i")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
	  LibraryFunctions.LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is before suite");
	  try {
		LibraryFunctions.ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite");
  }

}
