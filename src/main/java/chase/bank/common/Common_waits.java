package chase.bank.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import chase.bank.base.Base_class;

public class Common_waits {

	public void waitUntilClickable(WebElement element) {
		try {
			Base_class.wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NullPointerException e) {
			System.out.println(element + " : Not Found");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void waitUntilVisible(WebElement element) {
		try {
			Base_class.wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NullPointerException e) {
			System.out.println(element + " : Not Found");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void waitUntilSelectable(WebElement element) {
		try {
			Base_class.wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (NullPointerException e) {
			System.out.println(element + " : Not Found");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
