package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGparlleltestSuite {
  @Parameters({"Greetings"})
  @Test
  public void test1(String Greetings) {
	  long id=Thread.currentThread().getId();
	  System.out.println("Thread id in class test case 1 "+id+"and greeting are"+Greetings);
  }
  @Parameters({"Greetings"})
  @Test
  public void test2(String Greetings) {
	  long id=Thread.currentThread().getId();
	  System.out.println("Thread id in class test case 2 "+id+"and greeting are"+Greetings);
  }
  @Parameters({"Greetings"})
  @BeforeTest
  public void beforeTest(String Greetings) {
	  long id=Thread.currentThread().getId();
	  System.out.println("Thread id before test "+id+"and greeting are"+Greetings);
  }
  @Parameters({"Greetings"})
  @AfterTest
  public void afterTest(String Greetings) {
	  long id=Thread.currentThread().getId();
	  System.out.println("Thread id after test "+id+"and greeting are"+Greetings);
  }

  @BeforeSuite
  public void beforeSuite() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Thread id before suite"+id);
  }

  @AfterSuite
  public void afterSuite() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Thread id after suite"+id);
  }

}
