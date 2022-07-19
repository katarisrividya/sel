package com.testng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

import com.utility.Constant;
import com.utility.LibraryFunctions2;

public class testng2 extends LibraryFunctions2 {
	@Test(priority=-1)
	public void validateGmoOnlineLoading() {
		System.out.println("This is validateGMOonlineloading test");
		String validateGmoOnlineLoadingTitle = driver.getTitle();
		System.out.println("Title of validateGMOonlineloading " + validateGmoOnlineLoadingTitle);
		Assert.assertEquals(validateGmoOnlineLoadingTitle, ObjProperties.getProperty("GmoOnlineLoadingTitle")); // verify
																												// title
																												// from
																												// config
	}

	@Test(priority = 0, dependsOnMethods = { "validateGmoOnlineLoading" })
	public void validateOnlineCatalog() {
		System.out.println("This is to validateOnlineCatalog test ");
		driver.findElement(By.name("bSubmit")).click();
		String validateOnlineCatalogTitle = driver.getTitle();
		System.out.println("Title of validateOnlineCatalogue " + validateOnlineCatalogTitle);
		Assert.assertEquals(validateOnlineCatalogTitle, ObjProperties.getProperty("GmoCatalogTitle"));
	}
	 @Test(priority=1)
	  public void CatalogEnterValuesandPlaceOrder() {
		  System.out.println("This is to test CatalogEnterValuesandPlaceOrder");
		  driver.findElement(By.xpath("//input[@name='QTY_SOCKS']")).clear();
		  driver.findElement(By.xpath("//input[@name='QTY_SOCKS']")).sendKeys(String.valueOf(Constant.paddedsocks));
		  driver.findElement(By.xpath("//input[@name='QTY_BOOTS']")).clear();
		  driver.findElement(By.xpath("//input[@name='QTY_BOOTS']")).sendKeys(String.valueOf(Constant.hikingboots));
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  driver.findElement(By.name("bSubmit")).click();
	  }
	 @Test(priority=2,dependsOnMethods = {"CatalogEnterValuesandPlaceOrder"})
	  public void ValidatePlaceOrder() {
		  System.out.println("This is to test Place Order Calculations");
		  //socks case
		  String UnitSocksPriceString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[2]//td[4]")).getText();
		  float UnitSocksPriceFloat=Float.parseFloat(UnitSocksPriceString.substring(2).trim()); //To remove dollar and space next to it
		  String TotalSocksPriceString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[2]//td[5]")).getText();
		  float ActualTotalSocksPriceFloat=Float.parseFloat(TotalSocksPriceString.substring(2).trim());
		  float ExpectedTotalSocksPrice=Constant.paddedsocks* UnitSocksPriceFloat;
		  Assert.assertEquals(ActualTotalSocksPriceFloat, ExpectedTotalSocksPrice); //socks price is as per expected
		  //Boots Case
		  String UnitBootsPriceString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[3]//td[4]")).getText();
		  float UnitBootsPriceFloat=Float.parseFloat(UnitBootsPriceString.substring(2).trim()); //To remove dollar and space next to it
		  String TotalBootsPriceString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[3]//td[5]")).getText();
		  float ActualTotalBootsPriceFloat=Float.parseFloat(TotalBootsPriceString.substring(2).trim());
		  float ExpectedTotalBootsPrice=Constant.hikingboots* UnitBootsPriceFloat;
		  Assert.assertEquals(ActualTotalBootsPriceFloat, ExpectedTotalBootsPrice);
		  //To calculate Product Total
		  float ExpectedProductTotal=ExpectedTotalBootsPrice+ExpectedTotalSocksPrice;
		  String ProductTotalString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[4]//td[3]")).getText();
		  float ActualProductTotal=Float.parseFloat(ProductTotalString.substring(2).trim());
		  Assert.assertEquals(ActualProductTotal, ExpectedProductTotal);
		  System.out.println("Product Total"+ActualProductTotal+" "+ExpectedProductTotal);
		  //salesTax
		  String salesTaxString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[5]//td[2]")).getText();
		  float salesTaxfloat=Float.parseFloat(salesTaxString.substring(2).trim());
		  System.out.println("Sales Tax"+salesTaxfloat);
		  //Shipping And Handiling
		  String ShippingandHandilingCostString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[6]//td[2]")).getText();
		  float ShippingandHandilingCostFloat=Float.parseFloat(ShippingandHandilingCostString.substring(2).trim());
		  System.out.println("Shipping and Handiling"+ ShippingandHandilingCostFloat);
		  //Total
		  String GrandTotalString=driver.findElement(By.xpath("//table[@border='1' and @cellspacing='1']//tbody//tr[7]//td[2]")).getText();
		  float ActualGrandTotal=Float.parseFloat(GrandTotalString.substring(2).trim());
		  float ExpectedGrandTotal=ExpectedProductTotal+salesTaxfloat+ShippingandHandilingCostFloat;
		  System.out.println("GrandTotal"+ ActualGrandTotal+" "+ExpectedGrandTotal);
		  Assert.assertEquals(ActualGrandTotal, ExpectedGrandTotal);
		  if(ActualGrandTotal==ExpectedGrandTotal){
			  driver.findElement(By.name("bSubmit")).click();
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
