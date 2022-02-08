package chase.bank.tests;

import org.testng.annotations.Test;
import chase.bank.base.Base_class;

public class Testing extends Base_class {

	@Test
	public void creditCardPageTest() throws InterruptedException {
		creditCardsPage.creditCardsPageSteps();
		applyNowPage.applyNowPageSteps();
		freedomUnlimitedAppPage.FreedomUnlimitedSteps("Let's get started.");
		applicantDetailsPage.applicantInfoSteps("Natalie", "Lopez");

	}
}
