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
import com.page.dropdownpage;
import com.page.webtablepage;
import com.utility.Constant;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

public class testng11validatedatadriven extends datadrivenpage {
	HashMap<String,String> hmap=new HashMap<String,String>();
	@Test(priority = -1)
	public void LoadingDataDrivenPage() {
		System.out.println("inside Web Page");
		driver.navigate().to(ObjProperties.getProperty("AutomationRegister")); // to direct to the website navigate is used
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String TitleOfRegisterPage = LibraryFunctions2.driver.getTitle();
		System.out.println("TitleOfRegisterPage:"+TitleOfRegisterPage);
		Assert.assertEquals(TitleOfRegisterPage, ObjProperties.getProperty("TitleOfRegisterPage"),
				"TitleOfRegisterPage is not Validated");
	}

	@Test(priority = 1)
	public void ValidateDataDriven() throws IOException {
		try {
			File ObjFile=new File(System.getProperty("user.dir")+"//src//test//resources//materials//AutomationDemoSIte.xlsx");
			FileInputStream ObjFileInputStream=new FileInputStream(ObjFile);
			XSSFWorkbook objWorkBook=new XSSFWorkbook(ObjFileInputStream);
			XSSFSheet objWorkSheet=objWorkBook.getSheet("TestData");
			int NoofRows=objWorkSheet.getLastRowNum();
			for(int row=1;row<=NoofRows;row++) {
				hmap=LibraryFunctions2.ReadExcelFile(objWorkSheet, row);
				
				if(hmap.get("RunMode").equalsIgnoreCase("yes")) {
				LibraryFunctions2.driver.findElement(FirstName).clear();
				LibraryFunctions2.driver.findElement(FirstName).sendKeys(hmap.get("FirstName"));
				
				LibraryFunctions2.driver.findElement(LastName).clear();
				LibraryFunctions2.driver.findElement(LastName).sendKeys(hmap.get("LastName"));
				
				LibraryFunctions2.driver.findElement(Adress).clear();
				LibraryFunctions2.driver.findElement(Adress).sendKeys(hmap.get("Address"));
				
				LibraryFunctions2.driver.findElement(Emailadress).clear();
				LibraryFunctions2.driver.findElement(Emailadress).sendKeys(hmap.get("Email"));
				
				LibraryFunctions2.driver.findElement(PhoneNum).clear();
				LibraryFunctions2.driver.findElement(PhoneNum).sendKeys(hmap.get("PhoneNumber"));
				
				if(hmap.get("Gender").equals("Male")) {
					LibraryFunctions2.driver.findElement(GenderMale).click();
				}
				else {
					LibraryFunctions2.driver.findElement(GenderFeMale).click();
				}
				
				
				if(hmap.get("Hobbies").equals("Cricket")) {
					LibraryFunctions2.driver.findElement(cricketChecbox).click();
				}
				else if(hmap.get("Hobbies").equals("Movies")){
					LibraryFunctions2.driver.findElement(MoviesChecbox).click();
				}
				else if(hmap.get("Hobbies").equals("Hockey")){
					LibraryFunctions2.driver.findElement(hockeyChecbox).click();
				}
				
				if(row>1) {
					LibraryFunctions2.driver.findElement(CloseIconofLanguage).click();
				}
				
				//SelectValueFromDropDown THIS FUNCTION WORKS FOR BOTH DROPDOWN LIKE IN FORM OF UL/LI or SELECT OPTION******
				LibraryFunctions2.driver.findElement(Language).click();
				List<WebElement> All_Languages=LibraryFunctions2.driver.findElements(All_languages);
				LibraryFunctions2.SelectValueFromDropDown(All_Languages, hmap.get("Languages"));
				
				LibraryFunctions2.driver.findElement(skills_tag).click();
				
				LibraryFunctions2.driver.findElement(Skills).click();
				List<WebElement> All_Skills=LibraryFunctions2.driver.findElements(All_skills);
				LibraryFunctions2.SelectValueFromDropDown(All_Skills, hmap.get("Skills"));
				
				LibraryFunctions2.driver.findElement(skills_tag).click();
				
				LibraryFunctions2.driver.findElement(select_country).click();
				List<WebElement> All_SelectCountry=LibraryFunctions2.driver.findElements(All_select_country);
				LibraryFunctions2.SelectValueFromDropDown(All_SelectCountry, hmap.get("SelectCountry"));
				
				
                LibraryFunctions2.driver.findElement(skills_tag).click();
				
				LibraryFunctions2.driver.findElement(year).click();
				List<WebElement> All_Year=LibraryFunctions2.driver.findElements(All_years);
				LibraryFunctions2.SelectValueFromDropDown(All_Year, hmap.get("DOB_YY"));
				
              LibraryFunctions2.driver.findElement(skills_tag).click();
				
				LibraryFunctions2.driver.findElement(month).click();
				List<WebElement> All_Month=LibraryFunctions2.driver.findElements(All_months);
				LibraryFunctions2.SelectValueFromDropDown(All_Month, hmap.get("DOB_MM"));
				
               LibraryFunctions2.driver.findElement(skills_tag).click();
				
				LibraryFunctions2.driver.findElement(Day).click();
				List<WebElement> All_Day=LibraryFunctions2.driver.findElements(All_Days);
				LibraryFunctions2.SelectValueFromDropDown(All_Day, hmap.get("DOB_DD"));
				
				LibraryFunctions2.driver.findElement(password).clear();
				LibraryFunctions2.driver.findElement(password).sendKeys(hmap.get("Password"));
				
				LibraryFunctions2.driver.findElement(confirmpassword).clear();
				LibraryFunctions2.driver.findElement(confirmpassword).sendKeys(hmap.get("confirmPassword"));
				
				/*FileOutputStream ObjFileOutput=new FileOutputStream(ObjFile);
				LibraryFunctions2.WriteToExcelFile(objWorkBook,objWorkSheet,row);
				objWorkBook.write(ObjFileOutput);*/
				FileOutputStream objFileOutput = new FileOutputStream(ObjFile);
				LibraryFunctions2.WriteToExcelFile(objWorkBook,objWorkSheet,row);
				
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
