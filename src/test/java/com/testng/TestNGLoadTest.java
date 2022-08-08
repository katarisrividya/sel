package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGLoadTest {
	@Test(invocationCount = 5, threadPoolSize = 3)
	  public void testThreadPools() {

		System.out.printf("%n[START] Thread Id : %s is started!", Thread.currentThread().getId());

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");

		System.out.printf("%n[END] Thread Id : %s", Thread.currentThread().getId());

		driver.quit();

			
	  }
}
