package chase.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chase.bank.base.Base_class;

public class CreditCardsPage {

	public CreditCardsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='carousel--custom-pager__link' and text()='Credit Cards']//parent::a[@tabindex='0']")
	public WebElement creditCardsButton;

	private void clickCreditCardStep() {
		Base_class.common_methods.click(creditCardsButton);
	}

	public void creditCardsPageSteps() {
		clickCreditCardStep();
	}
}
