package chase.bank.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import chase.bank.base.Base_class;
import chase.bank.utilities.Configurable;
import chase.bank.utilities.ExcelReader;


public class CreditCardsWithExtentReport extends Base_class{

ExtentReports report;
	
	@BeforeClass
	public void extentSetup() {
		report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		report.attachReporter(spark);
	}
	
	@DataProvider(name = "applicantDataExcel")
	public Object[][] getApplicantDataExcel(){
		String filePath = Configurable.getInstance().getExcelPath();
		int sheetNum = Configurable.getInstance().getSheetNum();
		ExcelReader reader = new ExcelReader(filePath, sheetNum);
		Object[][] data = reader.testData();
		return data;
	}
	
	@Test(dataProvider = "applicantDataExcel", groups = "auto")
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
	
		report.createTest("creditCardTestingWithExcelDataProvider").log(Status.PASS, "This Test case has been passed");
	}
	
	@Test
	public void test1() {
		report.createTest("test1").log(Status.FAIL, "This Test case has been Failed");
	}
	
	@Test
	public void test2() {
		report.createTest("test2").log(Status.PASS, "This Test case has been PASS");
	}
	
	@AfterClass
	public void finishReport() {
		report.flush();
	}
}
