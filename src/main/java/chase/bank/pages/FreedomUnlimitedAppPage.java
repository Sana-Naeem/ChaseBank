package chase.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chase.bank.base.Base_class;

public class FreedomUnlimitedAppPage {
	public FreedomUnlimitedAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='No annual fee']")
	public WebElement annualFeeHeading;

	private void getTextFreedomUnlimitedStep(String expected) {
		Base_class.common_methods.getText(annualFeeHeading, expected);

	}

	public void FreedomUnlimitedSteps(String expected) {
		getTextFreedomUnlimitedStep(expected);
	}
}
