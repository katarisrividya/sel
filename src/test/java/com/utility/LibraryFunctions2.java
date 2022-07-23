package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryFunctions2 {

	public static Properties ObjProperties;
	public static WebDriver driver;
	public static Actions objActions;
	public static WebDriverWait Wait;

	public static void ReadPropertiesFile() throws IOException {
		try {
			System.out.println(System.getProperty("user.dir"));
			File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//config.properties");
			FileInputStream objFileInput = new FileInputStream(objFile);
			ObjProperties = new Properties();
			ObjProperties.load(objFileInput);
			System.out.println(ObjProperties.getProperty("GmoOnlineUrl"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LaunchBrowser() {
		String browser = ObjProperties.getProperty("browser");
		switch (browser) {
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			;
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "opeara":
			WebDriverManager.operadriver();
			driver = new OperaDriver();
			break;
		default:
			System.out.println("default case");
		}
		driver.get(ObjProperties.getProperty("GmoOnlineUrl"));
		driver.manage().window().maximize();
	}

	public static void WaitingForPageToLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	} //implicit wait
	
	public static void ExplicitWaitUntilElementToBeClickable(WebElement element){
		Wait = new WebDriverWait(driver,Constant.ExplicitWait60Sec); 
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	} //explicit wait
	
	public static void clickOnWebElement(By element) { //single normal click
		objActions = new Actions(driver);              //If this doesnot work then try javascript executor
		WebElement clickelement = driver.findElement(element);
		ExplicitWaitUntilElementToBeClickable(clickelement);
		objActions.click(clickelement).build().perform();
		//objActions.moveToElement(clickelement).click();
	}
	/*public static void ClickOnWebElement(By newBroswerWindowButton) {
		objActions = new Actions(driver);
		WebElement element = driver.findElement(newBroswerWindowButton);
		ExplicitWaitUntilElementToBeClickable(element);
		objActions.click(element).build().perform();
	}*/

	public static void RightClick(By element) {
		WebElement RightClick = driver.findElement(element);
		objActions = new Actions(driver);
		objActions.contextClick(RightClick).build().perform();
	}

	public static void DoubleClick(By element) {
		WebElement DoubleClick = driver.findElement(element);
		objActions = new Actions(driver);
		objActions.doubleClick(DoubleClick).build().perform();
	}

	
	/*public static void DragandDrop(By drag, By drop) { //Type-1
		WebElement drag_ele = driver.findElement(drag);
		WebElement drop_ele = driver.findElement(drop);
		objActions = new Actions(driver);
		objActions.dragAndDrop(drag_ele, drop_ele).build().perform();
	}*/
	
	public static void DragAndDrop(By draggable, By droppable) { //Type-2
		WebElement DragElement_Source = driver.findElement(draggable);
		WebElement DropElement_Destination = driver.findElement(droppable);
		objActions = new Actions(driver);
		WebDriverWait Wait = new WebDriverWait(driver, 60);
		Wait.until(ExpectedConditions.elementToBeClickable(DragElement_Source));
		objActions.clickAndHold(DragElement_Source);
		objActions.moveToElement(DropElement_Destination);
		objActions.build().perform();
	}

}
