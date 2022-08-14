package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryFunctions2 {

	public static Properties ObjProperties;
	public static WebDriver driver;
	public static Actions objActions;
	public static WebDriverWait Wait;
	public static HashMap<String, String> hmap = new HashMap<String, String>();

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
			// driver = new ChromeDriver();
			ChromeOptions objChromeOptions = new ChromeOptions();
			objChromeOptions.setAcceptInsecureCerts(true);
			// driver= new ChromeDriver(objChromeOptions);
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			objChromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(objChromeOptions);
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
	} // implicit wait

	public static void ExplicitWaitUntilElementToBeClickable(WebElement element) {
		Wait = new WebDriverWait(driver, Constant.ExplicitWait60Sec);
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	} // explicit wait

	public static void clickOnWebElement(By element) { // single normal click
		objActions = new Actions(driver); // If this doesnot work then try javascript executor
		WebElement clickelement = driver.findElement(element);
		ExplicitWaitUntilElementToBeClickable(clickelement);
		objActions.click(clickelement).build().perform();
		// objActions.moveToElement(clickelement).click();
	}
	/*
	 * public static void ClickOnWebElement(By newBroswerWindowButton) { objActions
	 * = new Actions(driver); WebElement element =
	 * driver.findElement(newBroswerWindowButton);
	 * ExplicitWaitUntilElementToBeClickable(element);
	 * objActions.click(element).build().perform(); }
	 */

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

	/*
	 * public static void DragandDrop(By drag, By drop) { //Type-1 WebElement
	 * drag_ele = driver.findElement(drag); WebElement drop_ele =
	 * driver.findElement(drop); objActions = new Actions(driver);
	 * objActions.dragAndDrop(drag_ele, drop_ele).build().perform(); }
	 */

	public static void DragAndDrop(By draggable, By droppable) { // Type-2
		WebElement DragElement_Source = driver.findElement(draggable);
		WebElement DropElement_Destination = driver.findElement(droppable);
		objActions = new Actions(driver);
		WebDriverWait Wait = new WebDriverWait(driver, 60);
		Wait.until(ExpectedConditions.elementToBeClickable(DragElement_Source));
		objActions.clickAndHold(DragElement_Source);
		objActions.moveToElement(DropElement_Destination);
		objActions.build().perform();
	}

	// Used to take screenshot
	public static void TakeScreenShot() {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + "captured.jpeg";
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * This method is used to take screen shot and store the screen shots in side
	 * ScreenShot folder
	 */
	public static String TakeScreenShot(String testcaseName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + testcaseName
				+ "captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		return destination;

	}

	/*
	 * This method is used to take screen shot and store the screen shots in side
	 * ScreenShot folder
	 */
	public static void TakeScreenShotofSpecifiedWebElement(WebElement element) {
		try {
			File src = element.getScreenshotAs(OutputType.FILE);
			String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + "captured.jpeg";
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HashMap<String, String> ReadExcelFile(XSSFSheet objWorkSheet, int row) {
		// TODO Auto-generated method stub
		DataFormatter ObjFormatter = new DataFormatter();
		hmap.put("RunMode", objWorkSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName", objWorkSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("FirstName", objWorkSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("LastName", objWorkSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Address", objWorkSheet.getRow(row).getCell(4).getStringCellValue());
		hmap.put("Email", objWorkSheet.getRow(row).getCell(5).getStringCellValue());
		// As phoneNumber is not in form of string we format
		hmap.put("PhoneNumber", ObjFormatter.formatCellValue(objWorkSheet.getRow(row).getCell(6)));
		hmap.put("Gender", objWorkSheet.getRow(row).getCell(7).getStringCellValue());
		hmap.put("Hobbies", objWorkSheet.getRow(row).getCell(8).getStringCellValue());
		hmap.put("Languages", objWorkSheet.getRow(row).getCell(9).getStringCellValue());
		hmap.put("Skills", objWorkSheet.getRow(row).getCell(10).getStringCellValue());
		hmap.put("Country", objWorkSheet.getRow(row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry", objWorkSheet.getRow(row).getCell(12).getStringCellValue());

		hmap.put("DOB_YY", ObjFormatter.formatCellValue(objWorkSheet.getRow(row).getCell(13)));
		hmap.put("DOB_MM", ObjFormatter.formatCellValue(objWorkSheet.getRow(row).getCell(14)));
		hmap.put("DOB_DD", ObjFormatter.formatCellValue(objWorkSheet.getRow(row).getCell(15)));

		hmap.put("Password", objWorkSheet.getRow(row).getCell(16).getStringCellValue());
		hmap.put("confirmPassword", objWorkSheet.getRow(row).getCell(17).getStringCellValue());

		return hmap;
	}

	public static void SelectValueFromDropDown(List<WebElement> All_options, String Dropdownvaluetoselect) {
		// TODO Auto-generated method stub
		// We can follow this method when options in ul/li or select/options form
		// **************
		for (int i = 0; i < All_options.size(); i++) {
			String element = All_options.get(i).getText();
			// System.out.println("IndividualValue at index: "+i+"is "+element);
			if (element.equalsIgnoreCase(Dropdownvaluetoselect)) {
				All_options.get(i).click();
				break;
			}
		}

	}

	public static void WriteToExcelFile(XSSFWorkbook objWorkBook, XSSFSheet objWorkSheet, int row) {
		// TODO Auto-generated method stub
		objWorkSheet = objWorkBook.getSheet(ObjProperties.getProperty("DataDrivenSheetName"));
		System.out.println("Writing on excel for row" + row);
		XSSFCellStyle CellStyle = objWorkBook.createCellStyle();
		objWorkSheet.getRow(row).createCell(18).setCellValue("PASS");
		objWorkSheet.getRow(row).getCell(18).setCellStyle(CellStyle);
	}
	
	public static HashMap<String, String> ReadExcelFile2OWN(XSSFSheet objWorkSheet, int row) {
		// TODO Auto-generated method stub
		DataFormatter ObjFormatter = new DataFormatter();
		hmap.put("RunMode", objWorkSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("Gender", objWorkSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("Firstname", objWorkSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("Lastname", objWorkSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Email", objWorkSheet.getRow(row).getCell(4).getStringCellValue());
		hmap.put("Password", objWorkSheet.getRow(row).getCell(5).getStringCellValue());
		hmap.put("confirmPassword", objWorkSheet.getRow(row).getCell(6).getStringCellValue());
		return hmap;
	}
	
	public static void WriteToExcelFile2(XSSFWorkbook objWorkBook, XSSFSheet objWorkSheet, int row) {
		// TODO Auto-generated method stub
		objWorkSheet = objWorkBook.getSheet("Data");
		System.out.println("Writing on excel for row" + row);
		XSSFCellStyle CellStyle = objWorkBook.createCellStyle();
		objWorkSheet.getRow(row).createCell(7).setCellValue("PASS");
		objWorkSheet.getRow(row).getCell(7).setCellStyle(CellStyle);
	}

	public static void CheckLink(String individual_Link) {
		// TODO Auto-generated method stub
		try {
			URL objurl = new URL(individual_Link);
			HttpURLConnection objconnection = (HttpURLConnection) objurl.openConnection();
			objconnection.connect();
			int ResponseStatusCode = objconnection.getResponseCode();
			if (ResponseStatusCode >= 200 && ResponseStatusCode <= 226) {
				System.out.println("URL:" + individual_Link + " : " + "ResponseStatusCode: " + ResponseStatusCode
						+ " is a valid link with status between 200 & 208");
			} else if (ResponseStatusCode >= 300 && ResponseStatusCode <= 308) {
				System.out.println("URL:" + individual_Link + " : " + "ResponseStatusCode: " + ResponseStatusCode
						+ " is a Redirection link with status between 300 & 308");
			} else if (ResponseStatusCode >= 400 && ResponseStatusCode <= 499) {
				System.out.println("URL:" + individual_Link + " : " + "ResponseStatusCode: " + ResponseStatusCode
						+ " is a ClientError link with status between 400 & 499");
			} else if (ResponseStatusCode >= 500 && ResponseStatusCode <= 599) {
				System.out.println("URL:" + individual_Link + " : " + "ResponseStatusCode: " + ResponseStatusCode
						+ " is a ServerError link with status between 500 & 599");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//Method 1 for SeleniumGrid Browser
	public static WebDriver initializeBrowser(String browserName) {
		DesiredCapabilities dc = new DesiredCapabilities();
		if(browserName.equals("chrome")) {
			dc.setBrowserName("chrome");
		}else if(browserName.equals("firefox")) {
			dc.setBrowserName("firefox");
		}else if(browserName.equals("safari")) {
			dc.setBrowserName("safari");
		}else if(browserName.equals("Edge")) {
			dc.setBrowserName("Edge");
		}else if(browserName.equals("ie")) {
			dc.setBrowserName("ie");
		}
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	//Method 2 for SeleniumGrid Browser (Prefered to use the second method )
	public static WebDriver getBrowserCapabilities(String driverParameter) {
		  DesiredCapabilities capabilities = null;
		  if (driverParameter == null || driverParameter.equalsIgnoreCase("FIREFOX")) {
		    capabilities = DesiredCapabilities.firefox();
		    FirefoxOptions options = new FirefoxOptions();
		    capabilities.merge(options);
		  }
		  else if (driverParameter.equalsIgnoreCase("IE")) {
		    capabilities = DesiredCapabilities.internetExplorer();
		    InternetExplorerOptions options = new InternetExplorerOptions();
		    capabilities.merge(options);
		  }
		  else if (driverParameter.equalsIgnoreCase("CHROME")) {
		    capabilities = DesiredCapabilities.chrome();
		    ChromeOptions options = new ChromeOptions();
		 //   options.setHeadless(headless);
		    capabilities.merge(options);
		  }
		  else if (driverParameter.equalsIgnoreCase("EDGE")) {
			    capabilities = DesiredCapabilities.edge();
			    EdgeOptions options = new EdgeOptions();
			    capabilities.merge(options);
			  }
		  
		  try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);	
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return driver;
		 
		}

}
