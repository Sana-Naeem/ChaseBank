package chase.bank.tests;


import org.testng.annotations.Test;
import chase.bank.base.Base_class;

public class Testing extends Base_class {

	@Test
	public void creditCardPageTest() throws InterruptedException {
		creditCardsPage.creditCardsPageSteps();
		applyNowPage.applyNowPageSteps();
		freedomUnlimitedAppPage.FreedomUnlimitedSteps("Let's get started.");
		applicantDetailsPage.applicantInfoSteps("Natalie", "Lopez", "JR", "01/02/1994", "Ashley Lopez", "SOCIAL_SECURITY_NUMBER", "000-11-2222", "DOMESTIC", "2301 Westchester Ave", "10462", "Bronx", "NY", "Jasminelopez@hotmail.com", "123-321-1234", "RENT", "EMPLOYED","50,000");

	}
}
