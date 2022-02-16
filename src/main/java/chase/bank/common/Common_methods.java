package chase.bank.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;

import chase.bank.base.Base_class;
import chase.bank.reporting.Java_logger;
import chase.bank.reporting.Logger;

public class Common_methods {

	public void click(WebElement element) {
		try {
			Base_class.common_waits.waitUntilClickable(element);
			element.click();
			Java_logger.getLog(element + " clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Java_logger.getLog(element + " Element Not Found");
			Assert.fail();
		}
	}

	public String getText(WebElement element, String expected) {
		try {
			Base_class.common_waits.waitUntilVisible(element);
			Assert.assertEquals(element.getText(), expected);
			return element.getText();
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Java_logger.getLog(element + " Element Not Found");
			return element + " : Element Not Found";
		}
	}

	public void writeText(WebElement element, String value) {
		try {
			Base_class.common_waits.waitUntilClickable(element);
			element.sendKeys(value);
			Java_logger.getLog(element + " Text Value entered : " + value);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Java_logger.getLog(element + " Element Not Found");
			Assert.fail();
		}
	}

	public void selectDropDown(WebElement element, String value) {
		try {
			// Base_class.common_waits.waitUntilSelectable(element);
			Select select = new Select(element);
			select.selectByValue(value);
			Java_logger.getLog(value + " : Passed for the element, " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Java_logger.getLog(element + " Element Not Found");
			Assert.fail();
		}
	}

	public void scrollIntoViewTheElement(WebElement element) {
		try {
			Base_class.jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			Java_logger.getLog("Scrolling into element : " + element + ", Succeed");
		} catch (JavascriptException e) {
			e.printStackTrace();
			Java_logger.getLog("Scrolling into element : " + element + ", Failed");
			Assert.fail();
		}
	}

	public void switchWindow() {
		List<String> windows = new ArrayList<String>(Base_class.driver.getWindowHandles());
		Base_class.driver.switchTo().window(windows.get(1));
	}

	public void selectRadioButton(WebElement element) {
		try {
			// Base_class.common_waits.waitUntilSelectable(element);
			element.isSelected();
			Java_logger.getLog(element + ":Selected by visibility" + element);
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
			Java_logger.getLog("Element not found");
			Assert.fail();

		}
	}

	public static String addScreenShotToLocal(String testName) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy_HH.mm.ss");
		String dateString = dateFormat.format(date);

		File newScreenShot = new File("screenShots/" + testName + "_" + dateString + "_errorShot.png");
		TakesScreenshot screenshot = (TakesScreenshot) Base_class.driver;
		File srcLocation = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(srcLocation, new File(newScreenShot.getAbsolutePath()));
			Logger.log("Error Occured!!! \n" + "Screenshot has been saved here :" + newScreenShot.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			Logger.log("Screenshot cannot saved \n" + e.getLocalizedMessage());
		} 
		return newScreenShot.getAbsolutePath();
	}
 
	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
