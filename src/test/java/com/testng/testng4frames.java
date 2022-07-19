package com.testng;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
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

import com.utility.LibraryFunctions2;

public class testng4frames extends LibraryFunctions2 {
	@Test(priority = -1)
	public void ValidatingFrame() {
		System.out.println("inside ValidatingFrame");
		driver.navigate().to(ObjProperties.getProperty("FramesURL"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titleofFrames = driver.getTitle();
		System.out.println("titleofFrames: " + titleofFrames);
		Assert.assertEquals(titleofFrames, ObjProperties.getProperty("TitleOfFrames"));

	}

	@Test(priority = 0)
	public void Practicingiframes() throws InterruptedException {
		System.out.println("Practicing iframe 1");
		driver.switchTo().frame("frame1"); //With name
		driver.findElement(By.xpath("//input")).sendKeys(ObjProperties.getProperty("Frame1text"));
		Thread.sleep(1000);
		//driver.switchTo().defaultContent();
		
		//frame 3
		System.out.println("iframe 3 ,it resides in iframe 1 "); //so without defaultcontent we get to frame 3
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent(); //TO get to web page as iframe 2 will be in web page seperately like iframe 1
		
		//frame 2
		System.out.println("iframe 2");
		WebElement element=driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//select[@id='animals']")).click();
		Select animals=new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		animals.selectByValue("cat"); //Select By Value
		Thread.sleep(2000);
		animals.selectByIndex(3);
		driver.findElement(By.xpath("//select[@id='animals']")).click();
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
