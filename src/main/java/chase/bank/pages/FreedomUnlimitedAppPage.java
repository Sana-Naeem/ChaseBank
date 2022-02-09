package chase.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chase.bank.base.Base_class;
import chase.bank.reporting.Logger;

public class FreedomUnlimitedAppPage {
	public FreedomUnlimitedAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath =  "//h1[contains(., 'get started.')]")
	public WebElement pageHeading;

	private void getTextFreedomUnlimitedStep(WebElement element, String expected) {
		Base_class.common_methods.getText(pageHeading, expected);

	}

	public void FreedomUnlimitedSteps(String expected) {
		Base_class.common_methods.sleep(15);
		Base_class.common_methods.switchWindow();
		Base_class.common_methods.sleep(5);
		Logger.log(Base_class.driver.getCurrentUrl());
		Logger.log(Base_class.driver.getTitle());
		getTextFreedomUnlimitedStep(pageHeading, expected);
	}
}
