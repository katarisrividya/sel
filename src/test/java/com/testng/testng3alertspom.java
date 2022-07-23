package com.testng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import com.page.alertspage;
import com.utility.LibraryFunctions2;

public class testng3alertspom extends alertspage {
	@Test(priority = -1)
	public void LoadingDemoAlertsPage() {
		System.out.println("inside Validate Alerts");
		driver.navigate().to(ObjProperties.getProperty("AlertURL")); // to direct to the website navigate is used
		WaitingForPageToLoad(60);
		String titleOfDemoAlerts = driver.getTitle();
		System.out.println("titleOfDemoAlerts: " + titleOfDemoAlerts);
		Assert.assertEquals(titleOfDemoAlerts, ObjProperties.getProperty("DemoAlertsTitle"));
	}

	@Test(priority = 0)
	public void ValidateAlertsInsideAlertPage() throws InterruptedException {
		System.out.println("inside ValidateAlerts checking all alerts");

		// Normal Alert
		clicknormalalert();
		alertbtnormal = driver.switchTo().alert();
		String txtonalert1 = alertbtnormal.getText();
		Thread.sleep(2000);
		Assert.assertEquals(txtonalert1, ObjProperties.getProperty("Alert1text"));
		acceptnormalalert();
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void confirmationalert() throws InterruptedException {
		// Confirmation Alert
		clickconfirmationalert();
		alertbtconfirm = driver.switchTo().alert();
		Thread.sleep(2000);
		dismissconfirmationalert();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void promptalert() throws InterruptedException {
		// prompt
		clickpromptalert();
		alertbtprompt = driver.switchTo().alert();
		entertextonpromptalert(ObjProperties.getProperty("Alert2SendKeysToPrompt"));
		Thread.sleep(1000);
		acceptpromptalert();

	}

	@Test(priority = 3)
	public void fileuploadalert() {
		// File Upload
		fileupload();
	}

	@Test(priority = 4)
	public void submenualert() throws InterruptedException {
		// SUBMENU DIRECT TO OTHER PAGE
		submenuclick();
		clickgooglesubmenu();
		Assert.assertEquals(driver.getTitle().toString(), "Google");
		Thread.sleep(1000);
		driver.navigate().back();
	}

	@Test(priority = 5)
	public void doubleclick() throws InterruptedException {
		// DoubleClick
		doubleclickalert();
		Thread.sleep(1000);
		alertdouble = driver.switchTo().alert();
		Assert.assertEquals(alertdouble.getText(), ObjProperties.getProperty("DoubleClickText"));
		doubleclickaccept();
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
