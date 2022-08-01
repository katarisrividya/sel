package com.testng;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

import com.page.windows2page;
import com.utility.Constant;
import com.utility.LibraryFunctions2;

public class testng6Windows2 extends windows2page {
	@Test(priority = -1)

	public void ValidateWindowstitle() throws InterruptedException {
		driver.navigate().to(ObjProperties.getProperty("WindowsURL2"));
		WaitingForPageToLoad(Constant.PageLoadTimeOut60Sec);
		String title = driver.getTitle();
		System.out.println("Title Of webpage" + title);
		Assert.assertEquals(title, ObjProperties.getProperty("WindowsTitle2"));

	}

	@Test(priority = 0)

	public void ValidateWindowspage() throws InterruptedException {
		String parent=driver.getWindowHandle();
		//New Tab
		clickOnWebElement(tab);
		//New Window
		clickOnWebElement(window);
		//Window Messsage
		//clickOnWebElement(windowMessage);
		
		Set<String> AllWindows = driver.getWindowHandles();
		for(String child:AllWindows) {
			if(!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				if(driver.findElement(By.id("sampleHeading")) != null ){
			    WebElement text1 = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text1.getText());
                Assert.assertEquals(text1.getText(),ObjProperties.getProperty("Windows2Windowheading"));
                driver.close();
				}
			}
		}
		driver.switchTo().window(parent);
		//Window Messsage
		clickOnWebElement(windowMessage);
		Set<String> AllWindows2 = driver.getWindowHandles();
		System.out.println("No of Windows opened after clicking windows message box"+AllWindows2.size());
		for(String child:AllWindows2) {
			if(!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Thread.sleep(1000);
			    String text2 = driver.findElement(By.xpath("//body")).getAttribute("outerHTML"); //AS text in body is in "" we can't get text by .getText() 
			    System.out.println("Message " + text2);
			    //String bodymsg=driver.getPageSource();  //USING PAGESOURCE DIDNOT WORK
			    //System.out.println("Message " + bodymsg);
                //Assert.assertEquals(text2.getText(),ObjProperties.getProperty("Windows2NewWindowMessage"));
                driver.close();
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
