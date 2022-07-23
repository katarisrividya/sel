package com.testng;

import java.io.IOException;
import java.util.Set;

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
import com.page.windowspage;
import com.utility.Constant;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

public class testng6windows extends windowspage {
	@Test(priority = -1)

	public void ValidateWindowstitle() throws InterruptedException {
		driver.navigate().to(ObjProperties.getProperty("WindowsURL1"));
		WaitingForPageToLoad(Constant.PageLoadTimeOut60Sec);
		String title=driver.getTitle();
		System.out.println("Title Of webpage"+title);
		Assert.assertEquals(title, ObjProperties.getProperty("WindowsTitle1"));
		
	}

	@Test(priority = 0)
	public void ValidateWindowstutorialshut() throws InterruptedException {
		
		//To scroll to the particular element
		WebElement ele = driver.findElement(NewBrowserWindowbtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		//MainWindowHandle
		String ParentWindowHandle = driver.getWindowHandle();
		//ele.click(); //added
		//Operations for multiple window
		 //clickToOpenNewWindow();
		 //Thread.sleep(3000);
		clickOnWebElement(NewBrowserWindowbtn); //better to comment this as not working
		clickOnWebElement(NewMessageWindowbtn);
		clickOnWebElement(NewBrowserTabbtn);
		Set<String> AllWindows = driver.getWindowHandles();
		
		System.out.println("No.of new windows and tabs opened "+AllWindows.size());
		for (String IndividualWindow : AllWindows) {
			driver.switchTo().window(IndividualWindow);
			//String Title = driver.getTitle();
			//System.out.println("Title:" + Title);
			if(!ParentWindowHandle.equalsIgnoreCase(IndividualWindow)) {
				driver.switchTo().window(IndividualWindow);
				Thread.sleep(1000);
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
