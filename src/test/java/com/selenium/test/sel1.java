package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sel1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium and java");
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='text']")).submit();
		//driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		driver.close();
	}

}
