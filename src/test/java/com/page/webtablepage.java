package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utility.LibraryFunctions2;

public class webtablepage extends LibraryFunctions2 {
	public static By RowsInWebtable = By.xpath("//table[@id='webtable']/tbody/tr");
}
