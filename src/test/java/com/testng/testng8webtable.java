package com.testng;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import com.page.dropdownpage;
import com.page.webtablepage;
import com.utility.Constant;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

public class testng8webtable extends webtablepage {
	@Test(priority = -1)
	public void LoadingWebTablePage() {
		System.out.println("inside Web Table Page");
		driver.navigate().to(ObjProperties.getProperty("webtableurl")); // to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titleOfWebTable = driver.getTitle();
		System.out.println("titleOfWebTable: " + titleOfWebTable);
		// Assert.assertEquals(titleOfWebTable,
		// ObjProperties.getProperty("webtabletitle"));
	}

	@Test(priority = 1)
	public void ValidateWebTable() {
		List<WebElement> AllRows = driver.findElements(RowsInWebtable);
		int NumberOfRows = AllRows.size();
		for (int row = 2; row <= NumberOfRows; row++) {
			String field = driver.findElement(By.xpath("//table[@id='webtable']/tbody/tr[" + row + "]/td[3]"))
					.getText();
			if (field.equals("Social Media")) {
				String Link = driver.findElement(By.xpath("//table[@id='webtable']/tbody/tr[" + row + "]/td[1]"))
						.getText();
				String Title = driver.findElement(By.xpath("//table[@id='webtable']/tbody/tr[" + row + "]/td[2]"))
						.getText();
				System.out.println("Link:" + Link);
				System.out.println("Title" + Title);
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
