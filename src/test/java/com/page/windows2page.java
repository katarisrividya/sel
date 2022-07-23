package com.page;

import org.openqa.selenium.By;

import com.utility.LibraryFunctions2;

public class windows2page extends LibraryFunctions2 {
	public static By tab=By.xpath("//button[text()='New Tab']");
	public static By window=By.xpath("//button[text()='New Window']");
	public static By windowMessage=By.xpath("//button[text()='New Window Message']");
}
