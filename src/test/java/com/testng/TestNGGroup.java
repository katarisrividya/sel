package com.testng;

import org.testng.annotations.Test;

public class TestNGGroup {
  @Test(groups = {"Group1"})
  public void test1() {
	  System.out.println("This is test 1 belongs to group1");
  }
  @Test(groups = {"Group2"})
  public void test2() {
	  System.out.println("This is test 2 belongs to group2");
  }
  @Test(groups = {"Group1","Group2"})
  public void test3() {
	  System.out.println("This is test 3 belongs to group1 and group 2");
  }
  @Test(groups = {"Group2"})
  public void test4() {
	  System.out.println("This is test 4 belongs to group2");
  }
}
