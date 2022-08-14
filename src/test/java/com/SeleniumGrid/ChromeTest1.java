package com.SeleniumGrid;

import org.testng.annotations.Test;

import com.utility.LibraryFunctions2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ChromeTest1 extends LibraryFunctions2 {
  @Test
  public void testChromeUsingGrid() {
	  System.out.println("Inside testcase Using chrome");
	  driver.get("https://www.amazon.in/");
	  System.out.println("The title of the webpage is"+driver.getTitle());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method");
	  driver=LibraryFunctions2.getBrowserCapabilities("chrome");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite");
  }

}
