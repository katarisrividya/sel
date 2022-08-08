package com.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/*public class TestNGFactory {
	String testdata ;
	 int objectID ;
	 
	 public TestNGFactory(int ojectID, String testdata)
	 {
	 this.objectID = ojectID ;
	 this.testdata= testdata ;
	 }
	 
	 @BeforeClass 
	 public void beforeClass(){ 
	 System.out.println("This is before class of " + objectID); 
	 } 
	 
	 @Test 
	 public void testmethod(){ 
	 System.out.println("This is test method, testdata is :" + testdata); 
	 }
	 
	 @AfterClass 
	 public void afterClass(){ 
	 System.out.println("This is after class of " + objectID); 
	 } 
	 
	 @Factory
	 public Object[] fac() {
			return new Object[] { 
					new TestNGFactory(1,"TestNG1"), 
					new TestNGFactory(2,"TestNG2"),
					new TestNGFactory(3,"TestNG3")  };
		}
}*/
public class TestNGFactory {
	 String testdata ;
	 
	 public TestNGFactory(String testdata)
	 {
	 this.testdata= testdata ;
	 }

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before beforeClass executed.");
	}

	@Test
	public void testMethod1() {
		System.out.println("testMethod1 testdata is and id is"+testdata);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("testMethod2 doesnot have parameters parameters");
	}
	

	@Factory
	public Object[] fac() {
		return new Object[] { 
				new TestNGFactory("hello"), 
				new TestNGFactory("hi"),
				new TestNGFactory("how are you?") 
				 };
	}
}

