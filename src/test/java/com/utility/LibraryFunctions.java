package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryFunctions {
	public static Properties ObjProperties;
	public static WebDriver driver;

	public static enum Browser {
		ie, chrome, edge, firefox, opeara
	}

	public static void ReadPropertiesFile() throws IOException {
		try {
			File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//config.properties");
			FileInputStream objFileInput = new FileInputStream(objFile);
			ObjProperties = new Properties();
			ObjProperties.load(objFileInput);
			System.out.println(ObjProperties.getProperty("amazonurl"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LaunchBrowser() {
		String stringbrowser = ObjProperties.getProperty("browser");
		Browser browser = Browser.valueOf(stringbrowser);
		switch (browser) {
		case ie:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case chrome:
			WebDriverManager.chromedriver().setup();
			;
			driver = new ChromeDriver();
			break;
		case edge:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case firefox:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case opeara:
			WebDriverManager.operadriver();
			driver = new OperaDriver();
			break;
		default:
			System.out.println("default case");
		}
		driver.get(ObjProperties.getProperty("amazonurl"));
		driver.manage().window().maximize();
	}

	public static void WaitingForPageToLoad(int time) {
		LibraryFunctions.driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
}
