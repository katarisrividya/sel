package com.JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Junit1 {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is before class Junit1");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("This is after class Junit1");
	}
	@After
	public void aftermethod() {
		System.out.println("This is after method Junit1");
	}
	@Test
	public void Junit1() {
		System.out.println("This is Junit1 test1");
	}
	@Test
	@Ignore
	public void Junit2() {
		System.out.println("This is Junit1 test2 with Ignore");
	}
	@Test
	public void Junit3() {
		System.out.println("This is Junit1 test3");
	}
	@Before
	public void beforemethod() {
		System.out.println("This is before method Junit1");
	}

}
