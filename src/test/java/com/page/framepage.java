package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.utility.LibraryFunctions2;

public class framepage extends LibraryFunctions2{
	public static Select animals;
	public static By frame1=By.id("frame1");
	public static By frame2=By.id("frame2");
	public static By frame3=By.id("frame3");
	public static By Textboxinframe1=By.xpath("//input");
	public static By checkboxinframe3=By.xpath("//input[@id='a']");
	public static By selectinframe2=By.xpath("//select[@id='animals']");
	public static void entertextinframe1() {
		driver.findElement(Textboxinframe1).sendKeys(ObjProperties.getProperty("Frame1text"));
	}
	public static void checkinframe3() {
		driver.findElement(checkboxinframe3).click();
	}
	public static void clickonframe2() {
		driver.findElement(selectinframe2).click();
	}
	public static void selectavatar() {
		animals=new Select(driver.findElement(selectinframe2));
		animals.selectByIndex(3);
	}
}
