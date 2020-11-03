package org.freelance.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(BasePage.class);
	public static File configFile;
	public static FileInputStream configFis;
	public static Properties configProp;

	public static File logProp;
	public static FileInputStream logFis;

	public static void readConfigPropFile() {
		configFile = new File("../SeleniumPOM/src/test/java/org/freelance/resources/Config.properties");

		try {
			configFis = new FileInputStream(configFile);

			configProp = new Properties();
			configProp.load(configFis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	

	public static void readLog4jProperties() {
		logProp = new File("../SeleniumPOM/src/test/java/org/freelance/resources/Log4j.properties");
		try {
			FileInputStream logFis = new FileInputStream(logProp);
			PropertyConfigurator.configure(logFis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static void launchBrowser() {
		readConfigPropFile();
		readLog4jProperties();
		String browser = configProp.getProperty("Browser");
		if (browser.equalsIgnoreCase("Firefox")) {
             logger.info("Browser is : : " + browser);
             System.setProperty("webdriver.gecko.driver", "../SeleniumPOM/Browsers/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("Firefox Browser Invoked");
			driver.manage().window().maximize();
			logger.info("Browser Maximized");
		}else if(browser.equalsIgnoreCase("Chrome")){
			 logger.info("Browser is : : " + browser);
             System.setProperty("webdriver.chrome.driver", "../SeleniumPOM/Browsers/chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome Browser Invoked");
			driver.manage().window().maximize();
			logger.info("Browser Maximized");
		}else if(browser.equalsIgnoreCase("ie")){
			logger.info("Browser is : : " + browser);
            System.setProperty("webdriver.ie.driver", "../SeleniumPOM/Browsers/chromedriver.exe");
			driver = new InternetExplorerDriver();
			logger.info("Internet Explorer Browser Invoked");
			driver.manage().window().maximize();
			logger.info("Browser Maximized");
		}else{
			logger.warn("Unable to Invoke Browser");
		}
	}

	public static void loadUrl() {
		String url = configProp.getProperty("baseUrl");
		driver.get(url);
	}

	public static void waitForElement(By by){
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public static void typeText(By by, String data) {
		waitForElement(by);
		WebElement ele = driver.findElement(by);
		
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			
			logger.info("Data Entered in Input Field " + by);
		} else {
			logger.error("Unable to enter Data in : : " + by);
		}
	}

	public static void performMoueOver(By by) {
		waitForElement(by);
		WebElement ele = driver.findElement(by);
		if (ele.isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			
			
			logger.info("Mouse Over done on Element" + by);

		} else {
			logger.error("Unable to perform Mouse over : : " + by);
		}
	}

	public static void click(By by) {
		waitForElement(by);
		WebElement ele = driver.findElement(by);
		if (ele.isDisplayed()) {
			ele.click();
		
			logger.info("Clicked on Element" + by);

		} else {
			logger.error("Unable to Click : : " + by);
		}
	}

	public static void selectDropdownByVisTxt(By by, String option) {
		waitForElement(by);
		WebElement ele = driver.findElement(by);
		if (ele.isDisplayed()) {
			Select select = new Select(ele);
			select.selectByVisibleText(option);
		
			logger.info("Selected option from drodown" + by);

		} else {
			logger.error("Unable to select option from dropdown : : " + by);
		}
	}

}
