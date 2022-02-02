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

	@FindBy(xpath = "//h1[@class='H2 field-mb-30 field-mt-0']")
	public WebElement pageHeading;

	private void getTextFreedomUnlimitedStep(String expected) {
		Base_class.common_methods.getText(pageHeading, expected);

	}

	public void FreedomUnlimitedSteps(String expected) {
		getTextFreedomUnlimitedStep(expected);
	}
}
