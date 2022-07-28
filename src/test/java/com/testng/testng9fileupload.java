package com.testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
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
import com.page.fileuploadpage;
import com.utility.Constant;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

public class testng9fileupload extends fileuploadpage {
	@Test(priority = -1)
	public void LoadingFileUploadPage() {
		System.out.println("inside File Upload");
		driver.navigate().to(ObjProperties.getProperty("fileupload")); //to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titleOfFileUpload = driver.getTitle();
		System.out.println("titleOfFileUpload: " + titleOfFileUpload);
		//Assert.assertEquals(titleOfFileUpload, ObjProperties.getProperty("FileUploadTitle"));
	}
	@Test(priority = 0)
	public void validatefileUpload() throws InterruptedException {
		//driver.findElement(fileupload).sendKeys(ObjProperties.getProperty("FileUploadPath")); //TYPE-1

		Actions obj=new Actions(driver);
		WebElement ele=driver.findElement(fileupload);
		obj.click(ele).build().perform();
		
		StringSelection objStringSelection = new StringSelection(
				System.getProperty("user.dir") + "\\src\\test\\resources\\fileupload.txt");
		Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		objClipboard.setContents(objStringSelection, null);
		Transferable objTransferable = objClipboard.getContents(null);
		if (objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Robot objRobot = new Robot();
			objRobot.keyPress(KeyEvent.VK_ENTER);
			objRobot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			//objRobot.wait(250);
			objRobot.keyPress(KeyEvent.VK_CONTROL);
			objRobot.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			//objRobot.wait(250);
			objRobot.keyRelease(KeyEvent.VK_CONTROL);
			objRobot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);
			//objRobot.wait(2500);
			objRobot.keyPress(KeyEvent.VK_ENTER);
			objRobot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
