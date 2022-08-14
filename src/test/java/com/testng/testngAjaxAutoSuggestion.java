package com.testng;

import org.testng.annotations.Test;

import com.page.AjaxAutoSuggestionPage;
import com.utility.LibraryFunctions;
import com.utility.LibraryFunctions2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testngAjaxAutoSuggestion extends AjaxAutoSuggestionPage {
  @Test(priority=-1)
  public void validateamazonpageloading() {
	  driver.navigate().to("http://busindia.com/");
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  String title=driver.getTitle();
	  System.out.println("title "+title);
  }
  @Test(priority=0)
  public void validatesearch() throws InterruptedException {
	  System.out.println("This is test to validate search");
	  driver.findElement(From).sendKeys("Udupi");
	  Actions action = new Actions(driver);
	  action.sendKeys(Keys.DOWN);
	  action.sendKeys(Keys.ENTER);
	  action.perform();
	  Thread.sleep(2000);

	    List<WebElement> OptionList = driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li/a"));
	    if(OptionList.size()>=1){
	        for(int i=0;i<OptionList.size();i++)
	        {
	            String CurrentOption = OptionList.get(i).getText();
	            if(CurrentOption.equalsIgnoreCase("UDUPI")){
	                System.out.println("Found the city : "+CurrentOption);
	                OptionList.get(i).click();
	            }
	        }
	    }
	    else{
	        System.out.println("OptionList is empty");
	    }
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
	  LibraryFunctions2.LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is before suite");
	  try {
		LibraryFunctions2.ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite");
  }

}
