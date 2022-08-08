package com.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;

public class TestNGclassParallel1 {
	public WebDriver driver;
	
  @Test
  public void testsite1() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside test 1 of class 1The thread id"+id);
  }
  @Test
  public void testsite2() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside test 2 of class 1 The thread id"+id);
  }
  @BeforeClass
  public void beforeClass() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside before class The thread id"+id);
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	  driver.get("https://www.amazon.in/"); 
  }

  @AfterClass
  public void afterClass() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Inside after class The thread id"+id);
  }

}
