package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utility.LibraryFunctions2;

public class datadrivenpage2 extends LibraryFunctions2 {
	public static By GenderMale= By.xpath("//input[@value='M']");
	public static By GenderFemale= By.xpath("//input[@value='F']");
	public static By FirstName= By.id("FirstName");
	public static By LastName= By.id("LastName");
	public static By Emailadress= By.id("Email");
	public static By password= By.id("Password");
	public static By confirmpassword= By.id("ConfirmPassword");
}
