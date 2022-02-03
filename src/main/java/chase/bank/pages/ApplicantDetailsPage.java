package chase.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chase.bank.base.Base_class;

public class ApplicantDetailsPage {

	public ApplicantDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='blx-nameBlock-firstName-text-validate-input-field']")
	public WebElement enterFirstName;
	@FindBy(xpath = "//input[@id='blx-nameBlock-lastName-text-validate-input-field']")
	public WebElement enterLastName;
	
	private void enterFirstNameStep(String value) {
		Base_class.common_methods.writeText(enterFirstName, value);
	}
	
	private void enterLastNameStep(String value) {
		Base_class.common_methods.writeText(enterLastName, value);
	}
	
	public void applicantInfoSteps(String firstName, String lastName) {
		enterFirstNameStep(firstName);
		enterLastNameStep(lastName);
	}
}
