package com.testng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import com.utility.LibraryFunctions2;

public class testng3alerts2 extends LibraryFunctions2 {
	public static Actions actions;

	@Test(priority = -1)
	public void LoadingDemoAlertsPage() {
		System.out.println("inside Validate Alerts");
		driver.navigate().to(ObjProperties.getProperty("AlertURL2")); // to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		String titleOfDemoAlerts = driver.getTitle();
		System.out.println("titleOfDemoAlerts: " + titleOfDemoAlerts);
		Assert.assertEquals(titleOfDemoAlerts, ObjProperties.getProperty("DemoAlertsTitle2"));
	}

	@Test(priority = 0)
	public void ValidateAlertsNormalAlert() throws InterruptedException {
		System.out.println("inside ValidateAlerts checking all alerts");

		// Normal Alert
		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Generate Alert Box')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		actions = new Actions(driver);
		actions.moveToElement(ele).click(ele);
		actions.build().perform();
		Thread.sleep(2000);
		Alert alertbt1 = driver.switchTo().alert();
		String txtonalert1 = alertbt1.getText();
		Assert.assertEquals(txtonalert1, "Cick Ok or Cancel to proceed");
		alertbt1.accept();
		String txtafteralert1 = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(txtafteralert1, ObjProperties.getProperty("DemoAlerts2.1textvalidation"));
		Thread.sleep(1000);

	}

	@Test(priority = 1)
	public void ValidateAlertsEnterAlertsinTextBox() throws InterruptedException {
		// promptalert
		WebElement ele1 = driver.findElement(By.xpath("//button[text()='Enter text in Alert Box']"));
		actions = new Actions(driver);
		actions.moveToElement(ele1).click(ele1);
		actions.build().perform();
		Thread.sleep(2000);
		Alert alertbt2 = driver.switchTo().alert();
		alertbt2.sendKeys("Hi this is 2nd alert test");
		alertbt2.accept();
		String txtafteralert2 = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(txtafteralert2, "You entered: Hi this is 2nd alert test");

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
