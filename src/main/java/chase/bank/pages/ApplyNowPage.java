package chase.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chase.bank.base.Base_class;

public class ApplyNowPage {
	public ApplyNowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='button learn-more-btn hoverImgSwap chaseanalytics-track-link mvt-applynow' and text()='Apply Now'])[1]")
	public WebElement applyNowButton;

	private void clickApplyNowStep() {
		Base_class.common_methods.click(applyNowButton);
	}

	public void applyNowPageSteps() {
		clickApplyNowStep();

	}
}
