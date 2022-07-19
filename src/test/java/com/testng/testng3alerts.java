package com.testng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class testng3alerts extends LibraryFunctions2 {
	@Test(priority = -1)
	public void LoadingDemoAlertsPage() {
		System.out.println("inside Validate Alerts");
		driver.navigate().to(ObjProperties.getProperty("AlertURL")); //to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titleOfDemoAlerts = driver.getTitle();
		System.out.println("titleOfDemoAlerts: " + titleOfDemoAlerts);
		Assert.assertEquals(titleOfDemoAlerts, ObjProperties.getProperty("DemoAlertsTitle"));
	}

	@Test(priority = 0)
	public void ValidateAlertsInsideAlertPage() throws InterruptedException  {
		System.out.println("inside ValidateAlerts checking all alerts");

		// Normal Alert
		driver.findElement(By.name("alert")).click();
		Alert alertbt1=driver.switchTo().alert();
		String txtonalert1=alertbt1.getText();
		Thread.sleep(2000);
		Assert.assertEquals(txtonalert1,ObjProperties.getProperty("Alert1text"));
		alertbt1.accept();
		Thread.sleep(2000);
		
		//Confirmation Alert
		driver.findElement(By.name("confirmation")).click();
		Alert alertbtconfirm=driver.switchTo().alert();
		Thread.sleep(2000);
		alertbtconfirm.dismiss();
		Thread.sleep(2000);
		
		//prompt
		driver.findElement(By.name("prompt")).click();
		Alert alertbt2=driver.switchTo().alert();
		alertbt2.sendKeys(ObjProperties.getProperty("Alert2SendKeysToPrompt"));
		Thread.sleep(1000);
		alertbt2.accept();
		
		//File Upload
		driver.findElement(By.xpath("//input[@name='upload']")).sendKeys(ObjProperties.getProperty("FileUploadPath"));
		//String actualFileName=driver.findElement(By.xpath("//input[@name='upload']")).getText();
		//System.out.println(actualFileName); //UNABLE TO COMPARE THE FILE NAME
	    //Assert.assertEquals(actualFileName,ObjProperties.getProperty("FileName"));
		
		//SUBMENU DIRECT TO OTHER PAGE
		driver.findElement(By.id("sub-menu")).click();
		driver.findElement(By.xpath("//a[text()='Google']")).click();
		Assert.assertEquals(driver.getTitle().toString(),"Google");
		Thread.sleep(1000);
		driver.navigate().back();
		
		//DoubleClick
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(By.id("double-click"));
		actions.doubleClick(ele).perform();
		Thread.sleep(1000);
		Alert alertdouble=driver.switchTo().alert();
		Assert.assertEquals(alertdouble.getText(), ObjProperties.getProperty("DoubleClickText"));
		alertdouble.accept();
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
