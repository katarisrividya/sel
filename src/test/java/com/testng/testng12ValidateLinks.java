package com.testng;

import java.io.IOException;
import java.util.List;
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

public class testng12ValidateLinks {
	@Test(priority = -1)
	public void LoadingLinkPage() {
		System.out.println("inside Validate Links");
		LibraryFunctions2.driver.navigate().to(LibraryFunctions2.ObjProperties.getProperty("Links")); // to direct to the website navigate is used
		LibraryFunctions2.WaitingForPageToLoad(60);
		String titleOfLinksPage = LibraryFunctions2.driver.getTitle();
		System.out.println("titleOfLinksPage:" + titleOfLinksPage);
		//Assert.assertEquals(titleOfDemoAlerts, ObjProperties.getProperty("DemoAlertsTitle"));
	}

	@Test(priority = 0)
	public void ValidateLinks() throws InterruptedException {
		System.out.println("inside Validate Links");
		List<WebElement> All_links=LibraryFunctions2.driver.findElements(By.tagName("a"));
		for(int i=1;i<All_links.size();i++) {
			String Individual_Link=All_links.get(i).getAttribute("href");
			try {
				LibraryFunctions2.CheckLink(Individual_Link);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
