package com.aairlines.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenShotUtil {
	public void takeAAScreenshot(WebDriver driver, String screenshotname) throws IOException {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("./AA_Test_Screenshots/" + screenshotname + ".png"),true);
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
}
