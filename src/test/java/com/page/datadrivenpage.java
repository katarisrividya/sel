package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utility.LibraryFunctions2;

public class datadrivenpage extends LibraryFunctions2 {
	public static By  FirstName= By.xpath("//input[@placeholder='First Name']");
	public static By  LastName= By.xpath("//input[@placeholder='Last Name']");
	public static By Adress= By.xpath("//textarea[@ng-model='Adress']");
	public static By Emailadress= By.xpath("//input[@ng-model='EmailAdress']");
	public static By PhoneNum= By.xpath("//input[@ng-model='Phone']");
	public static By GenderMale= By.xpath("//input[@value='Male']");
	public static By GenderFeMale= By.xpath("//input[@value='FeMale']");
	public static By cricketChecbox= By.id("checkbox1");
	public static By MoviesChecbox= By.id("checkbox2");
	public static By hockeyChecbox= By.id("checkbox3");
	public static By CloseIconofLanguage=By.xpath("//span[@class='ui-icon ui-icon-close']");
	public static By Language= By.id("msdd");
	public static By All_languages=By.xpath("//div[@id='msdd']/following-sibling::div/ul/li");
	public static By skills_tag=By.xpath("//label[text()='Skills']");
	public static By Skills=By.xpath("//select[@id='Skills']");
	public static By All_skills=By.xpath("//select[@id='Skills']/option");
	public static By select_country=By.xpath("//span[@role='combobox']");
	public static By All_select_country=By.xpath("//select[@id='country']/option");
	public static By year=By.xpath("//select[@id='yearbox']");
	public static By All_years=By.xpath("//select[@id='yearbox']/option");
	public static By month=By.xpath("//select[@placeholder='Month']");
	public static By All_months=By.xpath("//select[@placeholder='Month']/option");
	public static By Day=By.xpath("//select[@placeholder='Day']");
	public static By All_Days=By.xpath("//select[@placeholder='Day']/option");
	public static By password= By.id("firstpassword");
	public static By confirmpassword= By.id("secondpassword");
}
