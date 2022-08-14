package com.headLess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.LibraryFunctions2;

public class HTMLUnitDriver extends LibraryFunctions2 {
	WebDriver unitDriver;

	@Test
	public void testHTMLUnitunitDriver1() throws IOException {
		ReadPropertiesFile();
		unitDriver = new HtmlUnitDriver(true);
		unitDriver.get(ObjProperties.getProperty("amazonurl"));
		String AmazonTitle = unitDriver.getTitle();
		System.out.println("title " + AmazonTitle);
		Assert.assertEquals(AmazonTitle,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	public void testHTMLUnitunitDriver2() {
		System.out.println("This is test to validate search");
		  unitDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		  unitDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptops");
		  unitDriver.findElement(By.xpath("//input[@type='submit']")).click();
		  String title=unitDriver.getTitle();
		  Assert.assertEquals(title,"Amazon.in : Laptops");
	}
}
