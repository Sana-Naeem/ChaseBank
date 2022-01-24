package chase.bank.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import chase.bank.base.Base_class;

public class Testing extends Base_class {
	
	@Test
		public void creditCardButtonTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(creditCardsPage.creditCardsButton));
		creditCardsPage.creditCardsButton.click();
		Thread.sleep(3000);
		
	}
}

