package com.testng;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TestNGDataProvider {
  @Test(dataProvider = "data")
  public void add(int val1,int val2,int res) {
		System.out.println("In Test case");
		int add=val1+val2;
		System.out.println("Addition Of"+add);
		Assert.assertEquals(res, add);
  }
  
  @Test(dataProvider = "data")
  public void sub(int val1,int val2,int res) {
		System.out.println("In Test case");
		int sub=val1-val2;
		System.out.println("Subtraction"+sub);
		Assert.assertEquals(res, sub);
   }
  @DataProvider
  public Object[][] data(Method m){
	 switch(m.getName()) {
	 case "add"://return new Object[][] {{2, 3 , 5}, {5, 7, 12}};
		         return new Object[][] {
		        	 new Object[] {2, 3 , 5},
		        	 new Object[] {5,7,12}
		         };
	 case "sub":return new Object[][] {{2, 3, -1}, {5, 7, -2}};
	 }
	 return null;
  }
}
