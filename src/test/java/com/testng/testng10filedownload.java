package com.testng;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
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
import com.page.filedownloadpage;
import com.page.fileuploadpage;
import com.utility.Constant;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

public class testng10filedownload extends filedownloadpage {
	@Test(priority = -1)
	public void LoadingFileDownloadPage() {
		System.out.println("inside File Download");
		driver.navigate().to(ObjProperties.getProperty("filedownload")); //to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titleOfFileDownload = driver.getTitle();
		System.out.println("titleOfFileUpload: " + titleOfFileDownload);
		//Assert.assertEquals(titleOfFileUpload, ObjProperties.getProperty("FileUploadTitle"));
	}
	@Test(priority = 0)
	public void validatefileUpload() throws InterruptedException {
		
		driver.findElement(filedownload).click();
		Thread.sleep(5000);
		File objFile = new File(System.getProperty("user.dir"));
		File[] Allfiles = objFile.listFiles();
		
		for(File IndidvidualFile : Allfiles) {
			String FileName = IndidvidualFile.getName();
			System.out.println("FileName:"+FileName);
			Boolean fileFound = false;
			if(FileName.contains("samplefile")) {
				fileFound=true;
				File IdentifiedDownloadedFile = new File(FileName)	;	
				Assert.assertTrue(fileFound, "File Download  is not validated");
				IdentifiedDownloadedFile.deleteOnExit();
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
