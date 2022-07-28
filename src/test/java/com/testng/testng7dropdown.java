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
import com.utility.Constant;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

public class testng7dropdown extends dropdownpage {
	@Test(priority = -1)
	public void LoadingDemoDropDownPage() {
		System.out.println("inside Validate DropDown");
		driver.navigate().to(ObjProperties.getProperty("dropdownurl1")); //to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titleOfDemoDropDown = driver.getTitle();
		System.out.println("titleOfDemoDropDown: " + titleOfDemoDropDown);
		Assert.assertEquals(titleOfDemoDropDown, ObjProperties.getProperty("DropDown1Title"));
	}
	@Test(priority = 0)
	public void validatedropdown() throws InterruptedException {
		
		//select products
		WebElement product=driver.findElement(dropdownProducts);
		Select sel1=new Select(product);
		options=sel1.getOptions();
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText()); //just to display options
		}
		product.click();
		sel1.selectByVisibleText("Google"); //select by visible text
		product.click();
		Thread.sleep(1000);
		
		//select Animals
		WebElement animal=driver.findElement(dropdownAnimals);
		Select sel2=new Select(animal);
		animal.click();
		sel2.selectByValue("avatar");    //select by value
		animal.click();
		Thread.sleep(1000);
		
		//custom dropdown //DOUDTH DIDNOT WORK
		/*WebElement custom=driver.findElement(customdropdown);
		CustomSelect 
		//Select sel3=new Select(custom);
		custom.click();
		sel3.selectByIndex(Constant.customdropdown); //By index*/
		
		
	}
	@Test(priority = 1)
	public void Multipleselect() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		//Multiple select
		WebElement food=driver.findElement(foodselection);
		Select sel4=new Select(food);
		sel4.selectByVisibleText("Burger");
		sel4.selectByVisibleText("Bonda");
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
