package com.aairlines.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aairlines.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws Throwable {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/me_ra/eclipse-workspace/ReDoCerotidProject/src/main/java/com/aairlines/"
					+ "qa/config/config.properties");
					prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialization() {
		String browserName = prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	   driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
