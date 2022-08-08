package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.page.datadrivenpage;
import com.page.datadrivenpage2;
import com.page.dropdownpage;
import com.page.webtablepage;
import com.utility.Constant;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

public class testng11validatedatadriven2 extends datadrivenpage2 {
	
	HashMap<String,String> hmap=new HashMap<String,String>();
	
	@Test(priority = -1)
	public void LoadingDataDrivenPage() {
		System.out.println("inside Web Page");
		driver.navigate().to(ObjProperties.getProperty("AutomationRegister2")); // to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String TitleOfRegisterPage = LibraryFunctions2.driver.getTitle();
		System.out.println("TitleOfRegisterPage:"+TitleOfRegisterPage);
		//Assert.assertEquals(TitleOfRegisterPage, ObjProperties.getProperty("TitleOfRegisterPage"),
			//	"TitleOfRegisterPage is not Validated");
	}

	@Test(priority = 1)
	public void ValidateDataDriven() throws IOException {
		try {
			File ObjFile=new File(System.getProperty("user.dir")+"//src//test//resources//materials//RegisterAutomation.xlsx");
			FileInputStream ObjFileInputStream=new FileInputStream(ObjFile);
			XSSFWorkbook objWorkBook=new XSSFWorkbook(ObjFileInputStream);
			XSSFSheet objWorkSheet=objWorkBook.getSheet("Data");
			int NoofRows=objWorkSheet.getLastRowNum();
			for(int row=1;row<=NoofRows;row++) {
				hmap=LibraryFunctions2.ReadExcelFile2OWN(objWorkSheet, row);
				
				if(hmap.get("RunMode").equalsIgnoreCase("yes")) {
					
					if(hmap.get("Gender").equals("Male")) {
						LibraryFunctions2.driver.findElement(GenderMale).click();
					}
					else {
						LibraryFunctions2.driver.findElement(GenderFemale).click();
					}
					
				LibraryFunctions2.driver.findElement(FirstName).clear();
				LibraryFunctions2.driver.findElement(FirstName).sendKeys(hmap.get("Firstname"));
				
				LibraryFunctions2.driver.findElement(LastName).clear();
				LibraryFunctions2.driver.findElement(LastName).sendKeys(hmap.get("Lastname"));
				
				
				LibraryFunctions2.driver.findElement(Emailadress).clear();
				LibraryFunctions2.driver.findElement(Emailadress).sendKeys(hmap.get("Email"));
				

				LibraryFunctions2.driver.findElement(password).clear();
				LibraryFunctions2.driver.findElement(password).sendKeys(hmap.get("Password"));
				
				LibraryFunctions2.driver.findElement(confirmpassword).clear();
				LibraryFunctions2.driver.findElement(confirmpassword).sendKeys(hmap.get("confirmPassword"));
				
				FileOutputStream objFileOutput = new FileOutputStream(ObjFile);
				LibraryFunctions2.WriteToExcelFile2(objWorkBook,objWorkSheet,row);
				
				objWorkBook.write(objFileOutput);
				
				}
				else {
					int c=row+1;
					System.out.println("RunMode is not yes on row"+c);
				}
				
			}
			objWorkBook.close();
			ObjFileInputStream.close();
		} catch (FileNotFoundException e) {
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
