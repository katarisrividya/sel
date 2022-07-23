package com.page;

import org.openqa.selenium.By;

import com.utility.LibraryFunctions2;

public class buttondragdroppage extends LibraryFunctions2 {
	public static By normalclicktext=By.xpath("//p[@id='dynamicClickMessage']");
	public static By doubleclicktext=By.xpath("//p[@id='doubleClickMessage']");
	public static By rightclicktext=By.xpath("//p[@id='rightClickMessage']");
	public static By normalclickbutton=By.xpath("//button[text()='Click Me']");
	public static By rightclickbutton=By.xpath("//button[text()='Right Click Me']");
	public static By doubleclickbutton=By.xpath("//button[text()='Double Click Me']");
	//drag and drop
	public static By drag1=By.xpath("//div[@id='column-a']");
	public static By drop1=By.xpath("//div[@id='column-b']");
	public static By drag2=By.xpath("//button[text()='Drag FROM']");
	public static By drop2=By.xpath("//button[text()='Drop TO']");
	public static void normalclickaction() {
		driver.findElement(normalclickbutton).click();
	}
	public static String getText(By textofelement) {
		return driver.findElement(textofelement).getText();
	}
}
