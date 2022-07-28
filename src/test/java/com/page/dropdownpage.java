package com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.LibraryFunctions2;

public class dropdownpage extends LibraryFunctions2{
	public static List<WebElement> options; //used to display options
	public static By dropdownProducts=By.xpath("//select[@id='first']");
	public static By dropdownAnimals=By.xpath("//select[@id='animals']");
	public static By customdropdown=By.xpath("//button[@id='custom']");
	public static By foodselection=By.xpath("//select[@id='second']");
}
