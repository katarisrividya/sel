package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGParllelMethod {
  @Test
  public void test1() {
	  long id=Thread.currentThread().getId();
	  System.out.println("In test1 the id of thread is"+id);
  }
  @Test
  public void test2() {
	  long id=Thread.currentThread().getId();
	  System.out.println("In test2 the id of thread is"+id);
  }
  @Test
  public void test3() {
	  long id=Thread.currentThread().getId();
	  System.out.println("In test3 the id of thread is"+id);
  }
  @BeforeMethod
  public void beforeMethod() {
	  long id=Thread.currentThread().getId();
	  System.out.println("In Before Method the id of thread is"+id);
  }

  @AfterMethod
  public void afterMethod() {
	  long id=Thread.currentThread().getId();
	  System.out.println("In After Method the id of thread is"+id);
  }

}
