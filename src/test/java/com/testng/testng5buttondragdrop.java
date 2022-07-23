package com.testng;

import java.io.IOException;

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

import com.page.buttondragdroppage;
import com.utility.Constant;
import com.utility.LibraryFunctions2;

public class testng5buttondragdrop extends buttondragdroppage {

	
	@Test(priority = -1)
	  
	  public void Validatebuttons() throws InterruptedException {
	  driver.navigate().to(ObjProperties.getProperty("buttonsURL"));
	  WaitingForPageToLoad(Constant.PageLoadTimeOut60Sec); 
	  //NormalClick
	  normalclickaction();
	  Assert.assertEquals(getText(normalclicktext),ObjProperties.getProperty(
	  "normalclicktext"));
	  
	  //Rightclick 
	  RightClick(rightclickbutton);
	  Assert.assertEquals(getText(rightclicktext),ObjProperties.getProperty(
	  "rightclicktext"));
	  
	  //Double click 
	  DoubleClick(doubleclickbutton);
	  Assert.assertEquals(getText(doubleclicktext),ObjProperties.getProperty(
	  "doubleclicktext")); 
	  Thread.sleep(2000);
		WebElement ele = driver.findElement(rightclicktext);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
	  }

	@Test(priority = 0)
	public void draganddrop1() {
		driver.navigate().to(ObjProperties.getProperty("dragdrropURL1"));
		// WaitingForPageToLoad(Constant.PageLoadTimeOut60Sec);

		DragAndDrop(buttondragdroppage.drag1, buttondragdroppage.drop1);
	}

	@Test(priority = 1)
	public void draganddrop2() {
		driver.navigate().to(ObjProperties.getProperty("dragdropURL2"));

		WebElement ele = driver.findElement(drag2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		//WaitingForPageToLoad(Constant.PageLoadTimeOut60Sec);

		DragAndDrop(buttondragdroppage.drag2, buttondragdroppage.drop2);
		/*WebElement source = driver.findElement(By.xpath("//button[text()='Drag FROM']"));
		// To get target locator
		WebElement target = driver.findElement(By.xpath("//button[text()='Drop TO']"));
		Actions action = new Actions(driver);
		//Building a drag and drop action and performing the action
		action.dragAndDrop(source, target).build().perform();*/
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
	//	driver.close();
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
