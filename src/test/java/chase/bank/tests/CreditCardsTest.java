package chase.bank.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import chase.bank.base.Base_class;
import chase.bank.data.ApplicantInfoDataClass;
import chase.bank.reporting.Logger;
import chase.bank.utilities.Configurable;
import chase.bank.utilities.ExcelReader;


public class CreditCardsTest extends Base_class {

	@Test(enabled = true, priority = 1, groups = { "applicant" }) // regular way of running test
	public void creditCardPageTest() throws InterruptedException {
		creditCardsPage.creditCardsPageSteps();
		applyNowPage.applyNowPageSteps();
		freedomUnlimitedAppPage.FreedomUnlimitedSteps("Let's get started.");
		applicantDetailsPage.applicantInfoSteps("Natalie", "Lopez", "JR", "01/02/1994", "Ashley Lopez",
				"SOCIAL_SECURITY_NUMBER", "000-11-2222", "DOMESTIC", "2301 Westchester Ave", "10462", "Bronx", "NY",
				"Jasminelopez@hotmail.com", "123-321-1234", "RENT", "EMPLOYED", "50,000");

	}

	@DataProvider(name = "applicantData") // data provider annotation values are hard coded here so that multiple diff values can be put each time
	public Iterator<ApplicantInfoDataClass> getAutoData() {
		ArrayList<ApplicantInfoDataClass> list = new ArrayList<>();
		list.add(new ApplicantInfoDataClass("John", "Jay", "JR", "02/12/1980", "Grace Santos", "SOCIAL_SECURITY_NUMBER",
				"323-44-5324", "DOMESTIC", "2304 Westchester Ave", "10462", "Bronx", "NY", "JohnJay@gmail.com",
				"866-960-0890", "RENT", "EMPLOYED", "60,000"));
		
		
		// ApplicantInfoDataClass autoData1 = new ApplicantInfoDataClass("---enter
		// arguments");
		// list.add(autoData1); ------>this is another way to do it
		return list.iterator();
	}

	@DataProvider(name = "applicantDataExcel") //data provider annotation to use in excel no values put here
	public Object[][] getApplicantDataExcel() {
		String filePath = Configurable.getInstance().getExcelPath();
		int sheetNum = Configurable.getInstance().getSheetNum();
		ExcelReader reader = new ExcelReader(filePath, sheetNum);
		Object[][] data = reader.testData();
		return data;
	}

	@Test(dataProvider = "applicantData", groups = { "applicant" }) // running test with data provider annotation just add the data provider name for values no need to hard code 
	public void creditCardTestingWithIteratorDataProvider(ApplicantInfoDataClass applicantData) {
		creditCardsPage.creditCardsPageSteps();
		applyNowPage.applyNowPageSteps();
		freedomUnlimitedAppPage.FreedomUnlimitedSteps("Let's get started.");
		applicantDetailsPage.applicantInfoSteps(applicantData);

	}

	@Test(dataProvider = "applicantDataExcel", groups = { "applicant" }) 
	// running test with data provider for excel, values written in excel sheet, only variable names shown here
	public void creditCardTestingWithExcelDataProvider(String firstName, String lastName, String suffixValue,
			String dob, String mothersName, String taxID, String socialSecurityNum, String addressType,
			String streetAddress, String zipCode, String city, String state, String email, String phoneNum,
			String residence, String income, String grossIncome) {
		
		creditCardsPage.creditCardsPageSteps();
		applyNowPage.applyNowPageSteps();
		freedomUnlimitedAppPage.FreedomUnlimitedSteps("Let's get started.");
		applicantDetailsPage.applicantInfoSteps(firstName, lastName, suffixValue, dob, mothersName, taxID,
				socialSecurityNum, addressType, streetAddress, zipCode, city, state, email, phoneNum, residence, income,
				grossIncome);
	}
	
	@Test(dependsOnMethods = {"creditCardTesting"}, ignoreMissingDependencies = true)
	public void testMethodApplicant() {
		Logger.log("this is an auto related test 0");
	}
	
	@Test(groups = {"applicant"})
	public void testMethodApplicant1() {
		Logger.log("this is an auto related test 1");
	}

}
