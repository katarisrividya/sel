package com.testng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.framepage;
import com.utility.LibraryFunctions2;

public class testng4framespom extends framepage {
	@Test(priority = -1)
	public void ValidatingFrame() {
		System.out.println("inside ValidatingFrame");
		driver.navigate().to(ObjProperties.getProperty("FramesURL"));
		WaitingForPageToLoad(60);
		String titleofFrames = driver.getTitle();
		System.out.println("titleofFrames: " + titleofFrames);
		Assert.assertEquals(titleofFrames, ObjProperties.getProperty("TitleOfFrames"));

	}

	@Test(priority = 0)
	public void Practicingiframes() throws InterruptedException {
		System.out.println("Practicing iframe 1");
		driver.switchTo().frame("frame1"); //With name
		entertextinframe1();
		Thread.sleep(1000);
		//driver.switchTo().defaultContent();
		
		//frame 3
		System.out.println("iframe 3 ,it resides in iframe 1 "); //so without defaultcontent we get to frame 3
		driver.switchTo().frame("frame3");
		checkinframe3();
		driver.switchTo().defaultContent(); //TO get to web page as iframe 2 will be in web page seperately like iframe 1
		
		//frame 2
		System.out.println("iframe 2");
		driver.switchTo().frame("frame2");
		clickonframe2();
		selectavatar();
		clickonframe2();
		driver.switchTo().defaultContent();
	}
	

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LibraryFunctions2.LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			LibraryFunctions2.ReadPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}
}
