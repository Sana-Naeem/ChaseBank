package chase.bank.tests;

import org.testng.annotations.Test;
import chase.bank.base.Base_class;

public class Testing extends Base_class {

	@Test
	public void creditCardPageTest() throws InterruptedException {
		creditCardsPage.creditCardsPageSteps();
		Thread.sleep(3000);
		applyNowPage.applyNowPageSteps();
		Thread.sleep(15000);
		freedomUnlimitedAppPage.FreedomUnlimitedSteps("Let's get started.");
		Thread.sleep(5000);

	}
}
