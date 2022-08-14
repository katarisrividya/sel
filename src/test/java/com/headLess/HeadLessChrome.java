package com.headLess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.LibraryFunctions2;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessChrome extends LibraryFunctions2 {
	WebDriver ChromeHeadLess;

	@Test
	public void testHTMLUnitunitDriver1() throws IOException {
		ReadPropertiesFile();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		WebDriverManager.chromedriver().setup();
		ChromeHeadLess = new ChromeDriver(options);
		ChromeHeadLess.get(ObjProperties.getProperty("amazonurl"));
		String AmazonTitle = ChromeHeadLess.getTitle();
		System.out.println("title " + AmazonTitle);
		Assert.assertEquals(AmazonTitle,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	public void testHTMLUnitunitDriver2() {
		System.out.println("This is test to validate search");
		  ChromeHeadLess.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		  ChromeHeadLess.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptops");
		  ChromeHeadLess.findElement(By.xpath("//input[@type='submit']")).click();
		  String title=ChromeHeadLess.getTitle();
		  Assert.assertEquals(title,"Amazon.in : Laptops");
	}
}
