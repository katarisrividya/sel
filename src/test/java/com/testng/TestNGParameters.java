package com.testng;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestNGParameters {
	@Parameters({"a","b"})
  @Test
  public void test1(int val1,int val2) {
		System.out.println("In Test case");
		int add=val1+val2;
		  System.out.println("Addition Of Test Level Parameters are"+add);
  }
  @Parameters({"a","b"})
  @BeforeSuite
  public void beforeSuite(int val1,int val2) {
	  System.out.println("In Before Suite");
	  int add=val1+val2;
	  System.out.println("Addition Of Suite Level Parameters are"+add);
  }

}
