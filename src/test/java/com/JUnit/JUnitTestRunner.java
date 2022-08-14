package com.JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Junit1.class,
	LoginTestJunit.class
	
})
public class JUnitTestRunner {

}
