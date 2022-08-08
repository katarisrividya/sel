package com.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;

public class TestNGclassParallel2 {
	public WebDriver driver;
	
  @Test
  public void testInternetExplorer1() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside test 1 of class 2The thread id"+id);
  }
  @Test
  public void testInternetExplorer2() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside test 2 of class 2 The thread id"+id);
  }
  @BeforeClass
  public void beforeClass() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside before class The thread id"+id);
	  WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	  driver.get("https://www.amazon.in/"); 
  }

  @AfterClass
  public void afterClass() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside after class The thread id"+id);
  }

}
