package com.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utility.LibraryFunctions2;

public class alertspage extends LibraryFunctions2 {
	public static Alert alertbtnormal;
	public static Alert alertbtconfirm;
	public static Alert alertbtprompt;
	public static Alert alertdouble;
	public static Actions actions;
	public static By normalalert=By.name("alert");
	public static By confirmationalert=By.name("confirmation");
	public static By promptalert=By.name("prompt");
	public static By fileupload=By.xpath("//input[@name='upload']");
	public static By submenu=By.id("sub-menu");
	public static By submenugoogle=By.xpath("//a[text()='Google']");
	public static By doubleclick=By.id("double-click");
	public static void clicknormalalert() {
		driver.findElement(normalalert).click();
	}
	public static void acceptnormalalert() {
		alertbtnormal.accept();
	}
	public static void clickconfirmationalert() {
		driver.findElement(confirmationalert).click();
	}
	public static void acceptconfirmationalert() {
		alertbtconfirm.accept();
	}
	public static void dismissconfirmationalert() {
		alertbtconfirm.dismiss();
	}
	public static void clickpromptalert() {
		driver.findElement(promptalert).click();
	}
	public static void entertextonpromptalert(String prompttext) {
		alertbtprompt.sendKeys(prompttext);
	}
	public static void acceptpromptalert() {
		alertbtprompt.accept();
	}
	public static void dismisspromptalert() {
		alertbtprompt.dismiss();
	}
	public static void fileupload() {
		driver.findElement(fileupload).sendKeys(ObjProperties.getProperty("FileUploadPath"));
	}
	public static void submenuclick() {
		driver.findElement(submenu).click();
	}
	public static void clickgooglesubmenu() {
		driver.findElement(submenugoogle).click();
	}
	public static void doubleclickalert() {
		actions = new Actions(driver);
		WebElement ele = driver.findElement(doubleclick);
		actions.doubleClick(ele).perform();
	}
	public static void doubleclickaccept() {
		alertdouble.accept();
	}
	
}
