package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utility.LibraryFunctions2;

public class windowspage extends LibraryFunctions2 {
	public static By NewBrowserWindowbtn=By.xpath("//button[text()='New Browser Window']");
	public static By NewMessageWindowbtn=By.xpath("//button[text()='New Message Window']");
	public static By NewBrowserTabbtn=By.xpath("//button[text()='New Browser Tab']");
	public static void clickToOpenNewWindow() {
		WebElement element = driver.findElement(NewBrowserWindowbtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		// or executor.executeScript("document.getElementById('button1').click();");
	}
}
